package org.chronicweirdo.junk.ssh;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by scacoveanu on 9/22/2014.
 */
public class SSHJTest {

    @Test
    public void test1() throws Exception {
        String userName="scacoveanu";
        String password=Password.get();
        String host="upadm1";

        final SSHClient ssh = new SSHClient();
        ssh.loadKnownHosts();

        ssh.connect(host);
        ssh.authPassword(userName, password);
        Session session = ssh.startSession();

        Session.Command command = session.exec("pwd");
        System.out.println(IOUtils.readFully(command.getInputStream()).toString());
        command.join(5, TimeUnit.SECONDS);
        System.out.println(command.getExitStatus());

        session.close();
        ssh.disconnect();
    }

    //@Test - not working
    public void test2() throws Exception {
        String userName="scacoveanu";
        String password=Password.get();
        String host="upadm1";

        final SSHClient ssh = new SSHClient();
        ssh.loadKnownHosts();

        ssh.connect(host);
        ssh.authPassword(userName, password);
        Session session = ssh.startSession();
        Session.Shell shell = session.startShell();

        Session.Command command = session.exec("cd /tmp/tmpsilviu");
        System.out.println(IOUtils.readFully(command.getInputStream()).toString());
        command.join(5, TimeUnit.SECONDS);
        System.out.println(command.getExitStatus());

        command = session.exec("ls");
        System.out.println(IOUtils.readFully(command.getInputStream()).toString());
        command.join(5, TimeUnit.SECONDS);
        System.out.println(command.getExitStatus());

        session.close();
        ssh.disconnect();
    }
}
