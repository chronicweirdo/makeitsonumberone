package org.chronicweirdo.patcher.network;

import org.junit.Test;

/**
 * Created by scacoveanu on 10/2/2014.
 */
public class ObjectClientTest {

    @Test
    public void sendObjects() throws Exception {
        ObjectClient client = new ObjectClient("10.32.50.11");

        System.out.println("sending first message");
        Message message1 = new Message(Message.Type.TEXT);
        message1.setText("this text is for test");
        Message response1 = client.send(message1);
        System.out.println("[test] " + response1);

        System.out.println("sending second message");
        Message message2 = new Message(Message.Type.COMMAND);
        message2.setText("ls");
        Message response2 = client.send(message2);
        System.out.println("[test] " + response2);

        System.out.println("[test]" + client.send(new Message(Message.Type.OBJECT)));
    }
}
