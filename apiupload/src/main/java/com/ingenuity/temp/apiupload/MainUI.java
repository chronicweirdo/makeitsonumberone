package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 4/29/2014.
 */
public class MainUI {

    private static final Logger log = Logger.getLogger(MainUI.class);

    private static final String DEFAULT_SERVER_URL = "https://analysis-stable.ingenuity.com";
    public static final String API_PATH_DATASET_UPLOAD = "/pa/api/v1/dataupload";
    public static final String API_PATH_DATASTREAM = "/pa/api/v1/datastream";
    public static final String API_PATH_RUN_ANALYSIS = "/pa/api/v2/multiobsanalysis";
    private static final ComboOption[] API_PATH_VALUES = {
            new ComboOption(API_PATH_DATASET_UPLOAD, "upload dataset"),
            new ComboOption(API_PATH_RUN_ANALYSIS, "upload dataset and run analysis")//,
            //new ComboOption(API_PATH_DATASTREAM, "upload dataset to datastream API (experimental)")
    };
    private static final String DEFAULT_USERNAME = "@ingenuity.com";
    private static final String DEFAULT_PASSWORD = "";
    private static final String DEFAULT_PROJECT_NAME = "Training Project";
    private static final ComboOption[] IPAVIEW_DATASET_VALUES = {
            new ComboOption("projectmanager", "upload and save dataset"),
            new ComboOption("upload", "upload dataset and view - don't save")
    };
    private static final ComboOption[] IPAVIEW_ANALYSIS_VALUES = {
            new ComboOption("projectmanager", "upload and save dataset and run analysis"),
            new ComboOption("createanalysis", "upload dataset, create analysis and view it - don't save")
    };
    private static final ComboOption[] OPEN_IPA_VALUES = {
            new ComboOption("yes", "open IPA after post request was executed"),
            new ComboOption("no", "do not open IPA")
    };
    private static final String DEFAULT_DATASET_NAME = "MyTestDataset";
    private static final String DEFAULT_ANALYSIS_NAME = "MyTestAnalysis";

    private static final ComboOption[] COLUMN_MAPPING_OPTIONS = {
            new ComboOption("geneid", "the gene or protein IDs to be uploaded to IPA"),
            new ComboOption("expvalue", "the first set of expression values"),
            new ComboOption("expval2", "the second set of expression values for the uploaded genes"),
            new ComboOption("expval3", "the thirs set of expression values for the uploaded genes"),
            new ComboOption("obs2expval", "the first set of expression values for the second observation"),
            new ComboOption("obs2expval2", ""),
            new ComboOption("obs2expval3", ""),
            new ComboOption("obs3expval", "the first set of expression values for the third observation"),
            new ComboOption("obs3expval2", ""),
            new ComboOption("obs3expval3", ""),
            new ComboOption("obs4expval", "the first set of expression values for the fourth observation"),
            new ComboOption("obs4expval2", ""),
            new ComboOption("obs4expval3", ""),
            new ComboOption("obs5expval", "the first set of expression values for the fifth observation"),
            new ComboOption("obs5expval2", ""),
            new ComboOption("obs5expval3", ""),
            new ComboOption("obs6expval", "the first set of expression values for the sixth observation"),
            new ComboOption("obs6expval2", ""),
            new ComboOption("obs6expval3", ""),
            new ComboOption("obs7expval", ""),
            new ComboOption("obs7expval2", ""),
            new ComboOption("obs7expval3", ""),
            new ComboOption("obs8expval", ""),
            new ComboOption("obs8expval2", ""),
            new ComboOption("obs8expval3", ""),
            new ComboOption("obs9expval", ""),
            new ComboOption("obs9expval2", ""),
            new ComboOption("obs9expval3", ""),
            new ComboOption("obs10expval", ""),
            new ComboOption("obs10expval2", ""),
            new ComboOption("obs10expval3", ""),
            new ComboOption("obs11expval", ""),
            new ComboOption("obs11expval2", ""),
            new ComboOption("obs11expval3", ""),
            new ComboOption("obs12expval", ""),
            new ComboOption("obs12expval2", ""),
            new ComboOption("obs12expval3", ""),
            new ComboOption("obs13expval", ""),
            new ComboOption("obs13expval2", ""),
            new ComboOption("obs13expval3", ""),
            new ComboOption("obs14expval", ""),
            new ComboOption("obs14expval2", ""),
            new ComboOption("obs14expval3", ""),
            new ComboOption("obs15expval", ""),
            new ComboOption("obs15expval2", ""),
            new ComboOption("obs15expval3", ""),
            new ComboOption("obs16expval", ""),
            new ComboOption("obs16expval2", ""),
            new ComboOption("obs16expval3", ""),
            new ComboOption("obs17expval", ""),
            new ComboOption("obs17expval2", ""),
            new ComboOption("obs17expval3", ""),
            new ComboOption("obs18expval", ""),
            new ComboOption("obs18expval2", ""),
            new ComboOption("obs18expval3", ""),
            new ComboOption("obs19expval", ""),
            new ComboOption("obs19expval2", ""),
            new ComboOption("obs19expval3", ""),
            new ComboOption("obs20expval", ""),
            new ComboOption("obs20expval2", ""),
            new ComboOption("obs20expval3", ""),
    };
    private static final ComboOption[] LOG_LEVELS = {
            new ComboOption("INFO", null),
            new ComboOption("DEBUG", "lists all the fields in the POST request to log output")
    };
    private static final ComboOption[] GENE_ID_TYPES = {
            new ComboOption("abi", "Applied Biosystems"),
            new ComboOption("affymetrix", "Affymetrix"),
            new ComboOption("affymetrixsnp", "Affymetrix SNP ID"),
            new ComboOption("agilent", "Agilent"),
            new ComboOption("cas", "CAS Registry"),
            new ComboOption("ccds", "CCDS"),
            new ComboOption("codelink", "CodeLink"),
            new ComboOption("dbsnp", "dbSNP"),
            new ComboOption("eg_human", "Entrez Gene (human)"),
            new ComboOption("eg_mouse", "Entrez Gene (mouse)"),
            new ComboOption("eg_rat", "Entrez Gene (rat)"),
            new ComboOption("ensembl", "Ensembl"),
            new ComboOption("entrezgene", "Entrez Gene"),
            new ComboOption("genbank", "GenBank"),
            new ComboOption("genpept", "GenPept"),
            new ComboOption("ginumber", "GI Number"),
            new ComboOption("hugo", "HUGO Gene Symbol"),
            new ComboOption("hmdb", "Human Metabolome Database"),
            new ComboOption("illumina", "Illumina"),
            new ComboOption("ing_human", "Ingenuity (human)"),
            new ComboOption("ing_mouse", "Ingenuity (mouse)"),
            new ComboOption("ing_rat", "Ingenuity (rat)"),
            new ComboOption("ingenuity", "Ingenuity"),
            new ComboOption("ipi", "International Protein Index"),
            new ComboOption("kegg", "KEGG ID"),
            new ComboOption("locuslink", "Locus Link"), // this one does not exist in the current SourceType, locus link appears under entrezgene?
            new ComboOption("mirbasemature", "miRBase (mature)"),
            new ComboOption("mirbasestemloop", "miRBaseSt"),
            new ComboOption("mousesymeg", "Gene Symbol - mouse (Entrez Gene)"),
            new ComboOption("pubchem", "PubChem CID"),
            new ComboOption("rategsym", "Gene Symbol - rat (Entrez Gene)"),
            new ComboOption("refseq", "RefSeq"),
            new ComboOption("swissprot", "UniProt/SwissProt Accession"),
            new ComboOption("ucsc_hg18", "UCSC (hg18)"),
            new ComboOption("ucsc_hg19", "UCSC (hg19)"),
            new ComboOption("unigene", "UniGene")
    };
    private static final String FIELD_TYPE_NO_VALUE = "<no value>";
    private static final ComboOption[] EXPRESSION_VALUE_TYPES = {
            new ComboOption(FIELD_TYPE_NO_VALUE, null),
            new ComboOption("ratio", "Ratio values in [0.+INF)"),
            new ComboOption("foldchange", "Fold Change values in (-INF,-1] and [1,+INF)"),
            new ComboOption("logratio", "Log Ratio values in (-INF,+INF)"),
            new ComboOption("pvalue", "p-value in [0,1]"),
            new ComboOption("falsediscovery", "False Discovery Rate, q-value, in [0,100]"),
            new ComboOption("intensity", "Intensity in [0,+INF)"),
            new ComboOption("other", "Other, normalized around zero, values in (-INF,+INF)")
    };
    private static final String TEXT_FILE_CHOOSER_BUTTON = "...";
    private static final String TEXT_SELECT_FILE = "<select file>";
    private static final String TEXT_SUBMIT_BUTTON = "Submit";
    private static final String TEXT_LABEL_FILE_PATH = "File to upload:";
    private static final String TEXT_LABEL_SERVER_PATH = "Server URL:";
    private static final String TEXT_LABEL_API_PATH = "API path:";
    private static final String TEXT_LABEL_USER_NAME = "User name:";
    private static final String TEXT_LABEL_PASSWORD = "Password:";
    private static final String TEXT_LABEL_PROJECT_NAME = "Project name:";
    private static final String TEXT_LABEL_DATASET_NAME = "Dataset name:";
    private static final String TEXT_LABEL_GENE_ID_TYPE = "Gene ID type:";
    private static final String TEXT_LABEL_FILE_COLUMN_MAPPING = "File column mapping to API inputs:";
    private static final String TEXT_LABEL_FILE_COLUMN_MAPPING_EMPTY = "File column mapping to API inputs: load a file!";
    private static final int SIZE_EDIT_PANE_WIDTH = 800;
    private static final int SIZE_EDIT_PANE_HEIGHT = 600;
    private static final int SIZE_LOG_PANE_WIDTH = 300;
    private static final int SIZE_LOG_PANE_HEIGHT = 600;
    private static final String TEXT_PANEL_LOG_PANE_TITLE = "Log output";
    private static final String TEXT_DATASET_CHOOSER_LOAD_BUTTON = "Load";
    private static final String LOG_INDENTATION = "\t";
    private static final String FIELD_CHANGED_ACTION = "comboBoxChanged";
    private static final String TEXT_LABEL_FIELD_TYPES = "Set the field type values for up to three expression values (not all may be required):";
    private static final String TEXT_LABEL_FIELD_TYPE_1 = "expvaltype:";
    private static final String TEXT_LABEL_FIELD_TYPE_2 = "expvaltype2:";
    private static final String TEXT_LABEL_FIELD_TYPE_3 = "expvaltype3:";
    private static final String TEXT_LABEL_IPA_VIEW = "IPA View:";
    private static final String TEXT_LABEL_OPEN_IPA = "Open IPA:";
    private static final String TEXT_LABEL_ANALYSIS_NAME = "Analysis name:";
    public static final String TEXT_LABEL_LOG_LEVEL = "Log level:";
    public static final String TEXT_LABEL_ADDITIONAL_PARAMETERS = "Additional parameters:";


    private JSplitPane mainPanel;

    // panel holding the edit components
    private JPanel editPanel;

    // edit components:
    private JTextField filePath;
    private JButton selectFile;
    private JTextField serverPath;
    private JComboBox apiPath;
    private JTextField userName;
    private JTextField projectName;
    private JComboBox ipaView;
    private JComboBox openIPA;
    private JTextField datasetName;
    private JTextField analysisName;
    private JTextField additionalParameters;
    private JComboBox geneIDType;
    private JComboBox logLevel;
    private JPasswordField password;
    private JButton submit;
    // fields holding the mapping between file columns and API input fields
    private List<JComboBox> fields;
    private JComboBox fieldType1, fieldType2, fieldType3;
    private int fieldsStartAtRow = -1;

    // the file columns
    private List<String> columns;

    public MainUI() {
        init();
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

    private void pickFile() {
        // show file chooser
        JFileChooser datasetChooser = new JFileChooser();
        int returnVal = datasetChooser.showDialog(selectFile, TEXT_DATASET_CHOOSER_LOAD_BUTTON);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = datasetChooser.getSelectedFile();
            log.info("selected file: " + file.getAbsolutePath());
            // set filePath
            filePath.setText(file.getAbsolutePath());
        }
    }

    private void init() {
        log.info("creating main panel");
        mainPanel = new JSplitPane();

        createEditComponents();

        initBasicListeners();

        // build UI
        buildEditPanel();

        JScrollPane scrollEditPane = new JScrollPane(editPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollEditPane.setPreferredSize(new Dimension(SIZE_EDIT_PANE_WIDTH, SIZE_EDIT_PANE_HEIGHT));
        mainPanel.setLeftComponent(scrollEditPane);

        JTextPane logArea = new JTextPane();
        logArea.setEditable(false);
        logArea.setAutoscrolls(true);
        // initialize log4j appender to write in this text area
        new TextAreaAppender(logArea);
        JScrollPane scrollLogArea = new JScrollPane(logArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollLogArea.setPreferredSize(new Dimension(SIZE_LOG_PANE_WIDTH, SIZE_LOG_PANE_HEIGHT));
        scrollLogArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(TEXT_PANEL_LOG_PANE_TITLE),
                BorderFactory.createEmptyBorder(5,5,5,5)));

        mainPanel.setRightComponent(scrollLogArea);


        log.info("UI init done");
    }

    private String getStringValue(JComboBox combo) {
        Object item = combo.getSelectedItem();
        if (item instanceof ComboOption) {
            return ((ComboOption) item).getValue();
        } else if (item instanceof String) {
            return (String) item;
        }
        return null;
    }

    private void initBasicListeners() {
        log.info("initializing listeners");
        filePath.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateColumnMappingFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //updateColumnMappingFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateColumnMappingFields();
            }

            private void updateColumnMappingFields() {
                SwingWorker worker = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        loadHeader();
                        return null;
                    }

                    @Override
                    protected void done() {
                        buildEditPanel();
                        submit.setEnabled(true);
                    }
                };
                worker.execute();
            }
        });
        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickFile();
            }
        });
        apiPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        buildEditPanel();
                    }
                });
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker worker = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        try {
                            executeUpload();
                            return null;
                        } catch (Throwable throwable) {
                            log.error(throwable, throwable);
                            throw throwable;
                        }
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
        logLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String level = ((ComboOption)logLevel.getSelectedItem()).getValue();
                if (level.equals("DEBUG")) {
                    Logger.getLogger(GenericApi.class).setLevel(Level.DEBUG);
                    //Logger.getRootLogger().setLevel(Level.DEBUG);
                } else {
                    Logger.getLogger(GenericApi.class).setLevel(Level.INFO);
                    //Logger.getRootLogger().setLevel(Level.INFO);
                }
            }
        });
    }

    private void buildEditPanel() {
        log.info("building edit panel");

        int panelRow = 0;
        editPanel.removeAll();
        editPanel.add(new JLabel(TEXT_LABEL_FILE_PATH), UIUtil.constraints(0, panelRow));
        editPanel.add(filePath, UIUtil.constraints(1, panelRow, 2, 1));
        editPanel.add(selectFile, UIUtil.constraints(3, panelRow));

        editPanel.add(new JLabel(TEXT_LABEL_SERVER_PATH), UIUtil.constraints(0, ++panelRow));
        editPanel.add(serverPath, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_API_PATH), UIUtil.constraints(0, ++panelRow));
        editPanel.add(apiPath, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_USER_NAME), UIUtil.constraints(0, ++panelRow));
        editPanel.add(userName, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_PASSWORD), UIUtil.constraints(0, ++panelRow));
        editPanel.add(password, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_PROJECT_NAME), UIUtil.constraints(0, ++panelRow));
        editPanel.add(projectName, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_DATASET_NAME), UIUtil.constraints(0, ++panelRow));
        editPanel.add(datasetName, UIUtil.constraints(1, panelRow, 3, 1));

        if (apiPath.getSelectedItem().equals(API_PATH_VALUES[1])) {
            editPanel.add(new JLabel(TEXT_LABEL_ANALYSIS_NAME), UIUtil.constraints(0, ++panelRow));
            editPanel.add(analysisName, UIUtil.constraints(1, panelRow, 3, 1));
        }

        if (apiPath.getSelectedItem().equals(API_PATH_VALUES[1])) {
            int selectedIndex = ipaView.getSelectedIndex();
            ipaView.removeAllItems();
            for (ComboOption item: IPAVIEW_ANALYSIS_VALUES) {
                ipaView.addItem(item);
            }
            ipaView.setSelectedIndex(selectedIndex);
        } else {
            int selectedIndex = ipaView.getSelectedIndex();
            ipaView.removeAllItems();
            for (ComboOption item: IPAVIEW_DATASET_VALUES) {
                ipaView.addItem(item);
            }
            ipaView.setSelectedIndex(selectedIndex);
        }
        editPanel.add(new JLabel(TEXT_LABEL_IPA_VIEW), UIUtil.constraints(0, ++panelRow));
        editPanel.add(ipaView, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_OPEN_IPA), UIUtil.constraints(0, ++panelRow));
        editPanel.add(openIPA, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_GENE_ID_TYPE), UIUtil.constraints(0, ++panelRow));
        editPanel.add(geneIDType, UIUtil.constraints(1, panelRow, 3, 1));

        if (columns != null) {
            fieldsStartAtRow = panelRow + 1;
            // we only add file column mapping fields if we have loaded a file and have columns
            editPanel.add(new JLabel(TEXT_LABEL_FILE_COLUMN_MAPPING), UIUtil.constraints(0, ++panelRow, 4, 1));
            fields = new ArrayList<JComboBox>(columns.size());
            for (int row = 0; row < columns.size(); row++) {
                editPanel.add(new JLabel(columns.get(row) + ":"), UIUtil.constraints(0, ++panelRow));
                JComboBox field = new JComboBox(COLUMN_MAPPING_OPTIONS);
                field.setEditable(true);
                if (row < COLUMN_MAPPING_OPTIONS.length) {
                    field.setSelectedIndex(row);
                } else {
                    field.setSelectedIndex(COLUMN_MAPPING_OPTIONS.length-1);
                }
                fields.add(field);
                editPanel.add(field, UIUtil.constraints(1, panelRow, 3, 1));
            }
            // we also add the field type combos
            editPanel.add(new JLabel(TEXT_LABEL_FIELD_TYPES), UIUtil.constraints(0, ++panelRow, 4, 1));

            editPanel.add(new JLabel(TEXT_LABEL_FIELD_TYPE_1), UIUtil.constraints(0, ++panelRow));
            fieldType1 = new JComboBox(EXPRESSION_VALUE_TYPES);
            editPanel.add(fieldType1, UIUtil.constraints(1, panelRow, 3, 1));

            editPanel.add(new JLabel(TEXT_LABEL_FIELD_TYPE_2), UIUtil.constraints(0, ++panelRow));
            fieldType2 = new JComboBox(EXPRESSION_VALUE_TYPES);
            editPanel.add(fieldType2, UIUtil.constraints(1, panelRow, 3, 1));

            editPanel.add(new JLabel(TEXT_LABEL_FIELD_TYPE_3), UIUtil.constraints(0, ++panelRow));
            fieldType3 = new JComboBox(EXPRESSION_VALUE_TYPES);
            editPanel.add(fieldType3, UIUtil.constraints(1, panelRow, 3, 1));
        } else {
            editPanel.add(new JLabel(TEXT_LABEL_FILE_COLUMN_MAPPING_EMPTY), UIUtil.constraints(0, ++panelRow, 4, 1));
            fieldsStartAtRow = -1;
        }

        editPanel.add(new JLabel(TEXT_LABEL_LOG_LEVEL), UIUtil.constraints(0, ++panelRow));
        editPanel.add(logLevel, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(new JLabel(TEXT_LABEL_ADDITIONAL_PARAMETERS), UIUtil.constraints(0, ++panelRow));
        editPanel.add(additionalParameters, UIUtil.constraints(1, panelRow, 3, 1));

        editPanel.add(submit, UIUtil.constraints(3, ++panelRow));

        log.info("updating main panel UI");
        mainPanel.updateUI();
    }

    private void createEditComponents() {
        log.info("creating edit components");
        editPanel = new JPanel(new GridBagLayout());
        filePath = new JTextField(TEXT_SELECT_FILE);
        filePath.setEditable(false);
        selectFile = new JButton(TEXT_FILE_CHOOSER_BUTTON);
        serverPath = new JTextField(DEFAULT_SERVER_URL);
        apiPath = new JComboBox(API_PATH_VALUES);
        userName = new JTextField(DEFAULT_USERNAME);
        password = new JPasswordField(DEFAULT_PASSWORD);
        projectName = new JTextField(DEFAULT_PROJECT_NAME);
        ipaView = new JComboBox(IPAVIEW_DATASET_VALUES);
        openIPA = new JComboBox(OPEN_IPA_VALUES);
        datasetName = new JTextField(DEFAULT_DATASET_NAME);
        analysisName = new JTextField(DEFAULT_ANALYSIS_NAME);
        geneIDType = new JComboBox(GENE_ID_TYPES);
        geneIDType.setSelectedIndex(1);
        logLevel = new JComboBox(LOG_LEVELS);
        additionalParameters = new JTextField();
        submit = new JButton(TEXT_SUBMIT_BUTTON);
        submit.setEnabled(false);
    }

    private void loadHeader() {
        log.info("loading table header from file");
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

                log.info("loaded " + columns.size() + " columns");
                log.info("loaded columns: " + columns.toString());
            } catch (IOException e) {
                log.error(e, e);
            }
        }
    }

    private void executeUpload() {
        String server = serverPath.getText();
        log.info("executing data upload to server: " + server);

        String uploadAPIPath = getStringValue(apiPath);
        log.info("using API path: " + uploadAPIPath);
        String analysisName = this.analysisName.getText();
        if (API_PATH_DATASET_UPLOAD.equals(uploadAPIPath)) {
            analysisName = null;
        }
        String filePath = this.filePath.getText();

        String projectName = this.projectName.getText();
        log.info("uploading to project: " + projectName);
        String ipaview = getStringValue(this.ipaView);
        log.info("ipaview is: " + ipaview);
        boolean openIPA = "yes".equals(getStringValue(this.openIPA)) ? true : false;
        log.info("opening IPA after post request: " + openIPA);
        if ("upload".equals(ipaview) && (!openIPA)) {
            log.warn("you are uploading a dataset (without saving) and not opening IPA - nothing " +
                    "will be saved in IPA!");
        }
        String datasetName = this.datasetName.getText();
        log.info("uploading dataset with name: " + datasetName);
        String geneIDType = ((ComboOption)this.geneIDType.getSelectedItem()).getValue();
        log.info("gene ID type is: " + geneIDType);

        // build the column mapping
        log.info("building POST data");
        List<String> columnMapping = new ArrayList<String>(fields.size());
        for (JComboBox field: fields) {
            columnMapping.add(getStringValue(field));
        }
        if (log.isInfoEnabled()) {
            log.info("using following table column to POST field mapping:");
            for (int index = 0; index < columnMapping.size(); index++) {
                log.info(LOG_INDENTATION + columns.get(index) + " ---> " + columnMapping.get(index));
            }
        }

        // extract field types
        List<String> fieldTypes = new ArrayList<String>(3);
        if (getStringValue(fieldType1).equals(FIELD_TYPE_NO_VALUE)) {
            fieldTypes.add(null);
        } else {
            fieldTypes.add(getStringValue(fieldType1));
        }
        if (getStringValue(fieldType2).equals(FIELD_TYPE_NO_VALUE)) {
            fieldTypes.add(null);
        } else {
            fieldTypes.add(getStringValue(fieldType2));
        }
        if (getStringValue(fieldType3).equals(FIELD_TYPE_NO_VALUE)) {
            fieldTypes.add(null);
        } else {
            fieldTypes.add(getStringValue(fieldType3));
        }


        /*List<Pair> data = DataUtil.buildPOSTData(filePath, projectName, ipaview, datasetName, analysisName,
                geneIDType, columnMapping, fieldTypes);*/
        List<Pair> data = new ArrayList<Pair>();

        // set generic parameters
        data.add(new Pair("projectname", projectName));
        data.add(new Pair("ipaview", ipaview));
        data.add(new Pair("datasetname", datasetName));
        if (analysisName != null) {
            data.add(new Pair("analysisname", analysisName));
        }
        data.add(new Pair("geneidtype", geneIDType));

        // set field types
        if (fieldTypes.get(0) != null) data.add(new Pair("expvaltype", fieldTypes.get(0)));
        if (fieldTypes.get(1) != null) data.add(new Pair("expvaltype2", fieldTypes.get(1)));
        if (fieldTypes.get(2) != null) data.add(new Pair("expvaltype3", fieldTypes.get(2)));

        // add additional parameters
        data.addAll(DataUtil.parseParameters(additionalParameters.getText()));

        //if (data.size() > 4) {
            //login
            log.info("logging in");
            String username = this.userName.getText();
            String password = new String(this.password.getPassword());
            log.info("using username " + username + " and password <redacted>");
            ApiLogin login = new ApiLogin(username, password, server);
            HttpClient client = login.getClient();
            log.info("login executed: " + login.isLoginExecuted());
            log.info("login successful: " + login.isLoginSuccessful());

            // prepare the generic api
            log.info("initializing generic api for server: " + server);
            GenericApi genericApiTest = new GenericApi(client, "http://localhost:8000");
            GenericApi genericApi = new GenericApi(client, server);

            // we have data, not just generic parameters
            genericApi.executePost(uploadAPIPath, data, "output.txt", openIPA, filePath, columnMapping);
            genericApiTest.executePost(uploadAPIPath, data, "output.txt", openIPA, filePath, columnMapping);
        //}
        log.info("POST request sent");
        log.info("------------------------------------------------------------------------------");
    }





    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "8888");
        System.out.println(System.getProperty("javax.net.ssl.trustStore"));

        MainUI main = new MainUI();
        UIUtil.createAndShowGUI("IPA API Upload", null, main.getMainPanel());
    }
}
