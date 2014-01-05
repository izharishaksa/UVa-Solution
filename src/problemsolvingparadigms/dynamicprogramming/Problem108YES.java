package problemsolvingparadigms.dynamicprogramming;

import java.util.Scanner;

/**
 * Maximum Sums.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem108YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = mat[i][j];
                } else if (i == 0) {
                    sum[i][j] = mat[i][j] + sum[i][j - 1];
                } else if (j == 0) {
                    sum[i][j] = mat[i][j] + sum[i - 1][j];
                } else {
                    sum[i][j] = mat[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int ii = i; ii < N; ii++) {
                for (int j = 0; j < N; j++) {
                    for (int jj = j; jj < N; jj++) {
                        int tempSum = 0;
                        if (i == 0 && j == 0) {
                            tempSum = sum[ii][jj];
                        } else if (i == 0) {
                            tempSum = sum[ii][jj] - sum[ii][j - 1];
                        } else if (j == 0) {
                            tempSum = sum[ii][jj] - sum[i - 1][jj];
                        } else {
                            tempSum = sum[ii][jj] - sum[ii][j - 1] - sum[i - 1][jj] + sum[i - 1][j - 1];
                        }
                        max = Math.max(max, tempSum);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
