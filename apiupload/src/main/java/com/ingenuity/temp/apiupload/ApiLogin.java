package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by scacoveanu on 4/23/2014.
 */
public class ApiLogin {

    private static final Logger log = Logger.getLogger(ApiLogin.class);
    private static final String HEADER_LOCATION = "Location";
    private static final String PARAMETER_USERNAME = "username";
    private static final String PARAMETER_PASSWORD = "password";
    private static final String PARAMETER_EVENT_ID = "_eventId";
    private static final String VALUE_EVENT_ID = "submit";
    private static final String PARAMETER_LOGIN_TICKET = "lt";

    private String username;
    private String password;
    private String server;
    private boolean loginExecuted = false;
    private boolean loginSuccessful = false;

    public ApiLogin(String username, String password, String server) {
        this.username = username;
        this.password = password;
        this.server = server;
    }

    public HttpClient getClient() {
        HostConfiguration config = new HostConfiguration();
        config.setProxy("127.0.0.1", 8888);
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setSoTimeout(0);
        //client.setHostConfiguration(config);


        log.info("execute a get to the server");
        GetMethod get = new GetMethod(server);
        try {
            client.executeMethod(get);
        } catch (IOException e) {
            log.error(e);
        }

        log.info("check if we are redirected");
        while (get.getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            get.releaseConnection();
            Header location = get.getResponseHeader(HEADER_LOCATION);
            get = new GetMethod(location.getValue());
            try {
                client.executeMethod(get);
            } catch (IOException e) {
                log.error(e);
            }
        }
        log.info("get response body and close");
        String getContent = Util.getResponseBody(get);
        get.releaseConnection();

        log.info("server address: " + server);
        String url = null;
        try {
            url = get.getURI().toString();
        } catch (URIException e) {
            log.error(e);
        }
        log.info("final get address: " + url);

        if (!url.startsWith(server)) {
            loginExecuted = true;
            log.info("build post for login");
            PostMethod post = new PostMethod(url);
            post.addParameter(PARAMETER_USERNAME, username);
            post.addParameter(PARAMETER_PASSWORD, password);
            post.addParameter(PARAMETER_EVENT_ID, VALUE_EVENT_ID);
            post.addParameter(PARAMETER_LOGIN_TICKET, ticket(getContent));

            try {
                client.executeMethod(post);
            } catch (IOException e) {
                log.error(e);
            }
            log.info("handle redirects");
            while(post.getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                post.releaseConnection();
                Header location = post.getResponseHeader(HEADER_LOCATION);
                post = new PostMethod(location.getValue());
                try {
                    client.executeMethod(post);
                } catch (IOException e) {
                    log.error(e);
                }
            }
            post.releaseConnection();

            log.info("server address: " + server);
            url = null;
            try {
                url = post.getURI().toString();
            } catch (URIException e) {
                log.error(e);
            }
            log.info("final post address: " + url);
            if (url.startsWith(server)) {
                loginSuccessful = true;
            }
        }

        log.info("return logged in client");
        return client;
    }



    private String ticket(String content) {
        String k = "name=\"lt\" value=\"";
        int s = content.indexOf(k) + k.length();
        String ticket = content.substring(s, content.indexOf("\"", s));
        return ticket;
    }

    public boolean isLoginExecuted() {
        return loginExecuted;
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }
}
