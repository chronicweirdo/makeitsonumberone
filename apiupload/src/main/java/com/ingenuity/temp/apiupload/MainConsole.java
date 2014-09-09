package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 9/8/2014.
 */
public class MainConsole {

    /**
     * Special parameters, that require more handling by the tool:
     *      filename
     *      apipath
     *      serverpath
     *      username
     *      password
     *      column1...
     *
     * IPA API parameters taken as they are (the rest):
     *      projectname
     *      datasetname
     *      ipaview
     *      analysisname
     *      geneidtype
     *      expvaltype
     *      expvaltype2
     *      expvaltype3
     *
     * @param args
     */
    public static void main(String[] args) {
        // get the arguments
        List<Pair> programArguments = parseArgs(args);
        for (Pair argument: programArguments) {
            System.out.println(argument.getKey() + " === " + argument.getValue());
        }

        // handle special arguments
        List<List<String>> dataset = null;
        String username = null;
        String password = null;
        String serverpath = null;
        String apipath = null;
        List<String> columnMapping = new ArrayList<String>();
        List<Pair> apiArguments = new ArrayList<Pair>();
        for (Pair argument: programArguments) {
            if ("filename".equals(argument.getKey())) {
                dataset = DatasetReader.getTable(argument.getValue());
            } else if ("username".equals(argument.getKey())) {
                username = argument.getValue();
            } else if ("password".equals(argument.getKey())) {
                password = argument.getValue();
            } else if ("serverpath".equals(argument.getKey())) {
                serverpath = argument.getValue();
            } else if ("apipath".equals(argument.getKey())) {
                apipath = argument.getValue();
            } else if (argument.getKey().startsWith("column")) {
                Integer index = Integer.parseInt(argument.getKey().substring("column".length()));
                setColumnMapping(columnMapping, index, argument.getValue());
            } else {
                apiArguments.add(argument);
            }
        }
        if (dataset == null) {
            System.out.println("filename is null");
            return;
        }
        if (username == null) {
            System.out.println("username is null");
            return;
        }
        if (password == null) {
            System.out.println("password is null");
            return;
        }
        if (serverpath == null) {
            System.out.println("serverpath is null");
            return;
        }
        if (apipath == null) {
            System.out.println("apipath is null");
            return;
        }
        // hadle dataset
        DataUtil.mapDataset(columnMapping, dataset, apiArguments);
        // login
        ApiLogin login = new ApiLogin(username, password, serverpath);
        HttpClient client = login.getClient();
        // send post
        GenericApi genericApi = new GenericApi(client, serverpath);
        genericApi.executePost(apipath, apiArguments, "output.txt", false);
    }

    protected static void setColumnMapping(List<String> columnMapping, Integer index, String value) {
        for (int i = columnMapping.size(); i < index; i++) {
            columnMapping.add("");
        }
        columnMapping.set(index-1, value);
    }

    private static List<Pair> parseArgs(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]).append(" ");
        }
        return DataUtil.parseParameters(builder.toString());
    }

}
