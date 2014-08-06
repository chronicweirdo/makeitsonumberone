package org.chronicweirdo.junk.compilation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 8/6/2014.
 */
public class CompilerTest {

    public static final String MESSAGE = "This compilation worked, yeeeeeeea!";
    private String code;

    @Before
    public void setUp() throws Exception {
        code = "package org.chronicweirdo.junk.compilation;" +
            "public class ServiceInterfaceImpl implements org.chronicweirdo.junk.compilation.ServiceInterface {" +
            "public String message() {" +
                "return \"" + MESSAGE + "\";" +
            "}" +
            "}";
    }

    @Test
    public void getGroup() throws Exception {
        String pattern = "\\Qpackage\\E\\s+([^;]+);";
        String result = Compiler.getGroup(pattern, code, 1);
        assertEquals("org.chronicweirdo.junk.compilation", result);
    }

    @Test
    public void getPackage() throws Exception {
        assertEquals(Compiler.getPackage(code), "org.chronicweirdo.junk.compilation");
    }

    @Test
    public void getClassName() throws Exception {
        assertEquals(Compiler.getClassName(code), "ServiceInterfaceImpl");
    }

    @Test
    public void compileAndInstantiate() throws Exception {
        Object result = Compiler.compileAndInstantiate(code);
        assertTrue(result instanceof ServiceInterface);
        ServiceInterface service = (ServiceInterface) result;
        assertEquals(service.message(), MESSAGE);
    }
}
