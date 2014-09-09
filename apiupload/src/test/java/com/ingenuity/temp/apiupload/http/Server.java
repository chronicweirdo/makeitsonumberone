package com.ingenuity.temp.apiupload.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
            InputStreamReader reader = new InputStreamReader(httpExchange.getRequestBody());
            char[] buffer = new char[1024];
            StringBuilder builder = new StringBuilder();
            while (reader.read(buffer) != -1) {
                builder.append(buffer);
            }
            System.out.println(builder.toString());
            String response = "this is the response";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}
