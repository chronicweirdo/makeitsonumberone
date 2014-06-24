package org.chronicweirdo.junk.collection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by scacoveanu on 6/24/2014.
 */
public class CollectionFilter<T> {

    private List<FieldFilter> filters = new ArrayList<FieldFilter>();

    public CollectionFilter(FieldFilter ... filters) {
        for (FieldFilter filter: filters) {
            this.filters.add(filter);
        }
    }


    public Collection<T> filter(Collection<T> collection) {
        Collection<T> result = new ArrayList<T>();
        for (T item: collection) {
            if (matches(item)) {
                result.add(item);
            }
        }
        return result;
    }

    private boolean matches(T item) {
        for (FieldFilter filter: this.filters) {
            if (! filter.filter(item)) {
                return false;
            }
        }
        // all conditions passed
        return true;
    }
}
