package graph.dijkstra;


import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][M];
            long[][] dp = new long[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    try {
                        long a = dp[i - 1][j] + map[i][j];
                        if (dp[i][j] > a) {
                            dp[i][j] = a;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        long b = dp[i][j - 1] + map[i][j];
                        if (dp[i][j] > b) {
                            dp[i][j] = b;
                        }
                    } catch (Exception e) {
                    }
                }
            }
            System.out.println(dp[N - 1][M - 1]);
        }
    }
}
