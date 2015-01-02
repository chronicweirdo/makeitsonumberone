package org.chronicweirdo.dump.scanners;

import org.chronicweirdo.dump.model.Post;

import java.io.File;

/**
 * Created by Silviu on 1/2/2015.
 */
public interface Scanner {

    Post scan(File file);
}
