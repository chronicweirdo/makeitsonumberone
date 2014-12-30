package org.chronicweirdo.dump.parsers;

import org.chronicweirdo.dump.Util;
import org.chronicweirdo.dump.service.FileNameParser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 12/30/2014.
 */
public class ImageParser implements Parser {

    @Override
    public Map parse(File file) {
        Map model = new HashMap();
        // get url to resource
        model.put("url", Util.getServerPath(file));
        // get image caption
        model.put("caption", FileNameParser.parse(file.getName()).get(FileNameParser.CAPTION));
        return model;
    }
}
