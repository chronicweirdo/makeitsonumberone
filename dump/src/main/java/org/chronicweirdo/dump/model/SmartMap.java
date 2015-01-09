package org.chronicweirdo.dump.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 1/9/2015.
 */
public class SmartMap<T> {

    private Map<String, T> map = new HashMap<>();

    private String equalsKey;

    public void setEqualsKey(String equalsKey) {
        this.equalsKey = equalsKey;
    }

    public void put(String key, T value) {
        this.map.put(key, value);
    }

    public T get(String key) {
        return this.map.get(key);
    }

    public Collection<T> getValues(String key) {
        if (this.map.get(key) != null && this.map.get(key) instanceof Collection) {
            return (Collection<T>) this.map.get(key);
        } else {
            return null;
        }
    }

    public void add(String key, T value) {
        if (this.map.get(key) != null && this.map.get(key) instanceof Collection) {
            ((Collection<T>) this.map.get(key)).add(value);
        } else {
            this.map.put(key, value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmartMap other = (SmartMap) o;

        Object thisEqualsObject = (this.equalsKey == null) ? this.map : this.map.get(this.equalsKey);
        Object otherEqualsObject = (other.equalsKey == null) ? other.map : other.map.get(other.equalsKey);

        if (thisEqualsObject == null) {
            if (otherEqualsObject == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return thisEqualsObject.equals(otherEqualsObject);
        }
    }

    @Override
    public int hashCode() {
        if (equalsKey == null) {
            return map.hashCode();
        } else {
            if (map.get(equalsKey) == null) {
                return 0;
            } else {
                return map.get(equalsKey).hashCode();
            }
        }
    }
}
