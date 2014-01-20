package graph.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 * Dark Roads.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11631YES {

    static BufferedReader br;

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

    static class Edge implements Comparable<Edge> {

        int a, b, length;

        public Edge(int a, int b, int length) {
            this.a = a;
            this.b = b;
            this.length = length;
        }

        public int compareTo(Edge o) {
            return length - o.length;
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

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
            }
            if (rank[pa] == rank[pb]) {
                rank[pa]++;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean isDisjoint(int a, int b) {
            if (find(a) != find(b)) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            int m = nextInt();
            int n = nextInt();
            if (n + m == 0) {
                break;
            }
            DisjointSet ds = new DisjointSet(n);
            for (int i = 0; i < n; i++) {
                ds.makeSet(i);
            }
            PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
            int cur = 0;
            for (int i = 0; i < n; i++) {
                int a = nextInt();
                int b = nextInt();
                int length = nextInt();
                edges.add(new Edge(a, b, length));
                cur += length;
            }
            int result = 0;
            while (!edges.isEmpty()) {
                Edge e = edges.poll();
                if (ds.isDisjoint(e.a, e.b)) {
                    ds.union(e.a, e.b);
                    result += e.length;
                }
            }
            pw.println(cur - result);
            pw.flush();
        }
        pw.close();
    }
}
