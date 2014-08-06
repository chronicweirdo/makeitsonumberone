package org.chronicweirdo.junk.compilation;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.security.SecureClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 8/6/2014.
 */
public class Compiler {

    protected static String getGroup(String pattern, String text, int group) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(group);
        }
        return null;
    }

    protected static String getPackage(String code) {
        return getGroup("\\Qpackage\\E\\s+([^;]+);", code, 1);
    }

    protected static String getClassName(String code) {
        return getGroup("\\Qclass\\E\\s+([^\\s]+)", code, 1);
    }

    public static Object compileAndInstantiate(String code) throws Exception {
        // get the compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // create a diagnostic collector for compilation errors
        DiagnosticCollector diagnosticsCollector = new DiagnosticCollector();

        // instantiate the file manager - see implementation below
        JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(diagnosticsCollector, null, null));

        // create java code string as a file object - see implementation below
        String className = getClassName(code);
        String packageName = getPackage(code);
        JavaFileObject javaObjectFromString = new JavaSourceFromString(className, code);

        // prepare and make the call to compile the code
        Iterable fileObjects = Arrays.asList(javaObjectFromString);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);
        Boolean result = task.call();

        // print compilation errors, if any
        List<Diagnostic> diagnostics = diagnosticsCollector.getDiagnostics();
        for(Diagnostic d : diagnostics){
            System.out.println(d.toString());
        }

        if(result == true){
            //System.out.println("Compilation has succeeded");

            // get the class loader from our own implementation of the file manager
            ClassLoader classLoader = fileManager.getClassLoader(null);
            // load the class
            String fullyQualifiedName = packageName + "." + className;
            Class clazz = classLoader.loadClass(fullyQualifiedName);
            // instantiate the class
            Object object = clazz.newInstance();
            return object;
        }else{
            // compilation failed
            //System.out.println("Compilation fails.");
            return null;
        }
    }

    private static class JavaSourceFromString extends SimpleJavaFileObject {
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

    public static class JavaClassObject extends SimpleJavaFileObject {

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

    public static class ClassFileManager extends
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
