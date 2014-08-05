package org.chronicweirdo.junk.compilation;

import org.junit.Test;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 8/5/2014.
 */
public class TestBasicCompiler {

    @Test
    public void compileFile() throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector diagnosticsCollector =
                new DiagnosticCollector();
        //StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
        JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(diagnosticsCollector, null, null));

        System.out.println(fileManager);
        JavaFileObject javaObjectFromString = new JavaSourceFromString("ServiceInterfaceImpl", "" +
                "package org.chronicweirdo.junk.compilation;" +
                "public class ServiceInterfaceImpl implements org.chronicweirdo.junk.compilation.ServiceInterface {" +
                "public String message() {" +
                "return \"This compilation worked, yeeeeeeea!\";" +
                "}" +
                "}");
        Iterable fileObjects = Arrays.asList(javaObjectFromString);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);
        Boolean result = task.call();
        List<Diagnostic> diagnostics = diagnosticsCollector.getDiagnostics();
        for(Diagnostic d : diagnostics){
            System.out.println(d.toString());
        }
        if(result == true){
            System.out.println("Compilation has succeeded");

            //Class<?> clazz = Class.forName("ServiceInterfaceImpl");
            ClassLoader classLoader = fileManager.getClassLoader(null);
            Class clazz = classLoader.loadClass("org.chronicweirdo.junk.compilation.ServiceInterfaceImpl");
            ServiceInterface service = (ServiceInterface) clazz.newInstance();
            System.out.println(service.message());
        }else{
            System.out.println("Compilation fails.");
        }
    }

    //@Test
    public void compileText() throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        List<JavaSourceFromString> list = new ArrayList<JavaSourceFromString>(1);
        list.add(new JavaSourceFromString("ServiceInterfaceImpl", "" +
                /*"package org.chronicweirdo.junk.compilation;" +*/
                "public class ServiceInterfaceImpl implements org.chronicweirdo.junk.compilation.ServiceInterface {" +
                "public String message() {" +
                "return \"This compilation worked!\";" +
                "}" +
                "}"));
        JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, null, null, list);
        boolean worked = task.call();
        System.out.println(worked);

        if (worked) {
            Class<?> clazz = Class.forName("ServiceInterfaceImpl");
            ServiceInterface service = (ServiceInterface) clazz.newInstance();
            System.out.println(service.message());
        }
    }

    private class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

        private JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return code;
        }
    }

    public class JavaClassObject extends SimpleJavaFileObject {

        /**
         * Byte code created by the compiler will be stored in this
         * ByteArrayOutputStream so that we can later get the
         * byte array out of it
         * and put it in the memory as an instance of our class.
         */
        protected final ByteArrayOutputStream bos =
                new ByteArrayOutputStream();

        /**
         * Registers the compiled class object under URI
         * containing the class full name
         *
         * @param name Full name of the compiled class
         * @param kind Kind of the data. It will be CLASS in our case
         */
        public JavaClassObject(String name, Kind kind) {
            super(URI.create("string:///" + name.replace('.', '/')
                    + kind.extension), kind);
        }

        /**
         * Will be used by our file manager to get the byte code that
         * can be put into memory to instantiate our class
         *
         * @return compiled byte code
         */
        public byte[] getBytes() {
            return bos.toByteArray();
        }

        /**
         * Will provide the compiler with an output stream that leads
         * to our byte array. This way the compiler will write everything
         * into the byte array that we will instantiate later
         */
        @Override
        public OutputStream openOutputStream() throws IOException {
            return bos;
        }
    }

    public class ClassFileManager extends
            ForwardingJavaFileManager {
        /**
         * Instance of JavaClassObject that will store the
         * compiled bytecode of our class
         */
        private JavaClassObject jclassObject;

        /**
         * Will initialize the manager with the specified
         * standard java file manager
        */
        public ClassFileManager(StandardJavaFileManager
                                        standardManager) {
            super(standardManager);
        }

        /**
         * Will be used by us to get the class loader for our
         * compiled class. It creates an anonymous class
         * extending the SecureClassLoader which uses the
         * byte code created by the compiler and stored in
         * the JavaClassObject, and returns the Class for it
         */
        @Override
        public ClassLoader getClassLoader(Location location) {
            return new SecureClassLoader() {
                @Override
                protected Class<?> findClass(String name)
                        throws ClassNotFoundException {
                    byte[] b = jclassObject.getBytes();
                    return super.defineClass(name, jclassObject
                            .getBytes(), 0, b.length);
                }
            };
        }

        /**
         * Gives the compiler an instance of the JavaClassObject
         * so that the compiler can write the byte code into it.
         */
        @Override
        public JavaFileObject getJavaFileForOutput(Location location,
                                                   String className, JavaFileObject.Kind kind, FileObject sibling)
                throws IOException {
            jclassObject = new JavaClassObject(className, kind);
            return jclassObject;
        }
    }

}
