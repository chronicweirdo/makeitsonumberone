package com.chronicweirdo;

import com.chronicweirdo.fitnesse.RandomText;
import junit.framework.TestCase;

/**
 * Created by scacoveanu on 4/28/2014.
 */
public class TestRandomText extends TestCase {

    private RandomText randomText;

    public void setUp() throws Exception {
        this.randomText = new RandomText();
    }

    public void testQuestion1() {
        randomText.setQuestion("name");
        assertEquals("silviu", randomText.answer());
    }

    public void testQuestion2() {
        randomText.setQuestion("age");
        assertEquals("132", randomText.answer());
    }
}
