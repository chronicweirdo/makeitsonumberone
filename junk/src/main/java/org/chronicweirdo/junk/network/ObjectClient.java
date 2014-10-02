package org.chronicweirdo.junk.network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by scacoveanu on 10/2/2014.
 */
public class ObjectClient {

    private String host;

    public ObjectClient() {
        host = "localhost";
    }

    public ObjectClient(String host) {
        this.host = host;
    }

    public Message send(Message message) {

        int port = EchoServer.PORT;

        Message response = null;

        Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            // connect to server
            System.out.println("[client] connecting to server");
            echoSocket = new Socket(host, port);

            // get streams
            System.out.println("[client] opening streams");
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());

            // send message
            System.out.println("[client] sending message " + message);
            out.writeObject(message);
            out.flush();

            System.out.println("[client] reading response");
            // read response
            response = (Message) in.readObject();
            System.out.println("[client] read response " + response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (echoSocket != null) {
                try {
                    echoSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return response;
    }
}
