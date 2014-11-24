package org.chronicweirdo.patcher.fileops;

import org.chronicweirdo.patcher.scanner.Entry;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * What is a patch? A patch is switching files between themselves, with some naming rules.
 *
 * Patching: backup original files (rename them using patch timestamp), put in patch files (rename the using original
 * file names).
 *
 * MOVE(ADD_TIMESTAMP_RENAME_RULE), MOVE(USE_ORIGINAL_RENAME_RULE)
 *
 * REMOVE, MOVE(REMOVE_TIMESTAMP_RENAME_RULE)
 *
 *
 * Created by scacoveanu on 10/17/2014.
 */
public class Patcher {

    /*
    There is a patch folder. In this folder we have files. These files can be "pristine" or patch backups.
    When we apply a patch, we do a simple run, or we revert a patch.

    How do we distinguish between pristines or backups? do we use some code, or do we give a list of files we want to
    patch?

    Start with a list of files.
     */

    public static void patch(String appRoot, String patchRoot, String backupRoot, String label, Map<Entry, Entry> pairs, boolean userRelativePathForBackup) {
        for (Map.Entry<Entry, Entry> pair: pairs.entrySet()) {
            String originalFile = getPath(appRoot, pair.getKey().getRelativePath(), pair.getKey().getNameString(), null, true);
            if (label != null) {
                String backupFile = getPath(backupRoot, pair.getKey().getRelativePath(), pair.getKey().getNameString(), label, userRelativePathForBackup);
                moveFile(originalFile, backupFile);
            } else {
                deleteFile(originalFile);
            }
            String patchFile = getPath(patchRoot, pair.getValue().getRelativePath(), pair.getValue().getNameString(), null, true);
            moveFile(patchFile, originalFile);
        }
    }

    private static void deleteFile(String patchPath) {
        System.out.println("deleting " + patchPath);
    }

    private static void moveFile(String from, String to) {
        System.out.println("moving " + from + " to " + to);
    }

    private static String getPath(String root, String relativePath, String name, String timestamp, boolean userRelativePath) {
        StringBuilder builder = new StringBuilder();
        builder.append(root);
        if (! (root.endsWith("/") || root.endsWith("\\"))) {
            builder.append(File.separator);
        }
        if (userRelativePath) {
            if (relativePath != null && relativePath.length() > 0) {
                builder.append(relativePath);
                builder.append(File.separator);
            }
        }
        builder.append(name);
        if (timestamp != null) {
            builder.append(".");
            builder.append(timestamp);
        }
        return builder.toString();
    }
}
