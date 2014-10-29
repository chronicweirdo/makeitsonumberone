package net.mwahaha.service;

import org.junit.Test;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class FileNameInterpreterTest {

    @Test
    public void splitTags() throws Exception {
        FileNameInterpreter interpreter = new FileNameInterpreter();
        System.out.println(interpreter.splitTags("mwahaha [test] test [this [is]]"));
    }
}
