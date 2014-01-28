package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Ubiquitous Religion.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10583YES {

    static BufferedReader br;

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    static int readInt() throws Exception {
        int c = br.read();
        while (isWhitespace(c)) {
            c = br.read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = br.read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = br.read();
        } while (!isWhitespace(c));
        return res * sgn;
    }

    static class DisjointSet {

        int[] parent, rank, total;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            total = new int[n];
        }

        public void makeSet(int x) {
            parent[x] = x;
            total[x] = 1;
            rank[x] = 1;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                    total[px] += total[py];
                    total[py] = 0;
                } else {
                    parent[px] = py;
                    total[py] += total[px];
                    total[px] = 0;
                }
                if (rank[px] == rank[py]) {
                    rank[px]++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int cases = 1;
        while (true) {
            int n = readInt();
            int m = readInt();
            if (n + m == 0) {
                break;
            }
            pw.print("Case " + cases + ": ");
            DisjointSet ds = new DisjointSet(n);
            for (int i = 0; i < n; i++) {
                ds.makeSet(i);
            }
            for (int i = 0; i < m; i++) {
                int x = readInt() - 1;
                int y = readInt() - 1;
                ds.union(x, y);
            }
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (ds.total[i] > 0) {
                    total++;
                }
            }
            pw.println(total);
            pw.flush();
            cases++;
        }
        pw.close();
    }
}
