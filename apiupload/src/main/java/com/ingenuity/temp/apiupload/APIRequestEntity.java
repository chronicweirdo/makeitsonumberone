package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by scacoveanu on 9/9/2014.
 */
public class APIRequestEntity implements RequestEntity {

    private static final Logger log = Logger.getLogger(APIRequestEntity.class);

    private List<Pair> parameters;
    private int page;

    public APIRequestEntity(List<Pair> parameters) {
        super();
        this.parameters = parameters;
        this.page = parameters.size() / 100;
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public void writeRequest(OutputStream out) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out);

        int count = 0;
        boolean first = true;
        for (Pair parameter: parameters) {
            if (!first) {
                writer.append("&");
                //out.write("&".getBytes());
            }
            String text = parameter.getKey() + "=" + URLEncoder.encode(parameter.getValue(), "UTF-8");
            //out.write(text.getBytes());
            writer.append(text);
            count++;
            if (page > 0) {
                if (count % page == 0) {
                    log.info("just sent " + text);
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
        return -1; // todo: compute parameters length
    }

    @Override
    public String getContentType() {
        //return "text/plain; charset=UTF-8";
        //return "multipart/form-data";
        return "application/x-www-form-urlencoded";
        //      application/x-www-form-urlencoded
    }
}
