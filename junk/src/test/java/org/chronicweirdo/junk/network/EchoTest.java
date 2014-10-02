package org.chronicweirdo.junk.network;

import org.junit.Test;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by scacoveanu on 10/2/2014.
 */
public class EchoTest {


    @Test
    public void getNetworkInformation() throws Exception {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface net: Collections.list(nets)) {
            System.out.println(net.getDisplayName());
            System.out.println(net.getName());
            System.out.println(Collections.list(net.getInetAddresses()));
            System.out.println(net.isUp());
            System.out.println(net.isLoopback());
            // [...]
            System.out.println();
        }
    }

    @Test
    public void sendEcho() throws Exception {
        EchoServer server = new EchoServer();
        EchoClient client = new EchoClient();

        System.out.println("starting server");
        new Thread(server).start();

        System.out.println("running client");
        client.start();
    }
}
