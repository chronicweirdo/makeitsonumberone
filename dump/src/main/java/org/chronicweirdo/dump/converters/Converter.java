package org.chronicweirdo.dump.converters;

import java.util.Map;

/**
 * Converts one or more models to another model.
 *
 * Created by scacoveanu on 1/5/2015.
 */
public interface Converter {

    Map convert(Map ... models);
}
