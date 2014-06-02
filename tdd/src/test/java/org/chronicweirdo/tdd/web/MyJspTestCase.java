package org.chronicweirdo.tdd.web;

import net.sf.jsptest.HtmlTestCase;

/**
 * Created by scacoveanu on 6/2/2014.
 */
public class MyJspTestCase extends HtmlTestCase {

    @Override
    protected String getWebRoot() {
        return "tdd/src/main/webapp/jsp";
    }
}
