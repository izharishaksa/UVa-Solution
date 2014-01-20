package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Friends.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10608YES {

    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = nextInt();
        while (T-- > 0) {
            int N = nextInt();
            int M = nextInt();
            DisjointSet ds = new DisjointSet(N);
            for (int i = 1; i <= N; i++) {
                ds.makeSet(i);
            }
            for (int i = 0; i < M; i++) {
                int a = nextInt();
                int b = nextInt();
                ds.union(a, b);
            }
            int max = 0;
            for (int i = 1; i <= N; i++) {
                max = Math.max(max, ds.total[i]);
            }
            pw.println(max);
            pw.flush();
        }
        pw.close();
    }

    static class DisjointSet {

        int largestFriend = 0;
        int[] parent, rank, total;

        public DisjointSet(int N) {
            parent = new int[N + 1];
            rank = new int[N + 1];
            total = new int[N + 1];
        }

        void makeSet(int x) {
            parent[x] = x;
            rank[x] = 0;
            total[x] = 1;
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                total[px] += total[py];
                total[py] = total[px];
            }
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
            if (rank[px] == rank[py]) {
                rank[px]++;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    static int nextInt() throws Exception {
        int ret = 0, x;
        while (true) {
            x = br.read();
            if (x == 10 || x == 32 || x == -1) {
                return ret;
            }
            ret *= 10;
            ret += x - 48;
        }
    }
}
