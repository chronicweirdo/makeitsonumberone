package org.chronicweirdo.dump.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Silviu on 12/26/2014.
 */
public class StaticHTMLServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getCleanPath());
        resp.setContentType("text/html");
        try {
            writeToResponse("dump/data/maven.html", resp.getWriter());
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public static String getCleanPath() {
        ClassLoader classLoader = StaticHTMLServlet.class.getClassLoader();
        File classpathRoot = new File(classLoader.getResource("").getPath());

        return classpathRoot.getPath();
    }

    private void writeToResponse(String path, PrintWriter responseWriter) throws IOException {
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            responseWriter.println(line);
        }
        br.close();
        fr.close();
    }
}
