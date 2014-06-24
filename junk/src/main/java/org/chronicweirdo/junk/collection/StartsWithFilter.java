package org.chronicweirdo.junk.collection;

/**
 * Created by scacoveanu on 6/24/2014.
 */
public class StartsWithFilter extends FieldFilter {
    private String value;

    public StartsWithFilter(String fieldName, String value) {
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
                if (value == null) {
                    return false;
                }
                String stringValue = fieldValue.toString();
                return stringValue.startsWith(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
