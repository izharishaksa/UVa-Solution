package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Waking up brain.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10507 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line.trim());
            int M = Integer.parseInt(br.readLine().trim());
            String wakeUp = br.readLine();
            DisjointSets ds = new DisjointSets();
            boolean[] active = new boolean[26];
            ds.makeSet(wakeUp.charAt(0) - 'A');
            active[wakeUp.charAt(0) - 'A'] = true;
            ds.makeSet(wakeUp.charAt(1) - 'A');
            active[wakeUp.charAt(1) - 'A'] = true;
            ds.makeSet(wakeUp.charAt(2) - 'A');
            active[wakeUp.charAt(2) - 'A'] = true;
            ds.union(wakeUp.charAt(0) - 'A', wakeUp.charAt(1) - 'A');
            ds.union(wakeUp.charAt(2) - 'A', wakeUp.charAt(1) - 'A');
            boolean[][] con = new boolean[26][26];
            for (int i = 0; i < N; i++) {
                ds.makeSet(i);
            }
            for (int i = 0; i < M; i++) {
                line = br.readLine();
                int x = line.charAt(0) - 'A';
                int y = line.charAt(1) - 'A';
                con[x][y] = true;
                con[y][x] = true;
                ds.makeSet(x);
                ds.makeSet(y);
            }
            int years = 0;
            boolean changed = true;
            while (changed) {
                changed = false;
                for (int i = 0; i < 26; i++) {
                    if (ds.parent[i] == -1) {
                        continue;
                    }
                    boolean[] newActive = new boolean[26];
                    for (int j = 0; j < 26; j++) {
                        if (active[j] && con[i][j] && ds.parent[j] != -1 && ds.isDisjoint(i, j)) {
                            ds.union(i, j);
                            newActive[i] = true;
                            changed = true;
                            years++;
                            System.err.println(((char) ('A' + i)) + " " + ((char) ('A' + j)));
                        }
                    }
                    if (changed) {
                        for (int j = 0; j < 26; j++) {
                            if (newActive[j]) {
                                active[j] = true;
                            }
                        }
                    }
                }
                System.err.println("-----");
            }

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            if (M > 0) {
                for (int i = 0; i < 26; i++) {
                    if (ds.parent[i] != -1) {
                        map.put(ds.parent[i], 1);
                    }
                }
            }
            if (map.size() == 1 || N < 4) {
                pw.println("WAKE UP IN, " + years + ", YEARS");
            } else {
                pw.println("THIS BRAIN NEVER WAKES UP");
            }
            pw.flush();
            //br.readLine();
        }
        pw.close();
    }

    static class DisjointSets {

        int[] parent, rank;

        public DisjointSets() {
            parent = new int[26];
            Arrays.fill(parent, -1);
            rank = new int[26];
        }

        boolean isDisjoint(int x, int y) {
            if (find(x) != find(y)) {
                return true;
            }
            return false;
        }

        void makeSet(int x) {
            if (parent[x] == -1) {
                parent[x] = x;
                rank[x] = 0;
            }
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                } else {
                    parent[px] = py;
                }
                if (rank[px] == rank[py]) {
                    rank[py]++;
                }
                return true;
            }
            return false;
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
