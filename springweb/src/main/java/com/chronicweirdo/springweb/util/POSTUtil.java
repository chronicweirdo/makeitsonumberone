package com.chronicweirdo.springweb.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 6/23/2014.
 */
public class POSTUtil {

    private static final Logger log = Logger.getLogger(POSTUtil.class);

    public static String executePost(String path, List<Pair> parameters) {
        log.info("executing POST request at address: " + path);
        log.info("sending " + parameters.size() + " post parameters");
        log.info("sending " + parameters.size() + " parameters");
        if (log.isDebugEnabled()) {
            log.debug("listing POST parameters (order is important):");
            for (Pair parameter: parameters) {
                log.debug(parameter.getKey() + " = " + parameter.getValue());
            }
        }
        //String parametersString = concatenateParameters(parameters);
        //log.info("full URL:");
        //log.info(server + path + "?" + parametersString);

        // build request
        PostMethod post = new PostMethod(path);
        for (Pair parameter: parameters) {
            post.addParameter(parameter.getKey(), parameter.getValue());
        }
        try {
            log.info("request entity content length in bytes: " + post.getRequestEntity().getContentLength());
            log.info("request entity content length in MB: " + (((double) post.getRequestEntity().getContentLength()) / 1000 / 1000 ));
            HttpClient client = new HttpClient();
            client.executeMethod(post);
        } catch (IOException e) {
            log.error(e);
        }

        String result = getResponseBody(post);

        return result;
    }

    public static String getResponseBody(HttpMethodBase m) {
        InputStream stream = null;
        try {
            stream = m.getResponseBodyAsStream();
            for (Header header: m.getResponseHeaders()) {
                System.out.println(header.getName() + " : " + header.getValue());
            }
        } catch (IOException e) {
            log.error(e);
        }
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(stream, writer);
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
        return writer.toString();
    }

    public static void main(String[] args) {
        List<Pair> parameters = new ArrayList<>();
        parameters.add(new Pair("methodName", "testMethod"));
        parameters.add(new Pair("geneId", "1"));
        parameters.add(new Pair("geneId", "2"));
        POSTUtil.executePost("http://localhost:8080/api", parameters);
    }
}
