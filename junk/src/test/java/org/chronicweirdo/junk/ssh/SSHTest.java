package org.chronicweirdo.junk.ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/**
 * http://www.jcraft.com/jsch/examples/
 *
 * Created by scacoveanu on 9/18/2014.
 */
public class SSHTest {

    private String password = "";

    /*@BeforeClass
    public void setUpClass() throws Exception {
        password = JOptionPane.showInputDialog("Enter password");
    }*/

    //@Test
    public void loggingIn() throws Exception {
        String user = "scacoveanu";
        String host = "upadm1";

        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);


        session.setPassword(password);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect(30000);

        Channel channel = session.openChannel("shell");
        channel.setInputStream(System.in);
        channel.setOutputStream(System.out);
        channel.connect(3 * 1000);
        channel.disconnect();
        session.disconnect();
    }

    @Test
    public void executing() throws Exception {
        String user = "scacoveanu";
        String host = "upadm1";

        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);

        session.setPassword(password);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect(30000);

        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand("cd /tmp/tmpsilviu");
        channel.connect(3*1000);
        InputStream commandOutput = channel.getInputStream();
        System.out.println(getOutput(commandOutput));
        channel.disconnect();

        channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand("ls");
        channel.connect();
        System.out.println(getOutput(channel.getInputStream()));
        channel.disconnect();

        // not working, try this: http://stackoverflow.com/questions/22254466/how-to-execute-multiple-unix-command-through-jsch-using-same-shell

        channel.disconnect();
        session.disconnect();
    }

    private String getOutput(InputStream commandOutput) throws Exception {
        StringBuilder outputBuffer = new StringBuilder();
        int readByte = commandOutput.read();

        while (readByte != 0xffffffff) {
            outputBuffer.append((char) readByte);
            readByte = commandOutput.read();
        }
        return outputBuffer.toString();
    }
}
