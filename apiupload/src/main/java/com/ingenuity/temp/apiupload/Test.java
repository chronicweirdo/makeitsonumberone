package com.ingenuity.temp.apiupload;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by scacoveanu on 5/19/2014.
 */
public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException {
        if(Desktop.isDesktopSupported())
        {
            Desktop.getDesktop().browse(new URI("http://www.example.com"));
        }
    }
}
