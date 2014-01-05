package graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Sending Email.
 *
 * @author izharishaksa
 */
public class Problem10986YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int start = Integer.parseInt(temp[2]);
            int end = Integer.parseInt(temp[3]);
            List<Edge>[] edges = new ArrayList[n];
            for (int i = 0; i < m; i++) {
                temp = br.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                int c = Integer.parseInt(temp[2]);
                if (edges[a] == null) {
                    edges[a] = new ArrayList<Edge>();
                }
                if (edges[b] == null) {
                    edges[b] = new ArrayList<Edge>();
                }
                edges[a].add(new Edge(b, c));
                edges[b].add(new Edge(a, c));
            }

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            pq.offer(new Node(start, 0));
            boolean ada = false;
            while (!pq.isEmpty()) {
                Node c = pq.poll();
                if (c.pos == end) {
                    ada = true;
                    System.out.println("Case #" + t + ": " + c.cost);
                    break;
                }
                if (edges[c.pos] != null) {
                    for (Edge e : edges[c.pos]) {
                        if (dist[e.cur] > c.cost + e.w) {
                            dist[e.cur] = c.cost + e.w;
                            pq.offer(new Node(e.cur, dist[e.cur]));
                        }
                    }
                }
            }

            if (!ada) {
                System.out.println("Case #" + t + ": unreachable");
            }
        }
    }
}
class Node implements Comparable<Node> {

    int pos, cost;

    public Node(int pos, int cost) {
        this.pos = pos;
        this.cost = cost;
    }

    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

class Edge {

    int cur, w;

    public Edge(int a, int w) {
        this.cur = a;
        this.w = w;
    }
}