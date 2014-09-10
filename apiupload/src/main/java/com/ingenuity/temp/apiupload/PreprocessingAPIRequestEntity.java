package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by scacoveanu on 9/9/2014.
 */
public class PreprocessingAPIRequestEntity implements RequestEntity {

    private static final Logger log = Logger.getLogger(PreprocessingAPIRequestEntity.class);

    private List<Pair> parameters;
    private int page;
    private long size;
    private long sent;

    public PreprocessingAPIRequestEntity(List<Pair> parameters) {
        super();
        this.parameters = parameters;
        this.page = parameters.size() / 100;
        prepare();
    }

    private void prepare() {
        size = 0;
        for (Pair pair: parameters) {
            String encodedValue = null;
            try {
                encodedValue = URLEncoder.encode(pair.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (encodedValue != null) {
                pair.setValue(encodedValue);
            }
            size += pair.getKey().length() + pair.getValue().length() + 2; // = and & symbols
        }
        size -= 1; // subtract one & symbol
    }


    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public void writeRequest(OutputStream out) throws IOException {
        sent = 0;
        OutputStreamWriter writer = new OutputStreamWriter(out);

        long count = 0;
        boolean first = true;
        for (Pair parameter: parameters) {
            if (!first) {
                writer.append("&");
                //out.write("&".getBytes());
            }
            String text = parameter.getKey() + "=" + parameter.getValue();
            sent += text.length();
            //out.write(text.getBytes());
            writer.append(text);
            count++;
            if (page > 0) {
                if (count % page == 0) {
                    log.info("just sent " + text + " (" + ((double)sent / size) + "%)");
                    log.info("sent " + count + " parameters");
                }
            }
            first = false;
        }
        writer.flush();
        //out.flush();
    }

    @Override
    public long getContentLength() {
        //return -1; // todo: compute parameters length
        return size;
    }

    @Override
    public String getContentType() {
        //return "text/plain; charset=UTF-8";
        //return "multipart/form-data";
        return "application/x-www-form-urlencoded";
        //      application/x-www-form-urlencoded
    }
}
