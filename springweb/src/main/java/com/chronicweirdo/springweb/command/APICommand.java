package com.chronicweirdo.springweb.command;

/**
 * Created by scacoveanu on 6/23/2014.
 */
public class APICommand {

    private String methodName;
    private String[] geneId;

    public String[] getGeneId() {
        return geneId;
    }

    public void setGeneId(String[] geneId) {
        this.geneId = geneId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
