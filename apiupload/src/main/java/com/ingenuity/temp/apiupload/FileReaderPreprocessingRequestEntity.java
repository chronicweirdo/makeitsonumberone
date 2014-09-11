package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;
import sun.management.counter.LongCounter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
    private long logSteps = 100;
    private long logInSteps = 1;

    public FileReaderPreprocessingRequestEntity(List<Pair> parameters, String filePath, List<String> columnMapping) {
        super();
        this.parameters = parameters;
        this.filePath = filePath;
        this.columnMapping = columnMapping;

        computeLength();
    }

    private void computeLength() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        length = 0;

        // calculate encoded parameters size
        String encodedParameters = encodePairs(parameters, true);
        long encodedParametersLength = encodedParameters.length();
        length += encodedParametersLength;
        stopwatch.lap("compute length generic parameters");
        log.info(stopwatch.lastLapString());

        // read file line by line and encode entries
        final AtomicLong step = new AtomicLong(0);
        FileLineProcessor processor = new FileLineProcessor() {
            private boolean firstLine = true;

            @Override
            public void processLine(String line) {
                if (! firstLine) {
                    String encoded = encodeRow(line);
                    length += encoded.length();
                    step.incrementAndGet();
                } else {
                    firstLine = false;
                }
            }
        };
        processor.process(filePath);
        stopwatch.lap("compute length dataset");
        log.info(stopwatch.lastLapString());
        // preparing logging steps
        if (step.get() > logSteps) {
            logInSteps = step.get() / logSteps;
        }
        log.info("logging every " + logInSteps + " steps");
        stopwatch.lap("setting up logging");
        log.info(stopwatch.lastLapString());
        log.info("computed length in " + stopwatch.totalTimeString());
        log.info("computed length (characters): " + length);
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
        final Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        final OutputStreamWriter writer = new OutputStreamWriter(out);

        // write general parameters
        String encodedParameters = encodePairs(parameters, true);
        writer.append(encodedParameters);
        stopwatch.lap("sent generic parameters");
        log.info(stopwatch.lastLapString());

        // read file line by line and write encoded entries
        FileLineProcessor processor = new FileLineProcessor() {
            private boolean firstLine = true;
            private long step = 0;

            @Override
            public void processLine(String line) {
                if (! firstLine) {
                    String encoded = encodeRow(line);
                    try {
                        writer.append(encoded);
                        step++;
                        if (step % logInSteps == 0) {
                            stopwatch.lap("sent " + step + " file lines");
                            log.info(stopwatch.lastLapString() + " > " + stopwatch.totalTimeString());
                        }
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
        stopwatch.lap("finished sending data");
        log.info(stopwatch.lastLapString());
        log.info("sending data took " + stopwatch.totalTimeString());
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
