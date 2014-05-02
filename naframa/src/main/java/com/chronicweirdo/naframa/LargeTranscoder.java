package com.chronicweirdo.naframa;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;

/**
 * Created by scacoveanu on 4/24/2014.
 */
public class LargeTranscoder {

    private static final Logger log = Logger.getLogger(LargeTranscoder.class);

    public static void main(String[] args) throws IOException, TranscoderException, ParserConfigurationException, SAXException {

        //String fileName = "%USERPROFILE%\\Dropbox\\mydata\\drawing\\povesti degeaba\\capra.svg";
        String fileName = "lc.svg";

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(new File(fileName));

        //SVGGraphics2D graphics = new SVGGraphics2D(document);



        // create a JPEG transcoder
        JPEGTranscoder transcoder = new JPEGTranscoder();

        // set hints
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));

        String svgURI = new File(fileName).toURL().toString();
        TranscoderInput input = new TranscoderInput(svgURI);

        OutputStream ostream = new FileOutputStream("out2.jpg");
        TranscoderOutput output = new TranscoderOutput(ostream);

        //Rectangle aoi = new Rectangle(0, 0, 100, 100);
        /*transcoder.addTranscodingHint(JPEGTranscoder.KEY_WIDTH,
                new Float(aoi.width));
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_HEIGHT,
                new Float(aoi.height));*/
        //transcoder.addTranscodingHint(JPEGTranscoder.KEY_AOI, aoi);

        int originalWidth = 10244;
        int originalHeight = 437;
        float ratio = 2;
        float pixels = originalHeight * originalWidth * ratio * ratio;
        System.out.println("writing " + NumberFormat.getInstance().format(pixels) + " pixels");
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_WIDTH, new Float(originalWidth*ratio));
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_HEIGHT, new Float(originalHeight*ratio));
        transcoder.transcode(input, output);

        ostream.flush();
        ostream.close();
    }
}
