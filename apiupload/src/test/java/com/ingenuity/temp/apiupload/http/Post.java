package com.ingenuity.temp.apiupload.http;

import com.ingenuity.temp.apiupload.Util;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Silviu on 9/9/14.
 */
public class Post {

    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        String path = "http://localhost:8000/test";
        runPost(client, path);
        runRequestEntityPost(client, path);
    }

    public static void runPost(HttpClient client, String path) {
        PostMethod post = new PostMethod(path);
        post.addParameter("param1", "test1");
        post.addParameter("param2", "test2");
        post.addParameter("param2", "test3");
        GetMethod get = new GetMethod(path);
        try {
            client.executeMethod(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = Util.getResponseBody(post);
        System.out.println(result);
    }

    public static void runRequestEntityPost(HttpClient client, String path) {
        PostMethod post = new PostMethod(path);
        post.setRequestEntity(new RequestEntity() {
            public boolean isRepeatable() {
                return true;
            }

            public void writeRequest(OutputStream outputStream) throws IOException {
                OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                writer.write("param1=test1&param2=test2&param2=test3");
                writer.flush();
            }

            public long getContentLength() {
                return -1;
            }

            public String getContentType() {
                return "application/x-www-form-urlencoded";
            }
        });
        try {
            client.executeMethod(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = Util.getResponseBody(post);
        System.out.println(result);
    }
}
