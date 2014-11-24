package org.chronicweirdo.patcher.console;

import org.chronicweirdo.patcher.fileops.Action;
import org.chronicweirdo.patcher.scanner.Entry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 11/24/2014.
 */
public class Console {

    /**
     * Accepted commands:
     *      patch label orig [newlabel]
     *          everything ending in orig in the current folder will be consider a patch that should be reverted
     *          newlabel will be used to backup the files in the current release
     *      patch files file1 [file2 ..] [label]
     *          all listed files will be a patch
     *          if last entry is not a file, it will be treated as a label for the backup files
     * all commands have the following operation:
     *      the input arguments are used to determine the list of files that will be included in the patch
     *      the matcher will find matches in the install location for the current patch
     *      list of operations that will be executed are printed and waiting for user confirmation
     *      if user confirmation, operations will be executed
     *
     * what is missing:
     *      way to determine the install location: command argument
     *      way to determine patch and backup folders: use folder from where command is run
     *      way to determine software stop and start commands: command arguments?
     *
     * so the configuration is defined by "special" settings:
     *      -ir, -installroot
     *      -br, -backuproot
     *      -pr, -patchroot
     *
     *      the three above accept relative paths as arguments
     *
     *      -stop   command for stopping the application
     *      -start  command for starting the application
     *
     * @param args
     */
    public static void main(String[] args) {
        // parse arguments
        List<String> arguments = Arrays.asList(args);
        Configuration configuration = parseArguments(arguments);

        List<Entry> patch = getPatchFiles(configuration);
        List<Entry> files = getInstallFiles(configuration);
        Map<Entry, Entry> matches = getMatches(configuration, patch, files);
        List<Action> actions = getActions(configuration, matches);

        boolean confirmContinue = getConfirmation(actions);
        if (confirmContinue) {
            executeActions(configuration, actions);
        }
    }

    private static void executeActions(Configuration configuration, List<Action> actions) {
        // stop server
        executeCommand(configuration.getStopCommand());
        // execute actions
        for (Action action: actions) {
            action.execute();
        }
        // start server
        executeCommand(configuration.getStartCommand());
    }

    private static void executeCommand(String stopCommand) {
        // execute shell command
    }

    private static boolean getConfirmation(List<Action> actions) {
        // print actions and ask user for confirmation to continue
        return false;
    }

    private static List<Action> getActions(Configuration configuration, Map<Entry, Entry> matches) {
        // use patcher to define actions (move actions to patcher)
        return null;
    }

    private static Map<Entry, Entry> getMatches(Configuration configuration, List<Entry> patch, List<Entry> files) {
        // use matcher to find links between files
        return null;
    }

    private static List<Entry> getInstallFiles(Configuration configuration) {
        // get install files by deep scan of install root
        return null;
    }

    private static List<Entry> getPatchFiles(Configuration configuration) {
        if (configuration.getMode().equals(Configuration.Mode.FILES)) {
            // get exact files
        } else if (configuration.getMode().equals(Configuration.Mode.LABEL)) {
            // (deep) scan patch folder and find patch files ending in label
        }
        return null;
    }

    private static Configuration parseArguments(List<String> arguments) {
        return null;
    }
}
