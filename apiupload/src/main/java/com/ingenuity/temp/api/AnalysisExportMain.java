package com.ingenuity.temp.api;

import com.ingenuity.temp.apiupload.ApiLogin;
import com.ingenuity.temp.apiupload.GenericApi;
import com.ingenuity.temp.apiupload.Pair;
import org.apache.commons.httpclient.HttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 5/6/2014.
 */
public class AnalysisExportMain {

    private static void exportAnalysis(String apiAnalysis) {
        String username = "newauto4@infostretch.com";
        String password = "test1234";
        String server = "https://analysis-stable.ingenuity.com/";
        ApiLogin login = new ApiLogin(username, password, server);
        HttpClient client = login.getClient();

        // https://analysis-stable.ingenuity.com/pa/api/v1/export?aid=30908&art=regulatoreffects
        GenericApi genericApi = new GenericApi(client, server);
        String path = "pa/api/v1/export";
        List<Pair> parameters = new ArrayList<Pair>();
        parameters.add(new Pair("aid", "30908"));
        parameters.add(new Pair("art", "regulatoreffects"));


        genericApi.executePost(path, parameters, apiAnalysis);
    }

    public static void main(String[] args) {
        String apiAnalysis = "apiAnalysis.txt";
        //exportAnalysis(apiAnalysis);

        // compare files
        //FileComparer.findDifferentTokens("uiAnalysis.txt", apiAnalysis);
        FileComparer.compareTables("uiAnalysis.txt", apiAnalysis);
    }
}
