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

    public static void patch(String appRoot, String patchRoot, Map<Entry, Entry> files, String timestamp) {
        // if we have a timestamp, we are making a patch, if not, we are reverting a patch
        for (Map.Entry<Entry, Entry> e: files.entrySet()) {
            if (timestamp != null) {
                // make a backup of original file
                String originalPath = getPath(appRoot, e.getValue().getRelativePath(), e.getValue().getNameString(), null);
                String newPath = getPath(patchRoot, e.getKey().getRelativePath(), e.getValue().getNameString(), timestamp);
                moveFile(originalPath, newPath);
            } else {
                // delete patch file
                String patchPath = getPath(appRoot, e.getValue().getRelativePath(), e.getValue().getNameString(), null);
                deleteFile(patchPath);
            }
            // copy other file to app root, keeping the name of the file in approot
            String appFile = getPath(appRoot, e.getValue().getRelativePath(), e.getValue().getNameString(), null);
            String otherFile = getPath(patchRoot, e.getKey().getRelativePath(), e.getKey().getNameString(), null);
            moveFile(otherFile, appFile);
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


    /**
     * Applies a patch.
     * @param root
     * @param patchRoot
     * @param backupRoot
     * @param patch
     */
    public static void patch(String root, String patchRoot, String backupRoot, Map<Entry, Entry> patch) {
        // get patch timestamp
        String timestamp = Long.toString(System.currentTimeMillis());

        // backup original files
        for (Map.Entry<Entry, Entry> item: patch.entrySet()) {

        }
        // copy new files
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
