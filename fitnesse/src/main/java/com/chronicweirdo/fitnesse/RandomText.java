package com.chronicweirdo.fitnesse;

import fit.ColumnFixture;

/**
 * Created by scacoveanu on 4/28/2014.
 */
public class RandomText extends ColumnFixture {

    private String question;

    public void setQuestion(String question) {
        this.question = question;
    }

    public String answer() {
        if (question.equals("name")) return "silviu";
        if (question.equals("age")) return "132";
        return "";
    }
}
