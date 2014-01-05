package graph.mst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Heavy Cargo.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem544YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ind = 1;
        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println("Scenario #" + (ind++));
            HashMap<String, Integer> city = new HashMap<String, Integer>();
            String a = "", b = "";
            int load = 0, awal = 0;
            int[][] map = new int[n][n];
            boolean[][] dis = new boolean[n][n];
            boolean[][] sudah = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                a = sc.next();
                b = sc.next();
                load = sc.nextInt();
                if (!city.containsKey(a)) {
                    city.put(a, awal++);
                }
                if (!city.containsKey(b)) {
                    city.put(b, awal++);
                }
                int x = city.get(a), y = city.get(b);
                if (load > map[x][y]) {
                    map[x][y] = load;
                    map[y][x] = load;
                }
            }
            int start = city.get(sc.next()), end = city.get(sc.next());
            LinkedList<Integer> visited = new LinkedList<Integer>();
            LinkedList<Integer> maxLoad = new LinkedList<Integer>();
            int min = 0;
            visited.add(start);
            maxLoad.add(11000);
            while (!visited.isEmpty()) {
                int cur = visited.poll();
                int maxNow = maxLoad.poll();
                if (cur == end) {
                    if (maxNow >= min) {
                        min = maxNow;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (cur != i && map[cur][i] != 0 && map[cur][i] >= min && !sudah[cur][i]) {
                        sudah[cur][i] = true;
                        visited.add(i);
                        int z = maxNow;
                        z = z > map[cur][i] ? map[cur][i] : z;
                        maxLoad.add(z);
                    }
                }
            }
            System.out.println(min + " tons\n");
        }
    }
}
