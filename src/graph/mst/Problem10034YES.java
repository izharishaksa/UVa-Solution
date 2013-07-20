package graph.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10034YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            Point[] p = new Point[n];
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                String[] ss = sc.nextLine().split("[ ]");
                double a = Double.parseDouble(ss[0]);
                double b = Double.parseDouble(ss[1]);
                p[i] = new Point(a, b);
            }

            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Edge edge = new Edge(i, j, p[i].x, p[i].y, p[j].x, p[j].y);
                    pq.add(edge);
                }
            }

            boolean[] added = new boolean[n];
            double total = 0;
            try {
                Edge temp = pq.poll();
                added[temp.node1] = true;
                added[temp.node2] = true;
                total += temp.getLength();
            } catch (Exception e) {
            }

            boolean found = false;
            ArrayList<Edge> tempList = new ArrayList<Edge>();
            while (!pq.isEmpty() && !found) {
                found = true;
                for (int i = 0; i < n; i++) {
                    if (!added[i]) {
                        found = false;
                    }
                }
                if (!found) {
                    Edge temp = pq.poll();
                    if ((added[temp.node1] && !added[temp.node2]) || (!added[temp.node1] && added[temp.node2])) {
                        added[temp.node1] = true;
                        added[temp.node2] = true;
                        total += temp.getLength();
                        pq.addAll(tempList);
                        tempList.clear();
                    } else if (!added[temp.node1] && !added[temp.node2]) {
                        tempList.add(temp);
                    }
                }
            }

            System.out.printf("%.2f\n", total);
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
class Point {

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {

    double x1, x2, y1, y2;
    int node1, node2;

    public Edge(int node1, int node2, double x1, double y1, double x2, double y2) {
        this.node1 = node1;
        this.node2 = node2;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength() {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public int compareTo(Edge o) {
        if (getLength() < o.getLength()) {
            return -1;
        }
        return 1;
    }
}