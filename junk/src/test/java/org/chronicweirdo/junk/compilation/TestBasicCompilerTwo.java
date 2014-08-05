package org.chronicweirdo.junk.compilation;

import org.junit.Test;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.SecureClassLoader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 8/5/2014.
 */
public class TestBasicCompilerTwo {

    @Test
    public void compileFile() throws Exception {
        // get the compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // create a diagnostic collector for compilation errors
        DiagnosticCollector diagnosticsCollector = new DiagnosticCollector();

        // instantiate the file manager - see implementation below
        JavaFileManager fileManager = new InterceptorFileManager(compiler.getStandardFileManager(diagnosticsCollector, null, null));

        // create java code string as a file object - see implementation below
        JavaFileObject javaObjectFromString = new JavaSourceFromString("ServiceInterfaceImpl", "" +
                "package org.chronicweirdo.junk.compilation;" +
                "public class ServiceInterfaceImpl implements org.chronicweirdo.junk.compilation.ServiceInterface {" +
                "public String message() {" +
                "return \"This compilation worked, yeeeeeeea!\";" +
                "}" +
                "}");

        // prepare and make the call to compile the code
        Iterable fileObjects = Arrays.asList(javaObjectFromString);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);
        Boolean result = task.call();



        if(result){
            System.out.println("Compilation has succeeded");

            // get the class loader from our own implementation of the file manager
            //ClassLoader classLoader = new URLClassLoader(new URL[] {new File("./").toURI().toURL()});
            ClassLoader classLoader = fileManager.getClassLoader(StandardLocation.CLASS_OUTPUT);
            //ClassLoader classLoader = fileManager.getClassLoader(StandardLocation.SOURCE_OUTPUT);
            System.out.println(classLoader);
            // load the class
            Class clazz = classLoader.loadClass("org.chronicweirdo.junk.compilation.ServiceInterfaceImpl");
            // instantiate the class
            ServiceInterface service = (ServiceInterface) clazz.newInstance();
            // call method
            System.out.println(service.message());
        }else{
            System.out.println("Compilation fails.");

            // print compilation errors, if any
            List<Diagnostic> diagnostics = diagnosticsCollector.getDiagnostics();
            for(Diagnostic<? extends JavaFileObject> d : diagnostics){
                System.out.println(d.getLineNumber());
                System.out.println(d.getSource().toUri());
            }
        }
        fileManager.close();
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

    public class InterceptorFileManager extends ForwardingJavaFileManager {
        public InterceptorFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            System.out.println(location);
            return super.getJavaFileForOutput(location, className, kind, sibling);
        }

        @Override
        public ClassLoader getClassLoader(Location location) {
            ClassLoader loader = super.getClassLoader(location);
            System.out.println(loader);
            return loader;
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
            System.out.println("location: " + location);
            System.out.println("class name: " + className);
            System.out.println("kind: " + kind);
            jclassObject = new JavaClassObject(className, kind);
            return jclassObject;
        }
    }

}
