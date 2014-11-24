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

    public static void patch(String appRoot, String patchRoot, String backupRoot, String label, Map<Entry, Entry> pairs) {
        for (Map.Entry<Entry, Entry> pair: pairs.entrySet()) {
            String originalFile = getPath(appRoot, pair.getKey().getRelativePath(), pair.getKey().getNameString(), null);
            String backupFile = getPath(backupRoot, pair.getKey().getRelativePath(), pair.getKey().getNameString(), label);
            String patchFile = getPath(patchRoot, pair.getValue().getRelativePath(), pair.getValue().getNameString(), null);
            moveFile(originalFile, backupFile);
            moveFile(patchFile, originalFile);
            /*
            if (label != null) {
                // make a backup of original file
                String originalPath = getPath(appRoot, e.getValue().getRelativePath(), e.getValue().getNameString(), null);
                String newPath = getPath(patchRoot, e.getKey().getRelativePath(), e.getValue().getNameString(), label);
                moveFile(originalPath, newPath);
            } else {
                // delete patch file
                String patchPath = getPath(appRoot, e.getValue().getRelativePath(), e.getValue().getNameString(), null);
                deleteFile(patchPath);
            }
            // copy other file to app root, keeping the name of the file in approot
            String appFile = getPath(appRoot, e.getValue().getRelativePath(), e.getValue().getNameString(), null);
            String otherFile = getPath(patchRoot, e.getKey().getRelativePath(), e.getKey().getNameString(), null);
            moveFile(otherFile, appFile);*/
        }
    }

    private static void deleteFile(String patchPath) {
        System.out.println("deleting " + patchPath);
    }

    private static void moveFile(String from, String to) {
        System.out.println("moving " + from + " to " + to);
    }

    private static String getPath(String root, String relativePath, String name, String timestamp) {
        StringBuilder builder = new StringBuilder();
        builder.append(root);
        if (! (root.endsWith("/") || root.endsWith("\\"))) {
            builder.append(File.separator);
        }
        if (relativePath != null && relativePath.length() > 0) {
            builder.append(relativePath);
            builder.append(File.separator);
        }
        builder.append(name);
        if (timestamp != null) {
            builder.append(".");
            builder.append(timestamp);
        }
        return builder.toString();
    }


    private static void move(Entry original, String root, String timestamp) {
        // compute path of where we will move the file
        // compute name of new file
    }

    /**
     * Lists patches found in the backup folder.
     * @param backupRoot
     * @return
     */
    public static Map<String, List<Entry>> getPatches(String backupRoot) {
        return null;
    }

    /**
     * Revers a patch based on its timestamp.
     * @param root
     * @param backupRoot
     * @param timestamp
     */
    public static void revert(String root, String backupRoot, String timestamp) {

    }
}
