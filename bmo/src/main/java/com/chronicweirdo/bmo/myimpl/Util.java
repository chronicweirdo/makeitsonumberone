package com.chronicweirdo.bmo.myimpl;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;

/**
 * Created by scacoveanu on 5/7/2014.
 */
public class Util {

    static boolean isComposedTextElement(Element elem) {
        AttributeSet as = elem.getAttributes();
        return isComposedTextAttributeDefined(as);
    }

    static boolean isComposedTextAttributeDefined(AttributeSet as) {
        return ((as != null) &&
                (as.isDefined(StyleConstants.ComposedTextAttribute)));
    }
}
