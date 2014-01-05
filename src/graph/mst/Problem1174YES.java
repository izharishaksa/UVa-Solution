package graph.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * IP-TV.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1174YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            PriorityQueue<Route> pq = new PriorityQueue<Route>();
            HashMap<String, Boolean> city = new HashMap<String, Boolean>();
            for (int i = 0; i < M; i++) {
                String a = sc.next();
                String b = sc.next();
                int c = sc.nextInt();
                pq.add(new Route(a, b, c));
                city.put(a, false);
                city.put(b, false);
            }

            int total = 0;
            try {
                Route temp = pq.poll();
                city.put(temp.city1, true);
                city.put(temp.city2, true);
                total += temp.dis;
                N -= 2;
            } catch (Exception e) {
            }

            ArrayList<Route> tempList = new ArrayList<Route>();
            while (!pq.isEmpty() && N > 0) {
                Route temp = pq.poll();
                if ((city.get(temp.city1) && !city.get(temp.city2)) || (!city.get(temp.city1) && city.get(temp.city2))) {
                    city.put(temp.city1, true);
                    city.put(temp.city2, true);
                    total += temp.dis;
                    pq.addAll(tempList);
                    tempList.clear();
                    N--;
                } else if (!city.get(temp.city1) && !city.get(temp.city2)) {
                    tempList.add(temp);
                }
            }
            System.out.println(total);
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
class Route implements Comparable<Route> {

    String city1, city2;
    int dis;

    public Route(String city1, String city2, int dis) {
        this.city1 = city1;
        this.city2 = city2;
        this.dis = dis;
    }

    public int compareTo(Route o) {
        return dis - o.dis;
    }
}