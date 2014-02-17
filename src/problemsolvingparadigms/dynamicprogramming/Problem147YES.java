package problemsolvingparadigms.dynamicprogramming;

import java.util.*;

/**
 * Dollars.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem147YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{0, 1, 2, 4, 10, 20, 40, 100, 200, 400, 1000, 2000};
        long[][] res = new long[12][6001];
        for (int i = 0; i < 12; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < 6001; i++) {
            res[1][i] = 1;
        }

        for (int i = 2; i < 12; i++) {
            for (int j = 1; j < 6001; j++) {
                if (j >= arr[i]) {
                    res[i][j] = res[i - 1][j] + res[i][j - arr[i]];
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }
        int n;
        while (sc.hasNext()) {
            double real = Double.parseDouble(sc.nextLine());
            n = (int) (real * 20);
            if (n == 0) {
                break;
            }
            System.out.printf("%6.2f%17d\n", real, res[11][n]);
        }
    }
}
