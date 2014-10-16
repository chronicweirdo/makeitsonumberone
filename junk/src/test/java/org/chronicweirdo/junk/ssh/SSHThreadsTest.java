package org.chronicweirdo.junk.ssh;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by scacoveanu on 10/16/2014.
 */
public class SSHThreadsTest {

    @Test
    public void testDataLoss() throws Exception {
        // create a ssh session
        String user = "scacoveanu";
        String host = "upadm1";
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(Password.get());
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        ChannelShell channel = (ChannelShell) session.openChannel("shell");
        channel.setPtyType("dumb");
        channel.connect();

        PrintStream input = new PrintStream(channel.getOutputStream());

        // create a thread that will read output and save it in a buffer
        final StringBuffer buffer = new StringBuffer();
        new Thread(new Runnable() {
            InputStream output;
            @Override
            public void run() {
                try {
                    output = channel.getInputStream();
                    while (true) {
                        int c = output.read();
                        //System.out.println((char) c);
                        buffer.append((char) c);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // issue some commands
        System.out.println("issuing commands");
        input.print("cd /tmp/tmpsilviu" + "\n\r"); input.flush();
        input.print("ls" + "\n\r"); input.flush();

        // print buffer to see if we got all the output
        System.out.println(buffer.toString());
    }

    public static void main(String[] args) throws Exception {
        new SSHThreadsTest().testDataLoss();
    }
}
