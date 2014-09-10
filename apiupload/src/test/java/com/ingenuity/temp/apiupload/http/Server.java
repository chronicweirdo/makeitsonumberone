package com.ingenuity.temp.apiupload.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * Created by Silviu on 9/9/14.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.createContext("/pa/api/v1/dataupload", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("HEADERS:");
            for (Map.Entry<String, List<String>> entry: httpExchange.getRequestHeaders().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
            System.out.println("CONTENT:");
            //StringBuilder builder = new StringBuilder();
            /*InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody());
            char[] buffer = new char[1024];
            while (reader.read(buffer) != -1) {
                builder.append(buffer);
            }*/
            StringWriter writer = new StringWriter();
            IOUtils.copy(httpExchange.getRequestBody(), writer, "UTF-8");
            String content = writer.toString();
            System.out.println("content length: " + content.length());
            System.out.println(content);
            System.out.println();
            System.out.println();
            String response = "this is the response";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}
