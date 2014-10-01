package org.chronicweirdo.junk.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by scacoveanu on 10/1/2014.
 */
public class GanymedTest {

    private String host = "upadm1";
    private String user = "scacoveanu";
    private String password = Password.get();

    @Test
    public void basic() throws Exception {

        Connection connection = new Connection(host);
        connection.connect();

        // authenticate
        //boolean isAuthenticated = connection.authenticateWithPassword(user, password);
        File keyfile = new File(System.getProperty("user.home") + "\\.ssh\\id_rsa");
        char[] privateKey;
        boolean isAuthenticated = connection.authenticateWithPublicKey(user, keyfile, password);
        if (! isAuthenticated) throw new Exception("Authentication failed!");

        // create session
        Session session = connection.openSession();

        // execute some command
        session.execCommand("uname -a && date && uptime && who");

        // read command output
        InputStream stdout = new StreamGobbler(session.getStdout());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }

        // close
        System.out.println("Exit code: " + session.getExitStatus());
        session.close();
        connection.close();
    }
}
