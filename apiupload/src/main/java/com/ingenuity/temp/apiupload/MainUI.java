package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 4/29/2014.
 */
public class MainUI {

    private static final Logger log = Logger.getLogger(MainUI.class);

    private static final String DEFAULT_SERVER_URL = "https://analysis-stable.ingenuity.com";
    private static final String DEFAULT_API_PATH = "/pa/api/v1/dataupload";
    private static final String DEFAULT_USERNAME = "scacoveanu@ingenuity.com";
    private static final String DEFAULT_PASSWORD = "test1234";
    private static final String DEFAULT_PROJECT_NAME = "Training Project";
    private static final String DEFAULT_DATASET_NAME = "MyTestDataset";

    private JTextField filePath;
    private JButton selectFile;
    private JTextField serverPath;
    private JTextField apiPath;
    private JTextField userName;
    private JTextField projectName;
    private JTextField datasetName;
    private JPasswordField password;
    private JButton submit;

    private JPanel panel;
    private JPanel mappingPanel;

    private List<String> columns;
    private List<JTextField> fields;

    public MainUI() {
        init();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void pickFile() {
        // show file chooser
        JFileChooser datasetChooser = new JFileChooser();
        int returnVal = datasetChooser.showDialog(selectFile, "Load");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = datasetChooser.getSelectedFile();
            log.info("selected file: " + file.getAbsolutePath());
            // set filePath
            filePath.setText(file.getAbsolutePath());
            loadHeader();
            buildColumnMappingPanel();
        } else {
            // nothing
        }
    }

    private void init() {
        // create components
        panel = new JPanel(new GridBagLayout());
        //panel.setPreferredSize(new Dimension(500, 500));
        filePath = new JTextField("<select file>");
        filePath.setEditable(false);
        selectFile = new JButton("...");
        serverPath = new JTextField(DEFAULT_SERVER_URL);
        apiPath = new JTextField(DEFAULT_API_PATH);
        userName = new JTextField(DEFAULT_USERNAME);
        password = new JPasswordField(DEFAULT_PASSWORD);
        projectName = new JTextField(DEFAULT_PROJECT_NAME);
        datasetName = new JTextField(DEFAULT_DATASET_NAME);
        mappingPanel = new JPanel(new GridBagLayout());
        mappingPanel.setBackground(Color.lightGray);
        submit = new JButton("Submit");
        JTextArea logArea = new JTextArea();
        //logArea.setPreferredSize(new Dimension(500, 200));
        logArea.setEditable(false);
        logArea.setAutoscrolls(true);
        new TextAreaAppender(logArea);
        JScrollPane scrollLogArea = new JScrollPane(logArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollLogArea.setPreferredSize(new Dimension(500, 200));


        // add listeners
        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickFile();
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeUpload();
            }
        });

        // build UI - row 1
        panel.add(new JLabel("File to upload:"), UIUtil.constraints(0, 0));
        panel.add(filePath, UIUtil.constraints(1, 0, 2, 1));
        panel.add(selectFile, UIUtil.constraints(3, 0));

        // build UI - row 2
        panel.add(new JLabel("Server URL:"), UIUtil.constraints(0, 1));
        panel.add(serverPath, UIUtil.constraints(1, 1, 3, 1));

        // build UI - row 3
        panel.add(new JLabel("API path:"), UIUtil.constraints(0, 2));
        panel.add(apiPath, UIUtil.constraints(1, 2, 3, 1));

        // build UI - row 4
        panel.add(new JLabel("User name:"), UIUtil.constraints(0, 3));
        panel.add(userName, UIUtil.constraints(1, 3, 3, 1));

        // build UI - row 5
        panel.add(new JLabel("Password:"), UIUtil.constraints(0, 4));
        panel.add(password, UIUtil.constraints(1, 4, 3, 1));

        // build UI - row 6
        panel.add(new JLabel("Project name:"), UIUtil.constraints(0, 5));
        panel.add(projectName, UIUtil.constraints(1, 5, 3, 1));

        // build UI - row 7
        panel.add(new JLabel("Dataset name:"), UIUtil.constraints(0, 6));
        panel.add(datasetName, UIUtil.constraints(1, 6, 3, 1));

        // build UI - row 8
        panel.add(mappingPanel, UIUtil.constraints(0, 7, 4, 1));

        // build UI - row 9
        panel.add(submit, UIUtil.constraints(3, 8));

        // build UI - row 10 and beyond
        panel.add(scrollLogArea,
                UIUtil.constraints(0, 9, 4, 4));


        log.info("UI init done");
        log.info("Now you can play");
    }

    private void loadHeader() {
        String path = filePath.getText();
        if (path != null && path.length() > 0) {
            columns = new ArrayList<String>();
            try {
                BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
                String line = r.readLine();
                if (line != null) {
                    String[] tokens = line.split("\t");
                    for (String token: tokens) {
                        columns.add(token);
                    }
                }
                r.close();

                log.info("loaded columns: " + columns.toString());
            } catch (IOException e) {
                log.error(e, e);
            }
        }
    }

    private void buildColumnMappingPanel() {
        mappingPanel.removeAll();
        fields = new ArrayList<JTextField>(columns.size());
        for (int row = 0; row < columns.size(); row++) {
            mappingPanel.add(new JLabel(columns.get(row) + ":"), UIUtil.constraints(0, row));
            JTextField field = new JTextField(columns.get(row));
            fields.add(field);
            mappingPanel.add(field, UIUtil.constraints(1, row));
        }
        mappingPanel.updateUI();
    }

    private void executeUpload() {
        String server = serverPath.getText();

        log.info("logging in");
        String username = this.userName.getText();
        String password = new String(this.password.getPassword());
        ApiLogin login = new ApiLogin(username, password, server);
        HttpClient client = login.getClient();
        log.info("was login executed? " + login.isLoginExecuted());
        log.info("was login successful? " + login.isLoginSuccessful());

        log.info("initializing generic api");
        GenericApi genericApi = new GenericApi(client, server);

        log.info("uploading the dataset");
        String uploadAPIPath = this.apiPath.getText();
        String filePath = this.filePath.getText();

        String projectName = this.projectName.getText();
        String datasetName = this.datasetName.getText();
        log.info("dataset name: " + datasetName);

        List<Pair> data = Main.extractFormData(filePath, projectName, datasetName);
        if (data.size() > 4) {
            genericApi.executePost(uploadAPIPath, data, "output.txt");
        }
    }

    public static void main(String[] args) {
        MainUI main = new MainUI();
        UIUtil.createAndShowGUI("IPA API Upload", null, main.getPanel());
    }
}
