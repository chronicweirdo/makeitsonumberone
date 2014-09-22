package org.chronicweirdo.junk.ssh;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by scacoveanu on 9/19/2014.
 */
public class SSHToolTest {

    @Test
    public void ls() throws Exception {
        String userName="scacoveanu";
        String password=Password.get();
        String connectionIP="upadm1";

        SSHTool ssh = new SSHTool(userName, password, connectionIP);
        ssh.connect();

        System.out.println(ssh.run("cd /tmp/tmpsilviu"));
        System.out.println(ssh.run("ls"));
        System.out.println(ssh.run("pwd"));

        ssh.disconnect();
    }
}
