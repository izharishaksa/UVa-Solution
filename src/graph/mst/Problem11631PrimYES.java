package graph.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dark Roads.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11631PrimYES {

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

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            int m = nextInt();
            int n = nextInt();
            if (n + m == 0) {
                break;
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
            Edge e = edges.poll();
            int result = e.length;
            boolean[] added = new boolean[n];
            added[e.a] = true;
            added[e.b] = true;
            m -= 2;
            List<Edge> buffer = new ArrayList<Edge>();
            while (!edges.isEmpty() && m > 0) {
                e = edges.poll();
                if ((!added[e.a] && added[e.b]) || (added[e.a] && !added[e.b])) {
                    result += e.length;
                    added[e.a] = true;
                    added[e.b] = true;
                    edges.addAll(buffer);
                    buffer.clear();
                    m--;
                } else if (!added[e.a] && !added[e.b]) {
                    buffer.add(e);
                }
            }
            pw.println(cur - result);
            pw.flush();
        }
        pw.close();
    }
}
