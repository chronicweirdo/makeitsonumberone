package org.chronicweirdo.junk.ssh;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 9/19/2014.
 */
public class SSHManagerTest {

    @Test
    public void ls() throws Exception {
        String userName="scacoveanu";
        String password="";
        String connectionIP="upadm1";
        SSHManager instance = new SSHManager(userName, password, connectionIP, "C:\\Users\\scacoveanu\\.ssh\\known_hosts");
        String errorMessage=instance.connect();

        if(errorMessage!=null)
        {
            System.out.println(errorMessage);
            fail();
        }

        String expResult="FILE_NAME\n";
        // call sendCommand for each command and the output
        //(without prompts) is returned
        String result = instance.sendCommand("cd /tmp/tmpsilviu");
        System.out.println(result);
        result = instance.sendCommand("ls");
        System.out.println(result);
        // close only after all commands are sent
        instance.close();
        //assertEquals(expResult,result);
    }
}
