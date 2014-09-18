package org.chronicweirdo.junk.ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

/**
 * http://www.jcraft.com/jsch/examples/
 *
 * Created by scacoveanu on 9/18/2014.
 */
public class SSHTest {

    private String password;

    @BeforeClass
    public void setUpClass() throws Exception {
        password = JOptionPane.showInputDialog("Enter password");
    }

    @Test
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
        channel.connect(3*1000);
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

        Channel channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand("pwd");
        channel.setInputStream(System.in);
        channel.setOutputStream(System.out);
        ((ChannelExec)channel).setErrStream(System.err);
        channel.connect(3*1000);

        channel.disconnect();
        session.disconnect();
    }
}
