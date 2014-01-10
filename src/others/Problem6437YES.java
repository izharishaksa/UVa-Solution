package others;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Power Plant. (ICPC2013 Jakarta).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem6437YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int t = 1; t <= TC; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            boolean[] added = new boolean[N];
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt() - 1;
                added[x] = true;
            }
            int cost = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int c = sc.nextInt();
                pq.offer(new Edge(a, b, c));
            }
            List<Edge> tempList = new ArrayList<Edge>();
            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                if ((added[e.a] && !added[e.b]) || (!added[e.a] && added[e.b])) {
                    added[e.a] = true;
                    added[e.b] = true;
                    cost += e.cost;
                    pq.addAll(tempList);
                    tempList.clear();
                } else {
                    tempList.add(e);
                }
            }
            System.out.println("Case #" + t + ": " + cost);
        }
    }

    static class Edge implements Comparable<Edge> {

        int a, b, cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}
