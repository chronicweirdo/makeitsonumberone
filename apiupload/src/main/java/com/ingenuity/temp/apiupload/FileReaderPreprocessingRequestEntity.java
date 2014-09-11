package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * This request entity receives some basic parameters along with the column mapping and the file path.
 * When sending data to the server it will read each line in the file in a buffer, map the line to parameters
 * and send them to the server. This approach is taken in order to minimize the memory required to run the application.
 *
 * The problem with this class is we have to "preprocess" the file and compute the final size of the request before we
 * start sending the request. This means we are going through the file twice, once during preprocess and another time
 * during sending data.
 * Created by scacoveanu on 9/9/2014.
 */
public class FileReaderPreprocessingRequestEntity implements RequestEntity {

    private static final Logger log = Logger.getLogger(FileReaderPreprocessingRequestEntity.class);

    private List<Pair> parameters;
    private String filePath;
    private List<String> columnMapping;
    private long length;

    public FileReaderPreprocessingRequestEntity(List<Pair> parameters, String filePath, List<String> columnMapping) {
        super();
        this.parameters = parameters;
        this.filePath = filePath;
        this.columnMapping = columnMapping;

        prepare();
    }

    private void prepare() {
        length = 0;

        // calculate encoded parameters size
        String encodedParameters = encodePairs(parameters, true);
        length += encodedParameters.length();

        // read file line by line and encode entries
        FileLineProcessor processor = new FileLineProcessor() {
            private boolean firstLine = true;

            @Override
            public void processLine(String line) {
                if (! firstLine) {
                    String encoded = encodeRow(line);
                    length += encoded.length();
                } else {
                    firstLine = false;
                }
            }
        };
        processor.process(filePath);

    }

    public String encodeRow(String line) {
        List<String> tokens = DatasetReader.tokenizeLine(line);
        List<Pair> mapped = mapRow(columnMapping, tokens);
        return encodePairs(mapped, false);
    }

    private List<Pair> mapRow(List<String> columnMapping, List<String> row) {
        return DataUtil.mapRow(columnMapping, row);
    }

    private String encodePairs(List<Pair> pairs, boolean first) {
        StringBuilder builder = new StringBuilder();
        for (Pair pair: pairs) {
            if (!first) {
                builder.append('&');
            } else {
                first = false;
            }
            builder.append(pair.getKey());
            builder.append('=');
            String value = null;
            try {
                value = URLEncoder.encode(pair.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.error(e, e);
                value = pair.getValue();
            }
            builder.append(value);
        }
        return builder.toString();
    }


    @Override
    public boolean isRepeatable() {
        return true;
    }

    @Override
    public void writeRequest(OutputStream out) throws IOException {
        final OutputStreamWriter writer = new OutputStreamWriter(out);

        // write general parameters
        String encodedParameters = encodePairs(parameters, true);
        writer.append(encodedParameters);

        // read file line by line and write encoded entries
        FileLineProcessor processor = new FileLineProcessor() {
            private boolean firstLine = true;

            @Override
            public void processLine(String line) {
                if (! firstLine) {
                    String encoded = encodeRow(line);
                    try {
                        writer.append(encoded);
                    } catch (IOException e) {
                        log.error(e, e);
                    }
                } else {
                    firstLine = false;
                }
            }
        };
        processor.process(filePath);

        writer.flush();
    }

    @Override
    public long getContentLength() {
        return length;
    }

    @Override
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }
}
