package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
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
    private static final String DEFAULT_GENE_ID_TYPE = "affymetrix";

    private static final ComboOption[] COLUMN_MAPPING_OPTIONS = {
            new ComboOption("geneid", "the gene or protein IDs to be uploaded to IPA"),
            new ComboOption("expvalue", "the first set of expression values"),
            new ComboOption("obs2expval", "the first set of expression values for the second observation"),
            new ComboOption("obs3expval", "the first set of expression values for the third observation"),
            new ComboOption("obs4expval", "the first set of expression values for the fourth observation"),
            new ComboOption("obs5expval", "the first set of expression values for the fifth observation"),
            new ComboOption("obs6expval", "the first set of expression values for the sixth observation"),
            new ComboOption("expval2", "the second set of expression values for the uploaded genes"),
            new ComboOption("expval3", "the thirs set of expression values for the uploaded genes")
    };

    private JTextField filePath;
    private JButton selectFile;
    private JTextField serverPath;
    private JTextField apiPath;
    private JTextField userName;
    private JTextField projectName;
    private JTextField datasetName;
    private JTextField geneIDType;
    private JPasswordField password;
    private JButton submit;

    private JSplitPane panel;
    private JPanel mappingPanel;

    private List<String> columns;
    private List<JComboBox<ComboOption>> fields;
    private JScrollPane scrollLogArea;

    public MainUI() {
        init();
    }

    public JComponent getPanel() {
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
        panel = new JSplitPane();

        createEditComponents();

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
                SwingWorker worker = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        executeUpload();
                        return null;
                    }

                    @Override
                    protected void done() {
                        super.done();
                        submit.setEnabled(true);
                    }
                };
                submit.setEnabled(false);
                worker.execute();
            }
        });

        // build UI
        JPanel editPanel = buildEditPanel();

        panel.setLeftComponent(editPanel);

        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setAutoscrolls(true);
        new TextAreaAppender(logArea);
        scrollLogArea = new JScrollPane(logArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.setRightComponent(scrollLogArea);


        log.info("UI init done");
        log.info("Now you can play");
    }

    private JPanel buildEditPanel() {
        int row = 0;
        JPanel editPanel = new JPanel(new GridBagLayout());
        editPanel.add(new JLabel("File to upload:"), UIUtil.constraints(0, row));
        editPanel.add(filePath, UIUtil.constraints(1, row, 2, 1));
        editPanel.add(selectFile, UIUtil.constraints(3, row));

        editPanel.add(new JLabel("Server URL:"), UIUtil.constraints(0, ++row));
        editPanel.add(serverPath, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(new JLabel("API path:"), UIUtil.constraints(0, ++row));
        editPanel.add(apiPath, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(new JLabel("User name:"), UIUtil.constraints(0, ++row));
        editPanel.add(userName, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(new JLabel("Password:"), UIUtil.constraints(0, ++row));
        editPanel.add(password, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(new JLabel("Project name:"), UIUtil.constraints(0, ++row));
        editPanel.add(projectName, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(new JLabel("Dataset name:"), UIUtil.constraints(0, ++row));
        editPanel.add(datasetName, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(new JLabel("Gene ID type:"), UIUtil.constraints(0, ++row));
        editPanel.add(geneIDType, UIUtil.constraints(1, row, 3, 1));

        editPanel.add(mappingPanel, UIUtil.constraints(0, ++row, 4, 1));

        editPanel.add(submit, UIUtil.constraints(3, ++row));
        return editPanel;
    }

    private void createEditComponents() {
        filePath = new JTextField("<select file>");
        filePath.setEditable(false);
        selectFile = new JButton("...");
        serverPath = new JTextField(DEFAULT_SERVER_URL);
        apiPath = new JTextField(DEFAULT_API_PATH);
        userName = new JTextField(DEFAULT_USERNAME);
        password = new JPasswordField(DEFAULT_PASSWORD);
        projectName = new JTextField(DEFAULT_PROJECT_NAME);
        datasetName = new JTextField(DEFAULT_DATASET_NAME);
        geneIDType = new JTextField(DEFAULT_GENE_ID_TYPE);
        mappingPanel = new JPanel(new GridBagLayout());
        mappingPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("File column mapping"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        submit = new JButton("Submit");
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
        fields = new ArrayList<JComboBox<ComboOption>>(columns.size());
        for (int row = 0; row < columns.size(); row++) {
            mappingPanel.add(new JLabel(columns.get(row) + ":"), UIUtil.constraints(0, row));
            JComboBox field = new JComboBox(COLUMN_MAPPING_OPTIONS);
            field.setEditable(true);
            field.setSelectedIndex(row);
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
        String geneIDType = this.geneIDType.getText();
        log.info("dataset name: " + datasetName);

        // build the column mapping
        List<String> columnMapping = new ArrayList<String>(fields.size());
        for (JComboBox field: fields) {
            Object selected = field.getSelectedItem();
            if (selected instanceof ComboOption) {
                ComboOption comboOption = (ComboOption) selected;
                log.info("columnMapping combo option " + comboOption.getValue() + " added");
                columnMapping.add(comboOption.getValue());
            } else {
                log.info("columnMapping string " + selected.toString() + " added");
                columnMapping.add(selected.toString());
            }
        }

        List<Pair> data = extractFormData(filePath, projectName, datasetName, geneIDType, columnMapping);
        if (data.size() > 4) {
            genericApi.executePost(uploadAPIPath, data, "output.txt");
        }
    }

    private List<Pair> extractFormData(String filePath, String projectName, String datasetName,
                                       String geneidtype, List<String> columnMapping) {
        // read dataset
        List<List<String>> dataset = DatasetReader.getTable(filePath);

        // set generic parameters
        List<Pair> data = new ArrayList<Pair>();
        data.add(new Pair("projectname", projectName));
        data.add(new Pair("ipaview", "projectmanager"));
        data.add(new Pair("datasetname", datasetName));
        data.add(new Pair("geneidtype", geneidtype));

        // add dataset
        // first column is geneid, second column is expvalue,, third column is obs2expval, and so on
        //String[] colMap = {"geneid", "expvalue", "obs2expval", "obs3expval", "obs4expval", "obs5expval", "obs6expval"};
        for (int row = 1; row < dataset.size(); row++) {
            for (int column = 0; column < columnMapping.size(); column++) {
                // check if we have a mapping for this column
                if (columnMapping.get(column) != null && columnMapping.get(column).length() > 0) {
                    String value = "#NUM!"; // assume we have no value
                    if (column < dataset.get(row).size() && dataset.get(row).get(column) != null && dataset.get(row).get(column).length() > 0) {
                        value = dataset.get(row).get(column);
                    }
                    data.add(new Pair(columnMapping.get(column), value));
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        MainUI main = new MainUI();
        UIUtil.createAndShowGUI("IPA API Upload", null, main.getPanel());
    }
}
