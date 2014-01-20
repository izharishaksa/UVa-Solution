package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * The Suspects.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1197YES {

    static BufferedReader br;

    static int nextInt() throws Exception {
        int ret = 0, x;
        while (true) {
            x = br.read();
            if (x == 10 || x == 32 || x == -1) {
                return ret;
            }
            ret *= 10;
            ret += x - '0';
        }
    }

    static class DisjointSet {

        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
        }

        void makeSet(int x) {
            parent[x] = x;
            rank[x] = 0;
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (rank[px] > rank[px]) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
            if (rank[px] == rank[py]) {
                rank[px]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            int n = nextInt();
            int m = nextInt();
            if (n + m == 0) {
                break;
            }
            DisjointSet ds = new DisjointSet(n);
            for (int i = 0; i < n; i++) {
                ds.makeSet(i);
            }
            ds.rank[0] = n + 1;
            for (int i = 0; i < m; i++) {
                int p = nextInt();
                int[] arr = new int[p];
                for (int j = 0; j < p; j++) {
                    arr[j] = nextInt();
                }
                for (int j = 1; j < p; j++) {
                    ds.union(arr[j], arr[j - 1]);
                }
            }
            int result = 1;
            int suspect = ds.find(0);
            for (int i = 1; i < n; i++) {
                if (ds.find(i) == suspect) {
                    result++;
                }
            }
            pw.println(result);
            pw.flush();
        }
        pw.close();
    }
}
