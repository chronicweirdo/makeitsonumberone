package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by scacoveanu on 4/23/2014.
 */
public class GenericApi {

    private static final Logger log = Logger.getLogger(GenericApi.class);

    private HttpClient client;
    private String server;

    public GenericApi(HttpClient client, String server) {
        this.client = client;
        this.server = server;
    }

    public void executeGet(String path, String parameters, String outputFile) {
        String result = executeGet(path, parameters);
        Util.writeToFile(result, outputFile);
    }

    public void executeGet(String path, List<Pair> parameters, String outputFile) {
        String result = executeGet(path, parameters);
        Util.writeToFile(result, outputFile);
    }

    public String executeGet(String path, List<Pair> parameters) {
        if (log.isInfoEnabled()) {
            for (Pair parameter: parameters) {
                log.info("parameter: " + parameter.getKey() + " = " + parameter.getValue());
            }
        }
        // build url
        StringBuilder url = new StringBuilder();
        String prefix = "";
        for (Pair parameter: parameters) {
            url.append(prefix);
            url.append(parameter.getKey());
            url.append("=");
            url.append(parameter.getValue());
            prefix = "&";
        }
        return executeGet(path, url.toString());
    }
    public String executeGet(String path, String parameters) {
        log.info("executing GET request");
        log.info("path: " + path);
        log.info("parameters: " + parameters);
        log.info("parameters.length: " + parameters.length());

        GetMethod get = new GetMethod(server + path + "?" + parameters);
        try {
            client.executeMethod(get);
        } catch (IOException e) {
            log.error(e, e);
        }
        String result = Util.getResponseBody(get);
        return result;
    }

    public void executePost(String path, List<Pair> parameters, String outputFile) {
        String result = executePost(path, parameters);
        Util.writeToFile(result, outputFile);
    }

    public String executePost(String path, List<Pair> parameters) {
        log.info("executing POST request");
        log.info("path: " + path);
        if (log.isInfoEnabled()) {
            for (Pair parameter: parameters) {
                log.info("parameter: " + parameter.getKey() + " = " + parameter.getValue());
            }
        }

        // build request
        PostMethod post = new PostMethod(server + path);
        for (Pair parameter: parameters) {
            post.addParameter(parameter.getKey(), parameter.getValue());
        }
        try {
            client.executeMethod(post);
        } catch (IOException e) {
            log.error(e);
        }
        String result = Util.getResponseBody(post);
        return result;
    }


}
