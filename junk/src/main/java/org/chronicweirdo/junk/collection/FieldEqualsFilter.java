package org.chronicweirdo.junk.collection;

/**
 * Created by scacoveanu on 6/24/2014.
 */
public class FieldEqualsFilter extends FieldFilter {

    private Object value;

    public FieldEqualsFilter(String fieldName, Object value) {
        super(fieldName);
        this.value = value;
    }

    @Override
    public boolean filter(Object object) {
        try {
            Object fieldValue = getFieldValue(object);
            if (fieldValue == null) {
                if (value == null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return fieldValue.equals(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
