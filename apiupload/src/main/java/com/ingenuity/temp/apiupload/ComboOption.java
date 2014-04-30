package com.ingenuity.temp.apiupload;

/**
 * Created by scacoveanu on 4/30/2014.
 */
public class ComboOption {

    private String value;
    private String description;

    public ComboOption(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return value + " (" + description + ")";
    }
}
