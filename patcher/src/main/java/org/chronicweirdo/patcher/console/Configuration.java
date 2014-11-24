package org.chronicweirdo.patcher.console;

import java.util.List;

/**
 * Created by scacoveanu on 11/24/2014.
 */
public class Configuration {

    public enum Mode {
        FILES, LABEL
    }

    private String installRoot;
    private String patchRoot;
    private String backupRoot;

    private String stopCommand;
    private String startCommand;

    private Mode mode;

    private List<String> files;
    private String patchLabel;
    private String backupLabel;

    public String getInstallRoot() {
        return installRoot;
    }

    public void setInstallRoot(String installRoot) {
        this.installRoot = installRoot;
    }

    public String getPatchRoot() {
        return patchRoot;
    }

    public void setPatchRoot(String patchRoot) {
        this.patchRoot = patchRoot;
    }

    public String getBackupRoot() {
        return backupRoot;
    }

    public void setBackupRoot(String backupRoot) {
        this.backupRoot = backupRoot;
    }

    public String getStopCommand() {
        return stopCommand;
    }

    public void setStopCommand(String stopCommand) {
        this.stopCommand = stopCommand;
    }

    public String getStartCommand() {
        return startCommand;
    }

    public void setStartCommand(String startCommand) {
        this.startCommand = startCommand;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public String getPatchLabel() {
        return patchLabel;
    }

    public void setPatchLabel(String patchLabel) {
        this.patchLabel = patchLabel;
    }

    public String getBackupLabel() {
        return backupLabel;
    }

    public void setBackupLabel(String backupLabel) {
        this.backupLabel = backupLabel;
    }
}
