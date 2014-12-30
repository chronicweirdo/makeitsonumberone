package org.chronicweirdo.dump.parsers;

import java.io.File;
import java.util.Map;

/**
 * Created by scacoveanu on 12/30/2014.
 */
public interface Parser {

    Map parse(File file);
}
