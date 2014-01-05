package graph.dijkstra;

import java.util.Scanner;

/**
 * Mice and Maze.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1112YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int t = 0; t < TC; t++) {
            int N = sc.nextInt();
            int E = sc.nextInt();
            int T = sc.nextInt();
            int M = sc.nextInt();
            N++;
            int[][] map = new int[105][105];
            for (int i = 0; i < 105; i++) {
                for (int j = 0; j < 105; j++) {
                    map[i][j] = 10000;
                }
            }
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                map[a][b] = c;
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][E] <= T || i == E) {
                    count++;
                }
            }
            System.out.println(count);
            if (t < TC - 1) {
                System.out.println();
            }
        }
    }
}
