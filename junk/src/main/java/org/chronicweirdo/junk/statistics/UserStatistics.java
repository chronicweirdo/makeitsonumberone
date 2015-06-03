package org.chronicweirdo.junk.statistics;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by scacoveanu on 3/6/2015.
 */
public class UserStatistics {

    public static class Fingerprint {
        private String osName;
        private String userHome;
        private List<String> macAddress;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fingerprint that = (Fingerprint) o;

            if (macAddress != null ? !macAddress.equals(that.macAddress) : that.macAddress != null) return false;
            if (osName != null ? !osName.equals(that.osName) : that.osName != null) return false;
            if (userHome != null ? !userHome.equals(that.userHome) : that.userHome != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = osName != null ? osName.hashCode() : 0;
            result = 31 * result + (userHome != null ? userHome.hashCode() : 0);
            result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] paths = {
                "C:\\Users\\scacoveanu\\Downloads\\franck.letourneur.csv",
                "C:\\Users\\scacoveanu\\Downloads\\hel23.csv",
                "C:\\Users\\scacoveanu\\Downloads\\mark.boekschoten.csv",
                "C:\\Users\\scacoveanu\\Downloads\\o.vasieva.csv",
                "C:\\Users\\scacoveanu\\Downloads\\qiuxc.csv"
        };
        //readAllFilesAndSeeAttributeCountUnder4();
        /*System.out.println("\"test\"");
        System.out.println(strip("\"test\""));*/

        //basicStatistics("C:\\Users\\scacoveanu\\Downloads\\franck.letourneur.csv");
        basicClusteringWithDuplicates(paths[3]);

    }

    private static void basicStatistics(String path) throws IOException {
        Map<String, Map<String, String>> data = parseFile(path);
        List<Fingerprint> fingerprints = getFingerprints(data);
        System.out.println(fingerprints.size());

        int fingerprintsWithMoreMacs = 0;
        int fingerprintsWithNoMacs = 0;
        for (Fingerprint fingerprint: fingerprints) {
            if (fingerprint.macAddress.size() > 1) {
                fingerprintsWithMoreMacs++;
            }
            if (fingerprint.macAddress.size() == 0) {
                fingerprintsWithNoMacs++;
            }
        }
        System.out.println(fingerprintsWithMoreMacs);
        System.out.println(fingerprintsWithNoMacs);

        // for each fingerprint check how many similar previours fingerprints there are
        for (int i = 0; i < fingerprints.size(); i++) {
            Fingerprint current = fingerprints.get(i);
            List<Fingerprint> remaining = new ArrayList<>(fingerprints);
            remaining.remove(current);
            int similarities = 0;
            for (Fingerprint f: remaining) {
                if (similar(current, f)) {
                    similarities++;
                }
            }
            System.out.println(similarities);
        }
    }

    private static void basicClusteringWithDuplicates(String path) throws IOException {
        Map<String, Map<String, String>> data = parseFile(path);
        List<Fingerprint> fingerprints = getFingerprints(data);
        System.out.println(fingerprints.size());

        List<List<Fingerprint>> clusters = new ArrayList<>();
        // take each fingerprint and try to add it to a cluster or create a new cluster for it
        for (Fingerprint current: fingerprints) {
            int matchingCluster = -1;
            for (int i = 0; i < clusters.size(); i++) {
                for (Fingerprint f: clusters.get(i)) {
                    if (similar(current, f)) {
                        matchingCluster = i;
                        break;
                    }
                }
            }
            if (matchingCluster == -1) {
                // add new cluster
                List<Fingerprint> cluster = new ArrayList<>();
                cluster.add(current);
                clusters.add(cluster);
            } else {
                clusters.get(matchingCluster).add(current);
            }
        }
        System.out.println("found clusters: " + clusters.size());
    }

    private static boolean similar(Fingerprint current, Fingerprint fingerprint) {
        // check primary attributes
        if (! current.osName.equals(fingerprint.osName)) return false;
        if (! current.userHome.equals(fingerprint.userHome)) return false;
        // check percentage of secondary attributes
        int found = 0;
        for (String mac: current.macAddress) {
            if (fingerprint.macAddress.contains(mac)) {
                found++;
            }
        }
        double percent = (double)found / current.macAddress.size();
        /*if (found > 0 && found < current.macAddress.size()) {
            System.out.println((percent * 100) + "%");
        }*/
        if (percent < .8) return false;
        return true;
    }

    private static List<Fingerprint> getFingerprints(Map<String, Map<String, String>> data) {
        List<Fingerprint> fingerprints = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry: data.entrySet()) {
            Fingerprint fingerprint = new Fingerprint();
            fingerprint.osName = entry.getValue().get("os_name");
            fingerprint.userHome = entry.getValue().get("user_home");
            fingerprint.macAddress = new ArrayList<String>();
            for (Map.Entry<String, String> attribute: entry.getValue().entrySet()) {
                if (attribute.getKey().startsWith("mac_address")) {
                    fingerprint.macAddress.add(attribute.getValue());
                }
            }
            fingerprints.add(fingerprint);
        }
        return fingerprints;
    }

    private static void readAllFilesAndSeeAttributeCountUnder4() throws IOException {
        // read file
        Map<String, Map<String, String>> data = new HashMap<>();
        data.putAll(parseFile("C:\\Users\\scacoveanu\\Downloads\\franck.letourneur.csv"));
        data.putAll(parseFile("C:\\Users\\scacoveanu\\Downloads\\hel23.csv"));
        data.putAll(parseFile("C:\\Users\\scacoveanu\\Downloads\\mark.boekschoten.csv"));
        data.putAll(parseFile("C:\\Users\\scacoveanu\\Downloads\\o.vasieva.csv"));
        data.putAll(parseFile("C:\\Users\\scacoveanu\\Downloads\\qiuxc.csv"));
        System.out.println(data.size());
        //System.out.println(data.values().iterator().next());
        int lessThanFourAttributes = 0;
        for (Map.Entry<String, Map<String, String>> entry: data.entrySet()) {
            if (entry.getValue().size() < 4) {
                lessThanFourAttributes++;
                /*System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println();*/
            }
        }
        System.out.println(lessThanFourAttributes + "/" + data.size());
    }

    private static Map<String, Map<String, String>> parseFile(String path) throws IOException {
        Map<String, Map<String, String>> data = new HashMap<>();
        List<String> lines = Files.readAllLines(new File(path).toPath(), Charset.forName("ISO-8859-1"));
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] tokens = line.split(",");
            String id = strip(tokens[0]);
            String name = strip(tokens[8]);
            String value = strip(tokens[9]);
            if (! data.containsKey(id)) {
                data.put(id, new HashMap<>());
            }
            data.get(id).put(name, value);
        }
        return data;
    }

    private static String strip(String token) {
        if (token.startsWith("\"") && token.endsWith("\"")) {
            return token.substring(1, token.length()-1);
        }
        return token;
    }
}
