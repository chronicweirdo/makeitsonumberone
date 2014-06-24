package org.chronicweirdo.junk.collection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by scacoveanu on 6/24/2014.
 */
public abstract class FieldFilter {

    private String fieldName;

    protected FieldFilter(String fieldName) {
        this.fieldName = fieldName;
    }

    public abstract boolean filter(Object object);

    private String getMethodName(String fieldName) {
        String uppercaseFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        return "get" + uppercaseFieldName;
    }

    protected Object getFieldValue(Object object) throws Exception {
        Class c = object.getClass();
        String methodName = getMethodName(fieldName);
        Method method = c.getMethod(methodName);
        Object fieldValue = method.invoke(object);
        return fieldValue;
    }
}
