package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by scacoveanu on 4/23/2014.
 */
public class GenericApi {

    private static final Logger log = Logger.getLogger(GenericApi.class);
    public static final String LOG_INDENTATION = "\t";
    public static final String HEADER_LOCATION = "Location";

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
        String parametersString = concatenateParameters(parameters);
        return executeGet(path, parametersString);
    }

    private String concatenateParameters(List<Pair> parameters) {
        StringBuilder builder = new StringBuilder();
        String prefix = "";
        for (Pair parameter: parameters) {
            builder.append(prefix);
            builder.append(parameter.getKey());
            builder.append("=");
            builder.append(parameter.getValue());
            prefix = "&";
        }
        return builder.toString();
    }
    public String executeGet(String path, String parameters) {
        log.info("path: " + path);
        log.info("parameters: " + parameters);
        log.info("parameters.length: " + parameters.length());
        log.info("executing GET request: " + server + path + "?" + parameters);

        GetMethod get = new GetMethod(server + path + "?" + parameters);
        try {
            client.executeMethod(get);
        } catch (IOException e) {
            log.error(e, e);
        }
        String result = Util.getResponseBody(get);
        return result;
    }

    public void executePost(String path, List<Pair> parameters, String outputFile, boolean openIPA) {
        String result = executePost(path, parameters, openIPA);
        log.info("RESULT:\n" + result);
        Util.writeToFile(result, outputFile);
    }

    public void executePost(String path, List<Pair> parameters, String outputFile, boolean openIPA,
                            String filePath, List<String> columnMapping) {
        String result = executePost(path, parameters, openIPA, filePath, columnMapping);
        log.info("RESULT:\n" + result);
        Util.writeToFile(result, outputFile);
    }

    public String executePost(String path, List<Pair> parameters, boolean openIPA) {
        log.info("executing POST request at address: " + server + path);
        log.info("sending " + parameters.size() + " post parameters");
        if (log.isDebugEnabled()) {
            log.debug("listing POST parameters (order is important):");
            for (Pair parameter: parameters) {
                log.debug(LOG_INDENTATION + parameter.getKey() + " = " + parameter.getValue());
            }
        }
        //String parametersString = concatenateParameters(parameters);
        //log.info("full URL:");
        //log.info(server + path + "?" + parametersString);

        // build request
        PostMethod post = new PostMethod(server + path);
        /*for (Pair parameter: parameters) {
            post.addParameter(parameter.getKey(), parameter.getValue());
        }*/
        //post.setRequestEntity(new APIRequestEntity(parameters));
        post.setRequestEntity(new PreprocessingAPIRequestEntity(parameters));
        try {
            //log.info("request entity content length in bytes: " + post.getRequestEntity().getContentLength());
            //log.info("request entity content length in MB: " + (((double) post.getRequestEntity().getContentLength()) / 1000 / 1000 ));
            log.info("request content type: " + post.getRequestEntity().getContentType());
            client.executeMethod(post);
        } catch (IOException e) {
            log.error(e);
        }

        String result = Util.getResponseBody(post);
        if (openIPA) {
            openIPA(post);

        }
        return result;
    }

    public void openIPA(PostMethod post) {
        // try to open IPA using the default browser
        Header locationHeader = post.getResponseHeader(HEADER_LOCATION);
        if (locationHeader != null) {
            log.info("opening URL " + locationHeader.getValue() + " in default internet " +
                    "browser");
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(locationHeader.getValue()));
                } catch (IOException e) {
                    log.error(e, e);
                } catch (URISyntaxException e) {
                    log.error(e, e);
                }
            } else {
                log.warn("can't access default browser on current platform!");
            }
        } else {
            log.warn("no location header was found in response!");
        }
    }

    public String executePost(String path, List<Pair> parameters, boolean openIPA, String filePath,
                              List<String> columnMapping) {
        log.info("executing POST request at address: " + server + path);
        log.info("sending " + parameters.size() + " post parameters");

        // build request
        PostMethod post = new PostMethod(server + path);
        post.setRequestEntity(new FileReaderPreprocessingRequestEntity(parameters, filePath, columnMapping));
        try {
            client.executeMethod(post);
        } catch (IOException e) {
            log.error(e);
        }

        String result = Util.getResponseBody(post);
        if (openIPA) {
            openIPA(post);
        }
        return result;
    }


}
