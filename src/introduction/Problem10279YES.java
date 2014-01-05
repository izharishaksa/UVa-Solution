package introduction;

import java.util.Scanner;

/**
 * Mine Sweeper.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10279YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            char[][] map = new char[n][n];
            char[][] ret = new char[n][n];
            String s = sc.nextLine();
            int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            for (int i = 0; i < n; i++) {
                s = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < n; i++) {
                s = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    ret[i][j] = s.charAt(j);
                }
            }
            boolean failed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ret[i][j] == 'x') {
                        if (map[i][j] == '*') {
                            failed = true;
                            ret[i][j] = '*';
                        }
                        int tot = 0;
                        for (int k = 0; k < 8; k++) {
                            int a = i + dir[k][0], b = j + dir[k][1];
                            try {
                                if (map[a][b] == '*') {
                                    tot++;
                                }
                            } catch (Exception e) {
                            }
                        }
                        ret[i][j] = (char) ('0' + tot);
                    }
                }
            }
            if (failed) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == '*') {
                            ret[i][j] = '*';
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ret[i][j]);
                }
                System.out.println();
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
