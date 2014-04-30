package com.chronicweirdo.naframa;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by scacoveanu on 4/24/2014.
 */
public class DoImage {

    private static final Logger log = Logger.getLogger(DoImage.class);

    public static void main(String[] args) throws IOException, TranscoderException {

        //String fileName = "%USERPROFILE%\\Dropbox\\mydata\\drawing\\povesti degeaba\\capra.svg";
        String fileName = "lc.svg";

        // create a JPEG transcoder
        JPEGTranscoder t = new JPEGTranscoder();
        // set hints
        t.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));

        String svgURI = new File(fileName).toURL().toString();
        TranscoderInput input = new TranscoderInput(svgURI);

        OutputStream ostream = new FileOutputStream("out.jpg");
        TranscoderOutput output = new TranscoderOutput(ostream);

        t.transcode(input, output);

        ostream.flush();
        ostream.close();
    }
}
