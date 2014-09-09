package com.ingenuity.temp.apiupload;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 9/8/2014.
 */
public class MainConsoleTest {

    @org.junit.Test
    public void columnMappingTest() throws Exception {
        List<String> columnMapping = new ArrayList<String>();
        Integer index = Integer.parseInt("column3".substring("column".length()));
        assertTrue(index.equals(3));
        MainConsole.setColumnMapping(columnMapping, 3, "test");
        assertEquals(columnMapping.size(), 3);
        assertEquals(columnMapping.get(0), "");
        assertEquals(columnMapping.get(1), "");
        assertEquals(columnMapping.get(2), "test");

    }
}
