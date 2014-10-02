package org.chronicweirdo.patcher.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by scacoveanu on 10/2/2014.
 */
public class EchoClient {

    public void start() {
        String host = "localhost";
        int port = EchoServer.PORT;

        try {
            Socket echoSocket = new Socket(host, port);

            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            String message = "message";
            out.println(message);
            String returnLine;
            while ((returnLine = in.readLine()) != null) {
                System.out.println("[client] " + returnLine);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
