package com.ingenuity.temp.api;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * Created by scacoveanu on 5/6/2014.
 */
public class FileComparer {

    private static final Logger log = Logger.getLogger(FileComparer.class);

    public static void findDifferentLines(String file1, String file2) {
        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file1))));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file2))));

            int line = 1;

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            while (line1 != null && line2 != null) {
                if (!line1.equalsIgnoreCase(line2)) {
                    System.out.println("line " + line + " mismatch: ");
                    System.out.println(line1);
                    System.out.println(line2);
                    System.out.println();
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                line++;
            }

            reader1.close();
            reader2.close();
        } catch (FileNotFoundException e) {
            log.error(e, e);
        } catch (IOException e) {
            log.error(e, e);
        }
    }

    private static boolean equalTokens(String token1, String token2) {
        token1 = token1.trim();
        token2 = token2.trim();
        return token1.equalsIgnoreCase(token2);
    }

    public static void findDifferentTokens(String file1, String file2) {
        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file1))));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file2))));

            int line = 1;

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            boolean foundDifference = false;
            while (line1 != null && line2 != null) {
                foundDifference = false;
                String[] tokens1 = line1.split("\t");
                String[] tokens2 = line2.split("\t");

                for (int index = 0; index < tokens1.length && index < tokens2.length; index++) {
                    if (!equalTokens(tokens1[index], tokens2[index])) {
                        foundDifference = true;
                        System.out.println("difference on line " + line + " token " + index + ": "
                                + tokens1[index] + " --- " + tokens2[index]);
                    }
                }
                if (foundDifference) {
                    System.out.println();
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                line++;
            }

            reader1.close();
            reader2.close();
        } catch (FileNotFoundException e) {
            log.error(e, e);
        } catch (IOException e) {
            log.error(e, e);
        }
    }

    public static void compareTables(String file1, String file2) {
        TableRowEqualizer equalizer = new TableRowEqualizer(1, 2, 3, 4, 5, 6, 7, 8);
        List<TableRow> table1 = readTable(file1, 3, equalizer);
        List<TableRow> table2 = readTable(file2, 3, equalizer);


        // find consistency score in each file
        Map<TableRow, List<String>> consistencyScores = new HashMap<TableRow, List<String>>();
        for (int index = 0; index < table1.size(); index++) {
            List<String> score = new ArrayList<String>();
            score.add(table1.get(index).entries.get(0));
            consistencyScores.put(table1.get(index), score);
        }
        for (int index = 0; index < table2.size(); index++) {
            List<String> score = consistencyScores.get(table1.get(index));
            score.add(table2.get(index).entries.get(0));
        }
        System.out.println(consistencyScores.size());
        for (Map.Entry<TableRow, List<String>> entry: consistencyScores.entrySet()) {
            String score1 = entry.getValue().get(0);
            String score2 = entry.getValue().get(1);
            if (!score1.equals(score2)) {
                System.out.println("row " + entry.getKey().toString() + " consistency score " + score1 + " and " + score2);
            }
        }
    }

    public static List<TableRow> readTable(String file, int startLine, TableRowEqualizer equalizer) {
        List<TableRow> table = new ArrayList<TableRow>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));

            int lineNum = 1;
            String line = reader.readLine();
            while (line != null) {
                if (lineNum >= startLine) {
                    TableRow row = new TableRow(equalizer, line);
                    table.add(row);
                }
                line = reader.readLine();
                lineNum++;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            log.error(e, e);
        } catch (IOException e) {
            log.error(e, e);
        }
        return table;
    }

    public static class TableRowEqualizer {
        List<Integer> indexes; // indexes that count in the equals and hash code methods

        public TableRowEqualizer(Integer ... indexes) {
            this.indexes = new ArrayList<Integer>();
            for (Integer index: indexes) {
                this.indexes.add(index);
            }
        }

        public boolean equalize(TableRow thisRow, Object object) {
            if (thisRow == object) return true;
            if (object == null || thisRow.getClass() != object.getClass()) return false;

            TableRow tableRow = (TableRow) object;

            // go through all entries that count and check if they are equal
            for (Integer index: indexes) {
                if (!thisRow.entries.get(index).equals(tableRow.entries.get(index))) return false;
            }

            return true;
        }

        public int hash(TableRow thisRow) {
            final int prime = 31;
            int result = 1;
            for (Integer index: indexes) {
                result = result * prime + thisRow.entries.get(index).hashCode();
            }
            return result;
        }
    }
    public static class TableRow {
        private TableRowEqualizer equalizer;
        public List<String> entries;


        public TableRow(TableRowEqualizer equalizer, String line) {
            this.equalizer = equalizer;
            String[] tokens = line.split("\t");
            entries = new ArrayList<String>(Arrays.asList(tokens));
        }

        @Override
        public boolean equals(Object o) {
            return equalizer.equalize(this, o);
        }

        @Override
        public int hashCode() {
            return equalizer.hash(this);
        }

        @Override
        public String toString() {
            return "TableRow{" +
                    "entries=" + entries.toString() +
                    '}';
        }
    }


}
