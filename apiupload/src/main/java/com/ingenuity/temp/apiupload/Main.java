package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.log4j.Logger;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 4/23/2014.
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static List<Pair> extractFormData(String filePath, String projectName, String datasetName) {
        // read dataset
        List<List<String>> dataset = DatasetReader.getTable(filePath);

        // set generic parameters
        List<Pair> data = new ArrayList<Pair>();
        data.add(new Pair("projectname", projectName));
        data.add(new Pair("ipaview", "projectmanager"));
        data.add(new Pair("datasetname", datasetName));
        data.add(new Pair("geneidtype", "affymetrix"));

        // add dataset
        // first column is geneid, second column is expvalue,, third column is obs2expval, and so on
        String[] colMap = {"geneid", "expvalue", "obs2expval", "obs3expval", "obs4expval", "obs5expval", "obs6expval"};
        for (int i = 1; i < dataset.size(); i++) {
            for (int j = 0; j < colMap.length; j++) {
                String value = "#NUM!"; // assume we have no value
                if (j < dataset.get(i).size() && dataset.get(i).get(j) != null && dataset.get(i).get(j).length() > 0) {
                    value = dataset.get(i).get(j);
                }
                data.add(new Pair(colMap[j], value));
            }
        }
        return data;
    }

    public static void main(String[] args) {
        String server = "https://analysis-stable.ingenuity.com";

        log.info("logging in");
        String username = "scacoveanu@ingenuity.com";
        String password = "test1234";
        ApiLogin login = new ApiLogin(username, password, server);
        HttpClient client = login.getClient();
        log.info("was login executed? " + login.isLoginExecuted());
        log.info("was login successful? " + login.isLoginSuccessful());

        log.info("initializing generic api");
        GenericApi genericApi = new GenericApi(client, server);

        log.info("uploading the dataset");
        String uploadAPIPath = "/pa/api/v1/dataupload";
        String filePath = Main.class.getClassLoader().getResource("LPSHepatotoxicityInRats.txt").getFile();
        //log.info("@@@@@ : " + Main.class.getResource("LPSHepatotoxicityInRats.txt").toString());
        log.info("----- toString: " + Main.class.getClassLoader().getResource("LPSHepatotoxicityInRats.txt").toString());
        try {
            log.info("----- toURI: " + Main.class.getClassLoader().getResource("LPSHepatotoxicityInRats.txt").toURI().toString());
        } catch (URISyntaxException e) {
            log.error(e, e);
        }
        log.info("----- getFile: " + Main.class.getClassLoader().getResource("LPSHepatotoxicityInRats.txt").getFile());
        log.info("----- getPath: " + Main.class.getClassLoader().getResource("LPSHepatotoxicityInRats.txt").getPath());
        log.info("file path: " + filePath);
        String projectName = "Training Project";
        String datasetName = "MyTestDataset" + System.currentTimeMillis();
        log.info("dataset name: " + datasetName);


        /*List<Pair> data = extractFormData(filePath, projectName, datasetName);
        if (data.size() > 4) {
            genericApi.executePost(uploadAPIPath, data, "output.txt");
        }*/
    }
}
