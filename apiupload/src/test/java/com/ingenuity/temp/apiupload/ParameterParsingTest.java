package com.ingenuity.temp.apiupload;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by scacoveanu on 5/28/2014.
 */

public class ParameterParsingTest {

    @Test
    public void testParsingEmptyString() throws Exception {
        String parameters = "";
        MainUI mainUI = new MainUI();
        List<Pair> result = mainUI.parseParameters(parameters);
        assertEquals(result.size(), 0);
    }

}
