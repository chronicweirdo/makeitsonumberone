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
        int problematicsSize;

        public Statistics(int entries, int clusters, int clustersWithVariation, int clustersWithMACVariation, int problematicsSize) {
            this.entries = entries;
            this.clusters = clusters;
            this.clustersWithVariation = clustersWithVariation;
            this.clustersWithMACVariation = clustersWithMACVariation;
            this.problematicsSize = problematicsSize;
        }
    }

    public static class Fingerprint {
        private String session;
        private String osName;
        private String userHome;
        private String ram;
        private List<String> macAddress;

        /*@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fingerprint that = (Fingerprint) o;

            if (macAddress != null ? !macAddress.equals(that.macAddress) : that.macAddress != null) return false;
            if (osName != null ? !osName.equals(that.osName) : that.osName != null) return false;
            if (ram != null ? !ram.equals(that.ram) : that.ram != null) return false;
            if (userHome != null ? !userHome.equals(that.userHome) : that.userHome != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = osName != null ? osName.hashCode() : 0;
            result = 31 * result + (userHome != null ? userHome.hashCode() : 0);
            result = 31 * result + (ram != null ? ram.hashCode() : 0);
            result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
            return result;
        }*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fingerprint that = (Fingerprint) o;

            if (macAddress != null ? !macAddress.equals(that.macAddress) : that.macAddress != null) return false;
            if (osName != null ? !osName.equals(that.osName) : that.osName != null) return false;
            if (ram != null ? !ramEquals(Fingerprint.this, that) : that.ram != null) return false;
            if (session != null ? !session.equals(that.session) : that.session != null) return false;
            if (userHome != null ? !userHome.equals(that.userHome) : that.userHome != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = session != null ? session.hashCode() : 0;
            result = 31 * result + (osName != null ? osName.hashCode() : 0);
            result = 31 * result + (userHome != null ? userHome.hashCode() : 0);
            result = 31 * result + (ram != null ? ram.hashCode() : 0);
            result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] paths = {
                /*"C:\\Users\\scacoveanu\\Downloads\\franck.letourneur.csv",
                "C:\\Users\\scacoveanu\\Downloads\\hel23.csv",
                "C:\\Users\\scacoveanu\\Downloads\\jcanongo.csv",
                "C:\\Users\\scacoveanu\\Downloads\\o.vasieva.csv",
                "C:\\Users\\scacoveanu\\Downloads\\qiuxc.csv",*/
                "C:\\Users\\scacoveanu\\Downloads\\guenter.jaeger.csv"
        };

        List<List<Statistics>> statistics = new ArrayList<List<Statistics>>();
        for (String path: paths) {
            List<Fingerprint> fingerprints = getFingerprints(path);

            List<Statistics> dss = new ArrayList<>(6);
            //System.out.println("clustering with last logged and one way matching");
            //dss.add(runStatistics(fingerprints, new OneWayLastLoggedClusterMatcher()));
            //System.out.println("clustering with last logged old matching");
            //dss.add(runStatistics(fingerprints, new OldClusterMatcher()));
            //System.out.println("combined clustering");
            //dss.add(runStatistics(fingerprints, new CombinedClusterMatched()));
            /*System.out.println("complex clustering");
            dss.add(runStatistics(fingerprints, new RAMAndVariableThresholdClusterMatcher()));*/
            System.out.println("complex primary mac clustering");
            dss.add(runStatistics(fingerprints, new RAMPrimaryMACAndVariableThresholdClusterMatcher()));
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
        System.out.println("# of problematic computers");
        for (int i = 0; i < statistics.size(); i++) {
            List<Statistics> datasetStatistics = statistics.get(i);
            System.out.print(paths[i].substring(paths[i].lastIndexOf("\\")+1) + ",");
            for (Statistics s: datasetStatistics) {
                System.out.print(s.problematicsSize + ",");
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

    public static class RAMAndVariableThresholdClusterMatcher implements ClusterMatcher {
        @Override
        public boolean matchesCluster(Fingerprint fingerprint, List<Fingerprint> cluster) {
            Fingerprint f = cluster.get(cluster.size() - 1);
            if (complexSimilar(fingerprint, f)) {
                return true;
            }
            return false;
        }
    }

    public static class RAMPrimaryMACAndVariableThresholdClusterMatcher implements ClusterMatcher {
        @Override
        public boolean matchesCluster(Fingerprint fingerprint, List<Fingerprint> cluster) {
            Fingerprint f = cluster.get(cluster.size() - 1);
            if (complexPrimaryMACSimilar(fingerprint, f)) {
                return true;
            }
            return false;
        }
    }

    private static Statistics runStatistics(List<Fingerprint> fingerprints, ClusterMatcher clusterMatcher) throws IOException {

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

        Map<String, Integer> sessionToClusterMap = new HashMap<>();
        for (int i = 0; i < clusters.size(); i++) {
            for (Fingerprint f: clusters.get(i)) {
                sessionToClusterMap.put(f.session, i);
            }
        }
        System.out.println("session 3461751 cluster " + sessionToClusterMap.get("3461751"));
        System.out.println("session 3613550 cluster " + sessionToClusterMap.get("3613550"));
        System.out.println("session 3889235 cluster " + sessionToClusterMap.get("3889235"));
        System.out.println("session 3680071 cluster " + sessionToClusterMap.get("3680071"));

        //int problematics = buildProblematicCollection(fingerprints, clusters);
        int problematics = buildProblematicClusters(fingerprints, clusters);

        return new Statistics(fingerprints.size(), clusters.size(), clustersWithVariation.size(), macVaries, problematics);
    }

    private static class Pair<T> {
        T f1, f2;

        private Pair(T f1, T f2) {
            this.f1 = f1;
            this.f2 = f2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (f1 != null ? !f1.equals(pair.f1) : pair.f1 != null) return false;
            if (f2 != null ? !f2.equals(pair.f2) : pair.f2 != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = f1 != null ? f1.hashCode() : 0;
            result = 31 * result + (f2 != null ? f2.hashCode() : 0);
            return result;
        }
    }

    private static int buildProblematicCollection(List<Fingerprint> fingerprints, List<List<Fingerprint>> clusters) {
        Set<Pair> problematic = new HashSet<>();
        for (int i = 0; i < fingerprints.size(); i++) {
            for (int j = i+1; j < fingerprints.size(); j++) {
                Fingerprint f1 = fingerprints.get(i);
                Fingerprint f2 = fingerprints.get(j);
                if (f1.osName.equals(f2.osName) && f1.userHome.equals(f2.userHome)
                        /*&& ramEquals(f1, f2)*/) {
                    int c1 = getCluster(f1, clusters);
                    int c2 = getCluster(f2, clusters);
                    if (c1 != c2) {
                        problematic.add(new Pair(f1, f2));
                    }
                }
            }
        }
        System.out.println("problematics found: " + problematic.size());
        return problematic.size();
    }

    private static int buildProblematicClusters(List<Fingerprint> fingerprints, List<List<Fingerprint>> clusters) {
        Set<Pair> problematic = new HashSet<>();
        for (int i = 0; i < clusters.size(); i++) {
            for (int j = i+1; j < clusters.size(); j++) {
                List<Fingerprint> cluster1 = clusters.get(i);
                List<Fingerprint> cluster2 = clusters.get(j);
                if (cluster1.get(0).osName.equals(cluster2.get(0).osName)
                        && cluster1.get(0).userHome.equals(cluster2.get(0).userHome)) {
                        problematic.add(new Pair(cluster1, cluster2));
                }
            }
        }
        System.out.println("problematics found: " + problematic.size());
        return problematic.size();
    }

    private static boolean ramEquals(Fingerprint f1, Fingerprint f2) {
        if (f1.ram == null || f2.ram == null) return false;
        return f1.ram.equals(f2.ram);
    }

    /*private static Set<Pair> trim(Set<Pair> original) {
        Set<Pair> trimmed = new HashSet<>();
        for (Pair p: original) {
            int found = 0;
            for (String mac: p.f1.macAddress) {
                if (p.f2.macAddress.contains(mac)) {
                    found++;
                }
            }
            double percent = (double)found / p.f1.macAddress.size();
            if (percent > 0 && ramEquals(p.f1, p.f2)) {
                trimmed.add(p);
            }
        }
        return trimmed;
    }*/

    private static int getCluster(Fingerprint fingerprint, List<List<Fingerprint>> clusters) {
        for (int i = 0; i < clusters.size(); i++) {
            if (clusters.get(i).contains(fingerprint)) {
                return i;
            }
        }
        return -1;
    }

    private static List<Fingerprint> getFingerprints(String path) throws IOException {
        Map<String, Map<String, String>> data = parseFile(path);
        return getFingerprints(data);
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

    private static boolean ramMissing(String ram) {
        try {
            Long.parseLong(ram);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean complexSimilar(Fingerprint current, Fingerprint fingerprint) {
        // user home 100% matching
        if (! current.userHome.equals(fingerprint.userHome)) return false;
        // os name equals? fine
        if (! current.osName.equals(fingerprint.osName)) {
            // os name different? can we use ram? do a ram match
            if (ramMissing(current.ram) || ramMissing(fingerprint.ram)) {
                // os name different? ram missing as well? a free ride
                return true;
            } else {
                long ram1 = Long.parseLong(current.ram);
                long ram2 = Long.parseLong(fingerprint.ram);
                if (Math.abs(ram1 - ram2) > 1000) {
                    return false;
                }
            }
        }

        // last step is to look at a variable ram matcher
        int found = 0;
        for (String mac: current.macAddress) {
            if (fingerprint.macAddress.contains(mac)) {
                found++;
            }
        }
        double percent = (double)found / current.macAddress.size();
        if (current.macAddress.size() == 0) return true;
        if (current.macAddress.size() == 1 && percent < 1) return false;
        if (current.macAddress.size() == 2 && percent < 0.5) return false;
        if (current.macAddress.size() == 3 && percent < 0.65) return false;
        if (current.macAddress.size() == 4 && percent < 0.75) return false;
        if (current.macAddress.size() >= 5 && percent < 0.8) return false;
        return true;
    }

    private static boolean complexPrimaryMACSimilar(Fingerprint current, Fingerprint fingerprint) {
        // user home 100% matching
        if (! current.userHome.equals(fingerprint.userHome)) return false;
        // os name equals? fine
        if (! current.osName.equals(fingerprint.osName)) {
            // os name different? can we use ram? do a ram match
            if (ramMissing(current.ram) || ramMissing(fingerprint.ram)) {
                // os name different? ram missing as well? a free ride
                return true;
            } else {
                long ram1 = Long.parseLong(current.ram);
                long ram2 = Long.parseLong(fingerprint.ram);
                if (Math.abs(ram1 - ram2) > 1000) {
                    return false;
                }
            }
        }

        int found = 0;
        for (String mac: current.macAddress) {
            if (fingerprint.macAddress.contains(mac)) {
                found++;
            }
        }
        double percent = (double)found / current.macAddress.size();
        // last step is to look at a variable with different thresholds depending on
        // wether the primary mac matches or not
        if (current.macAddress.size() >= 1 && fingerprint.macAddress.size() >= 1 &&
                current.macAddress.get(0).equals(fingerprint.macAddress.get(0))) {
            if (current.macAddress.size() == 1 && percent < 1) return false;
            if (current.macAddress.size() == 2 && percent < 1/2) return false;
            if (current.macAddress.size() == 3 && percent < 1/3) return false;
            if (current.macAddress.size() == 4 && percent < 2/4) return false;
            if (current.macAddress.size() == 5 && percent < 3/5) return false;
            if (current.macAddress.size() > 5 && percent < 4/6) return false;
        } else {
            if (current.macAddress.size() == 0) return true;
            if (current.macAddress.size() == 1 && percent < 1) return false;
            if (current.macAddress.size() == 2 && percent < 0.5) return false;
            if (current.macAddress.size() == 3 && percent < 0.65) return false;
            if (current.macAddress.size() == 4 && percent < 0.75) return false;
            if (current.macAddress.size() >= 5 && percent < 0.8) return false;
        }
        return true;
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
        int freeRide = 0;
        for (Map.Entry<String, Map<String, String>> entry: data.entrySet()) {
            if (valid(entry.getValue())) {
                Fingerprint fingerprint = new Fingerprint();
                fingerprint.session = entry.getKey();
                fingerprint.osName = entry.getValue().get("os_name");
                fingerprint.userHome = entry.getValue().get("user_home");
                fingerprint.ram = entry.getValue().get("physical memory in kb");
                fingerprint.macAddress = new ArrayList<String>();
                for (Map.Entry<String, String> attribute : entry.getValue().entrySet()) {
                    if (attribute.getKey().startsWith("mac_address")) {
                        // put the primary mac first
                        if (attribute.getKey().equals("mac_address")) {
                            fingerprint.macAddress.add(0, attribute.getValue());
                        } else {
                            fingerprint.macAddress.add(attribute.getValue());
                        }
                    }
                }
                fingerprints.add(fingerprint);
            } else {
                freeRide++;
            }
        }
        System.out.println("!!!! free rides: " + freeRide);
        return fingerprints;
    }

    private static boolean valid(Map<String, String> value) {
        if (!value.containsKey("user_home")) return false;
        if (value.get("user_home") == null || value.get("user_home").length() == 0) return false;
        if (!value.containsKey("mac_address")) return false;
        if (value.get("mac_address") == null || value.get("mac_address").length() == 0) return false;
        return true;
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
