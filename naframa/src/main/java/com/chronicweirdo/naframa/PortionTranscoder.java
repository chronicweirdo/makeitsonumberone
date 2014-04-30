package com.chronicweirdo.naframa;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by scacoveanu on 4/24/2014.
 */
public class PortionTranscoder {

    private static final Logger log = Logger.getLogger(PortionTranscoder.class);

    public static void main(String[] args) throws IOException, TranscoderException {

        //String fileName = "%USERPROFILE%\\Dropbox\\mydata\\drawing\\povesti degeaba\\capra.svg";
        String fileName = "lc.svg";

        // create a JPEG transcoder
        JPEGTranscoder transcoder = new JPEGTranscoder();
        // set hints
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));

        String svgURI = new File(fileName).toURL().toString();
        TranscoderInput input = new TranscoderInput(svgURI);

        OutputStream ostream = new FileOutputStream("out.jpg");
        TranscoderOutput output = new TranscoderOutput(ostream);

        Rectangle aoi = new Rectangle(0, 0, 100, 100);
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_WIDTH,
                new Float(aoi.width));
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_HEIGHT,
                new Float(aoi.height));
        transcoder.addTranscodingHint(JPEGTranscoder.KEY_AOI, aoi);
        transcoder.transcode(input, output);

        ostream.flush();
        ostream.close();
    }
}
