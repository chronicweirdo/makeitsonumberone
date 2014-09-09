package com.ingenuity.temp.apiupload;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 9/8/2014.
 */
public class DataUtil {

    private static final Logger log = Logger.getLogger(DataUtil.class);

    public static List<Pair> buildPOSTData(String filePath, String projectName, String ipaview,
                                     String datasetName, String analysisName, String geneidtype,
                                     List<String> columnMapping, List<String> fieldTypes) {
        log.info("building POST data");

        // read dataset
        List<List<String>> dataset = DatasetReader.getTable(filePath);

        // set generic parameters
        log.info("setting generic parameters (projectname, ipaview, datasetname, geneidtype)");
        List<Pair> data = new ArrayList<Pair>();
        data.add(new Pair("projectname", projectName));
        data.add(new Pair("ipaview", ipaview));
        data.add(new Pair("datasetname", datasetName));
        if (analysisName != null) {
            data.add(new Pair("analysisname", analysisName));
        }
        data.add(new Pair("geneidtype", geneidtype));

        // set field types
        if (fieldTypes.get(0) != null) data.add(new Pair("expvaltype", fieldTypes.get(0)));
        if (fieldTypes.get(1) != null) data.add(new Pair("expvaltype2", fieldTypes.get(1)));
        if (fieldTypes.get(2) != null) data.add(new Pair("expvaltype3", fieldTypes.get(2)));

        log.info("setting data parameters");
        mapDataset(columnMapping, dataset, data);
        return data;
    }

    public static void mapDataset(List<String> columnMapping, List<List<String>> dataset, List<Pair> data) {
        for (int row = 1; row < dataset.size(); row++) {
            for (int column = 0; column < columnMapping.size(); column++) {
                // check if we have a mapping for this column
                if (columnMapping.get(column) != null && columnMapping.get(column).length() > 0) {
                    String value = "#NUM!"; // assume we have no value
                    if (column < dataset.get(row).size() && dataset.get(row).get(column) != null
                            && dataset.get(row).get(column).length() > 0) {
                        value = dataset.get(row).get(column);
                    }
                    data.add(new Pair(columnMapping.get(column), value));
                }
            }
        }
    }

    public static List<Pair> parseParameters(String parameters) {
        List<Pair> result = new ArrayList<Pair>();
        String pattern = "([^ =&]+)=([^ =&]+)";
        Matcher matcher = Pattern.compile(pattern).matcher(parameters);
        while (matcher.find()) {
            Pair parameter = new Pair(matcher.group(1), matcher.group(2));
            result.add(parameter);
        }
        return result;
    }

}
