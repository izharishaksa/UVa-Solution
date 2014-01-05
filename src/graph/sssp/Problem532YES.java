package graph.sssp;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Dungeon Master.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem532YES {

    public static void main(String[] args) throws Exception {
        String s = "";
        Scanner sc = new Scanner(System.in);
        int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        while (sc.hasNext()) {
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            s = sc.nextLine();
            int sx = 0, sy = 0, sz = 0;
            int ex = 0, ey = 0, ez = 0;
            if (x == 0 && y == 0 && z == 0) {
                break;
            }
            char[][][] map = new char[x][y][z];
            int[][][] min = new int[x][y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    s = sc.nextLine();
                    for (int k = 0; k < z; k++) {
                        map[i][j][k] = s.charAt(k);
                        min[i][j][k] = 1000005;
                        if (s.charAt(k) == 'S') {
                            sx = i;
                            sy = j;
                            sz = k;
                        }
                        if (s.charAt(k) == 'E') {
                            ex = i;
                            ey = j;
                            ez = k;
                        }
                    }
                }
                s = sc.nextLine();
            }
            min[sx][sy][sz] = 0;

            LinkedList<Integer> curX = new LinkedList<Integer>();
            LinkedList<Integer> curY = new LinkedList<Integer>();
            LinkedList<Integer> curZ = new LinkedList<Integer>();
            curX.add(sx);
            curY.add(sy);
            curZ.add(sz);
            while (!curX.isEmpty()) {
                int a = curX.poll(), b = curY.poll(), c = curZ.poll();
                for (int i = 0; i < 6; i++) {
                    int p = a + dir[i][0], q = b + dir[i][1], r = c + dir[i][2];
                    if ((p < x) && (p >= 0) && (q < y) && (q >= 0) && (r < z) && (r >= 0)) {
                        if (map[p][q][r] != '#') {
                            if (min[a][b][c] + 1 < min[p][q][r]) {
                                min[p][q][r] = min[a][b][c] + 1;
                                curX.add(p);
                                curY.add(q);
                                curZ.add(r);
                            }
                        }
                    }
                }
            }
            if (min[ex][ey][ez] == 1000005) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + min[ex][ey][ez] + " minute(s).");
            }
        }
    }
}
