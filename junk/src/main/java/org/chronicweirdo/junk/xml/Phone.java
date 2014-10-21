package org.chronicweirdo.junk.xml;

/**
 * Created by scacoveanu on 10/21/2014.
 */
public class Phone {

    private String code;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "code='" + code + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
