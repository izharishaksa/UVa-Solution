package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Network Connections.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem793YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int TC = Integer.parseInt(br.readLine());
        br.readLine();
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            DisjoinSets ds = new DisjoinSets(N);
            for (int i = 1; i <= N; i++) {
                ds.makeSet(i);
            }
            int success = 0, failed = 0;
            String s;
            while ((s = br.readLine()) != null) {
                if (s.equals("")) {
                    break;
                }
                String[] temp = s.split(" ");
                int x = Integer.parseInt(temp[1]);
                int y = Integer.parseInt(temp[2]);
                if (temp[0].equals("c")) {
                    ds.union(x, y);
                } else {
                    if (ds.find(x) == ds.find(y)) {
                        success++;
                    } else {
                        failed++;
                    }
                }
            }
            pw.println(success + "," + failed);
            if (TC > 0) {
                pw.println();
            }
            pw.flush();
        }
        pw.close();
    }

    static class DisjoinSets {

        int[] parent, rank;

        public DisjoinSets(int N) {
            this.parent = new int[N + 1];
            this.rank = new int[N + 1];
        }

        void makeSet(int x) {
            parent[x] = x;
            rank[x] = 0;
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
            if (rank[px] == rank[py]) {
                rank[py]++;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
