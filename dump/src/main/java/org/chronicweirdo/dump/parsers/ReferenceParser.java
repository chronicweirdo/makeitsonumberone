package org.chronicweirdo.dump.parsers;

import org.chronicweirdo.dump.Util;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.Tag;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class will just create a model containing the url to the resource and the caption of the resource, if it has
 * one.
 * Created by scacoveanu on 12/30/2014.
 */
public class ReferenceParser implements Parser {

    @Override
    public Map parse(File file) {
        Map model = new HashMap();
        // get url to resource
        model.put("url", Util.getServerPath(file));
        // get image caption
        Set<String> captions = FileNameParser.parse(file).get(Tag.CAPTION.n());
        if (captions != null) {
            StringBuilder caption = new StringBuilder();
            for (String c: captions) {
                caption.append(c);
            }
            model.put("caption", caption.toString());
        }
        return model;
    }
}
