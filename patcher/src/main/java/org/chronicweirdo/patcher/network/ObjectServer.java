package org.chronicweirdo.patcher.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by scacoveanu on 10/2/2014.
 */
public class ObjectServer implements Runnable {

    public static final int PORT = 13542;

    @Override
    public void run() {
        start();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("[server] creating streams");
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());


                // read message from client
                System.out.println("[server] reading object from client");
                Message message = (Message) in.readObject();
                // handle message
                System.out.println("[server] handle client object");
                Message response = handle(message);
                System.out.println("[server] sending response " + response);
                // send response
                out.writeObject(response);
                out.flush();
                System.out.println("[server] response sent");

                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Message handle(Message message) {
        System.out.println("[server] " + message.toString());
        return new Message(Message.Type.RECEIVED);
    }
}
