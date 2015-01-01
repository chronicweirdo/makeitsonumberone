package org.chronicweirdo.dump;

import org.chronicweirdo.dump.server.TheServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("dump/src/main/resources/context.xml");

        TheServer server = context.getBean(TheServer.class);
        server.start();
        //((ConfigurableApplicationContext) context).refresh();
    }
}
