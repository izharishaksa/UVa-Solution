package graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/**
 * Number Maze.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem929YES {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] map = new int[N][M];
            int[][] dp = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = map[0][0];
            int[] dx = new int[]{-1, 0, 0, 1};
            int[] dy = new int[]{0, -1, 1, 0};
            PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
            pq.offer(new Cell(0, 0, dp[0][0]));
            while (!pq.isEmpty()) {
                Cell c = pq.poll();
                if (c.row == N - 1 && c.col == M - 1) {
                    System.out.println(dp[N - 1][M - 1]);
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int a = c.row + dx[i];
                    int b = c.col + dy[i];
                    if (a >= 0 && a < N && b >= 0 && b < M && map[a][b] + dp[c.row][c.col] < dp[a][b]) {
                        dp[a][b] = map[a][b] + dp[c.row][c.col];
                        pq.add(new Cell(a, b, dp[a][b]));
                    }
                }
            }
        }
    }
}
class Cell implements Comparable<Cell> {
    
    int cost, row, col;
    
    public Cell(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    
    public int compareTo(Cell o) {
        return cost - o.cost;
    }
}