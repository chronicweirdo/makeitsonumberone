package org.chronicweirdo.dump.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Silviu on 12/26/2014.
 */
public class ImageServlet extends HttpServlet {

    private static final int BUFFER_SIZE = 1024;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        try {
            writeToResponse("dump/data/comic.png", resp.getOutputStream());
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private void writeToResponse(String path, OutputStream outputStream) throws IOException {
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        FileInputStream inputStream = new FileInputStream(file);

        byte[] buffer = new byte[BUFFER_SIZE];
        while((inputStream.read(buffer)) != -1){
            outputStream.write(buffer);
        }
        inputStream.close();
    }
}
