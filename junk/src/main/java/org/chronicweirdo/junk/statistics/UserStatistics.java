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

    public static class Statistics {
        int entries;
        int clusters;
        int clustersWithVariation;
        int clustersWithMACVariation;

        public Statistics(int entries, int clusters, int clustersWithVariation, int clustersWithMACVariation) {
            this.entries = entries;
            this.clusters = clusters;
            this.clustersWithVariation = clustersWithVariation;
            this.clustersWithMACVariation = clustersWithMACVariation;
        }
    }

    public static class Fingerprint {
        private String session;
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
        List<List<Statistics>> statistics = new ArrayList<List<Statistics>>();
        for (String path: paths) {
            //String path = paths[0];
            List<Statistics> dss = new ArrayList<>(6);
            System.out.println("clustering with last logged and one way matching");
            dss.add(runStatistics(path, new OneWayLastLoggedClusterMatcher()));
            System.out.println("clustering with last logged old matching");
            dss.add(runStatistics(path, new OldClusterMatcher()));
            System.out.println("combined clustering");
            dss.add(runStatistics(path, new CombinedClusterMatched()));
            statistics.add(dss);
        }

        System.out.println("# of clusters");
        System.out.println("dataset,one way matching,last logged one way matching, two way matching, last logged two way matching, old matching, last logged old matching,combined");
        for (int i = 0; i < statistics.size(); i++) {
            List<Statistics> datasetStatistics = statistics.get(i);
            System.out.print(paths[i].substring(paths[i].lastIndexOf("\\")+1) + ",");
            for (Statistics s: datasetStatistics) {
                System.out.print(s.clusters + ",");
            }
            System.out.println();
        }

        System.out.println("# of clusters with variation (more than one signature per cluster)");
        System.out.println("dataset,one way matching,last logged one way matching, two way matching, last logged two way matching, old matching, last logged old matchingcombined");
        for (int i = 0; i < statistics.size(); i++) {
            List<Statistics> datasetStatistics = statistics.get(i);
            System.out.print(paths[i].substring(paths[i].lastIndexOf("\\")+1) + ",");
            for (Statistics s: datasetStatistics) {
                System.out.print(s.clustersWithVariation + ",");
            }
            System.out.println();
        }

        System.out.println("# of clusters with mac variation (primary mac address varies in the cluster)");
        System.out.println("dataset,one way matching,last logged one way matching, two way matching, last logged two way matching, old matching, last logged old matching");
        for (int i = 0; i < statistics.size(); i++) {
            List<Statistics> datasetStatistics = statistics.get(i);
            System.out.print(paths[i].substring(paths[i].lastIndexOf("\\")+1) + ",");
            for (Statistics s: datasetStatistics) {
                System.out.print(s.clustersWithMACVariation + ",");
            }
            System.out.println();
        }

        /*for (String path: paths) {
            clusteringWithTwoWayMatching(path);
        }*/
        System.out.println("--~ the end ~--");
    }

    public static interface ClusterMatcher {
        boolean matchesCluster(Fingerprint fingerprint, List<Fingerprint> cluster);
    }

    public static class OneWayLastLoggedClusterMatcher implements ClusterMatcher {
        @Override
        public boolean matchesCluster(Fingerprint fingerprint, List<Fingerprint> cluster) {
            Fingerprint f = cluster.get(cluster.size() - 1);
            if (similar(fingerprint, f)) {
                return true;
            }
            return false;
        }
    }

    public static class OldClusterMatcher implements ClusterMatcher {
        @Override
        public boolean matchesCluster(Fingerprint fingerprint, List<Fingerprint> cluster) {
            Fingerprint f = cluster.get(cluster.size() - 1);
            if (match(fingerprint, f)) {
                return true;
            }
            return false;
        }
    }

    public static class CombinedClusterMatched implements ClusterMatcher {
        @Override
        public boolean matchesCluster(Fingerprint fingerprint, List<Fingerprint> cluster) {
            Fingerprint f = cluster.get(cluster.size() - 1);
            if (match(fingerprint, f)) {
                return true;
            } else if (similar(fingerprint, f) || similar(f, fingerprint)) {
                return true;
            }
            return false;
        }
    }

    private static Statistics runStatistics(String path, ClusterMatcher clusterMatcher) throws IOException {
        Map<String, Map<String, String>> data = parseFile(path);
        List<Fingerprint> fingerprints = getFingerprints(data);
        System.out.println(fingerprints.size());

        List<List<Fingerprint>> clusters = new ArrayList<>();
        // take each fingerprint and try to add it to a cluster or create a new cluster for it
        for (Fingerprint current: fingerprints) {
            int matchingCluster = -1;
            for (int i = 0; i < clusters.size(); i++) {
                if (clusterMatcher.matchesCluster(current, clusters.get(i))) {
                    matchingCluster = i;
                    break;
                }
            }
            if (matchingCluster == -1) {
                // add new cluster
                List<Fingerprint> cluster = new ArrayList<>();
                cluster.add(current);
                clusters.add(cluster);
            } else {
                if (! clusters.get(matchingCluster).contains(current)) {
                    // don't add identical computers to a cluster
                    clusters.get(matchingCluster).add(current);
                }
            }
        }
        System.out.println("found clusters: " + clusters.size());
        List<List<Fingerprint>> clustersWithVariation = new ArrayList<>();
        for (List<Fingerprint> cluster: clusters) {
            if (cluster.size() > 1) {
                clustersWithVariation.add(cluster);
            }
        }
        System.out.println("# of clusters with variation: " + clustersWithVariation.size());
        int macVaries = 0;
        for (List<Fingerprint> cluster: clustersWithVariation) {
            if (primaryMacVaries(cluster)) {
                macVaries++;
            }
        }
        return new Statistics(data.size(), clusters.size(), clustersWithVariation.size(), macVaries);
    }

    private static boolean primaryMacVaries(List<Fingerprint> cluster) {
        String primaryMac = cluster.get(0).macAddress.get(0);
        for (int i = 1; i < cluster.size(); i++) {
            if (cluster.get(i).macAddress == null || cluster.get(i).macAddress.size() == 0) return true;
            if (! cluster.get(i).macAddress.get(0).equals(primaryMac)) {
                return true;
            }
        }
        return false;
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

    private static boolean match(Fingerprint current, Fingerprint fingerprint) {
        // check primary attributes
        if (! current.userHome.equals(fingerprint.userHome)) return false;
        if (current.macAddress == null || current.macAddress.size() == 0) return false;
        if (fingerprint.macAddress == null || fingerprint.macAddress.size() == 0) return false;
        if (! current.macAddress.get(0).equals(fingerprint.macAddress.get(0))) return false;
        return true;
    }

    private static List<Fingerprint> getFingerprints(Map<String, Map<String, String>> data) {
        List<Fingerprint> fingerprints = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry: data.entrySet()) {
            Fingerprint fingerprint = new Fingerprint();
            fingerprint.session = entry.getKey();
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
