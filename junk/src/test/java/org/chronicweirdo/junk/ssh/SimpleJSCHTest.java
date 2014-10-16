package org.chronicweirdo.junk.ssh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.junit.Test;

/**
 * Created by scacoveanu on 10/16/2014.
 */
public class SimpleJSCHTest {

    @Test
    public void connect() throws Exception {
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
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand("cd /tmp/tmpsilviu;ls");
        channel.connect();
    }
}
