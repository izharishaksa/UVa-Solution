package problemsolvingparadigms.dynamicprogramming;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10755 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            long[][][] arr = new long[a][b][c];
            long max = 0L;
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    for (int k = 0; k < c; k++) {
                        arr[i][j][k] = sc.nextLong();
                        max += arr[i][j][k];
                    }
                }
            }
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    for (int k = 0; k < c; k++) {
                        for (int ii = a - 1; ii >= i; ii--) {
                            for (int jj = b - 1; jj >= j; jj--) {
                                long cur = 0L;
                                for (int kk = c - 1; kk >= k; kk--) {
                                    cur += arr[ii][jj][kk];
                                    max = Math.max(max, cur);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
