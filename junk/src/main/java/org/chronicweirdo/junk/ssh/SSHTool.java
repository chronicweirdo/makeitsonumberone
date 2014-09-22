package org.chronicweirdo.junk.ssh;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.concurrent.*;

/**
 * Created by scacoveanu on 9/19/2014.
 */
public class SSHTool {

    public static final int PORT = 22;
    private String username;
    private String password;
    private String host;
    private JSch sch;
    //private ChannelExec channel;
    private ChannelShell channel;
    private Session session;
    private PrintStream input;
    private InputStream output;

    public SSHTool(String username, String password, String host) {
        this.username = username;
        this.password = password;
        this.host = host;
    }

    public void connect() throws Exception {
        sch = new JSch();

        session = sch.getSession(username, host, PORT);
        session.setPassword(password);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        //channel = (ChannelExec) session.openChannel("exec");
        channel = (ChannelShell) session.openChannel("shell");
        channel.setPtyType("dumb");
        channel.connect();
        /*PipedInputStream pip = new PipedInputStream(40);
        channel.setInputStream(pip);

        PipedOutputStream pop = new PipedOutputStream(pip);*/
        //input = new PrintStream(pop);
        input = new PrintStream(channel.getOutputStream());
        output = channel.getInputStream();
        System.out.println(output.getClass().getName());

        System.out.println(readOuput());
    }

    public void disconnect() throws Exception {
        input.close();
        output.close();
        channel.disconnect();
        session.disconnect();
    }

    public String run(String command) throws Exception {
        System.out.println("<running " + command + ">");
        input.print(command + "\n");
        input.flush();
        //channel.setCommand(command);
        //channel.run();
        /*PrintStream shell = new PrintStream(channel.getOutputStream());
        shell.println(command);
        shell.flush();*/

        return readOuput();

        /*InputStream outputstream_from_the_channel = channel.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(outputstream_from_the_channel));
        String line;
        while ((line = br.readLine()) != null)
            System.out.print(line+"\n");*/

        //return outputBuffer.toString();

        //return null;
    }

    private String readOuput2() throws Exception {
        StringBuilder buffer = new StringBuilder();
        while (output.available() != 0) {
            buffer.append((char) output.read());
        }
        return buffer.toString();
    }
    private String readOuput() throws Exception {
        Callable<Integer> readTask = new Callable<Integer>() {
            public Integer call() throws Exception {
                return output.read();
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);

        StringBuilder outputBuffer = new StringBuilder();

        int readByte = 0;
        try {
            while (readByte >= 0) {
                Future<Integer> future = executor.submit(readTask);
                readByte = future.get(1000, TimeUnit.MILLISECONDS);
                if (readByte >= 0) {
                    outputBuffer.append((char) readByte);
                }
            }
        } catch (TimeoutException e) {
            System.out.println("<timed out>");
        }
        outputBuffer.append((char) readByte);
        return outputBuffer.toString();
    }
}
