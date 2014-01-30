package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Waking up brain.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10507YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line.trim()) - 3;
            int M = Integer.parseInt(br.readLine().trim());
            String wakeUp = br.readLine();
            DisjointSet ds = new DisjointSet();
            for (int i = 0; i < 26; i++) {
                ds.makeSet(i);
            }
            boolean[][] con = new boolean[26][26];
            for (int i = 0; i < M; i++) {
                line = br.readLine();
                int x = line.charAt(0) - 'A';
                int y = line.charAt(1) - 'A';
                con[x][y] = true;
                con[y][x] = true;
            }
            ds.union(wakeUp.charAt(0) - 'A', wakeUp.charAt(1) - 'A');
            ds.union(wakeUp.charAt(1) - 'A', wakeUp.charAt(2) - 'A');
            int parent = ds.find(wakeUp.charAt(0) - 'A');

            int years = 0;
            boolean changed = true;
            while (changed) {
                changed = false;
                boolean[] wakeIt = new boolean[26];
                for (int i = 0; i < 26; i++) {
                    if (ds.find(i) == parent) {
                        continue;
                    }
                    int count = 0;
                    for (int j = 0; j < 26; j++) {
                        if (con[i][j] && ds.find(j) == parent) {
                            count++;
                        }
                    }
                    if (count > 2) {
                        changed = true;
                        wakeIt[i] = true;
                        N--;
                    }
                }
                for (int i = 0; i < 26; i++) {
                    if (wakeIt[i]) {
                        ds.union(i, wakeUp.charAt(0) - 'A');
                    }
                }
                if (changed) {
                    years++;
                }
            }

            if (N <= 0) {
                pw.println("WAKE UP IN, " + years + ", YEARS");
            } else {
                pw.println("THIS BRAIN NEVER WAKES UP");
            }
            pw.flush();
            br.readLine();
        }
        pw.close();
    }

    static class DisjointSet {

        int[] parent, rank;

        public DisjointSet() {
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
            parent[x] = x;
            rank[x] = 0;
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
