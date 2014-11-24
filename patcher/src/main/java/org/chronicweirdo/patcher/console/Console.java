package org.chronicweirdo.patcher.console;

import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 11/24/2014.
 */
public class Console {

    private static final String LABEL = "label";

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
        List<String> arguments = Arrays.asList(args);
        if (LABEL.equals(arguments.get(0))) {

        }

    }

}
