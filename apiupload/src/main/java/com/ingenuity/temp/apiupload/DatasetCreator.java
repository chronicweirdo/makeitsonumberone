package com.ingenuity.temp.apiupload;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by scacoveanu on 6/20/2014.
 */
public class DatasetCreator {

    private static final Logger log = Logger.getLogger(DatasetCreator.class);

    private static final String ID_PREFIX = "id";
    private static final double RATIO_MULTIPLIER = new Double(1000);
    private static final Character TAB = '\t';
    private static final Character NEW_LINE = '\n';

    private static final String ID_COLUMN_HEADER = "Gene ID";
    private static final String RATIO_COLUMN_HEADER_PREFIX = "O";
    private static final String RATIO_COLUMN_HEADER_SUFFIX = " Ratio";

    private static final long BULK_SIZE = 1000;

    private Random random;

    public void createDataset(String path, long entries, int observations) {
        log.info("initializing random generator");
        random = new Random(System.currentTimeMillis());
        String header = createHeader(observations);
        log.info("creating file and adding header: " + header);
        Util.writeToFile(header, path);
        long numberOfBulks = entries / BULK_SIZE;
        log.info("writing dataset file in " + numberOfBulks + " bulks");
        long index = 0;
        while (index < entries) {
            StringBuilder bulk = new StringBuilder();
            long bulkIndex = 0;
            while (bulkIndex < BULK_SIZE && index < entries) {
                bulk.append(NEW_LINE).append(createRow(index, observations));
                index++;
                bulkIndex++;
            }
            Util.appendToFile(bulk.toString(), path);
        }
    }

    private String createHeader(int observations) {
        StringBuilder builder = new StringBuilder();
        log.info("creating the id column header");
        builder.append(ID_COLUMN_HEADER);
        log.info("creating observation ratios headers");
        for (int i = 1; i <= observations; i++) {
            builder.append(TAB).append(RATIO_COLUMN_HEADER_PREFIX).append(i).append(RATIO_COLUMN_HEADER_SUFFIX);
        }
        return builder.toString();
    }

    private String createRow(long id, int observations) {
        log.info("creating row for id: " + id);
        StringBuilder builder = new StringBuilder();
        builder.append(createID(id));
        for (int i = 0; i < observations; i++) {
            builder.append(TAB).append(createRatio());
        }
        return builder.toString();
    }

    private String createID(long id) {
        return ID_PREFIX + id;
    }

    private double createRatio() {
        return random.nextDouble() * RATIO_MULTIPLIER;
    }

    public static void main(String[] args) {
        DatasetCreator creator = new DatasetCreator();
        creator.createDataset("dataset.txt", 100000, 1);
    }
}
