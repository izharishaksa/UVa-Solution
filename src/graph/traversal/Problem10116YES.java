package graph.traversal;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10116YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNext()) {
            int row = sc.nextInt(), col = sc.nextInt();
            int y = sc.nextInt(), x = 0;
            if (row == 0 && col == 0 && y == 0) {
                break;
            }
            s = sc.nextLine();
            char[][] map = new char[row][col];
            boolean[][] visited = new boolean[row][col];
            int[][] step = new int[row][col];
            for (int i = 0; i < row; i++) {
                s = sc.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            y--; //base 0-index
            int cur = 1;
            visited[x][y] = true;
            step[x][y] = 1;
            while (true) {
                if (map[x][y] == 'W') {
                    y--;
                } else if (map[x][y] == 'E') {
                    y++;
                } else if (map[x][y] == 'N') {
                    x--;
                } else {
                    x++;
                }
                if (x < 0 || x >= row || y < 0 || y >= col) {
                    System.out.println(cur + " step(s) to exit");
                    break;
                }
                if (visited[x][y]) {
                    System.out.println((step[x][y] - 1) + " step(s) before a loop of " + (cur - step[x][y] + 1) + " step(s)");
                    break;
                }
                cur++;
                visited[x][y] = true;
                step[x][y] = cur;
            }
        }
    }
}
