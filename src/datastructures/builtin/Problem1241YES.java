package datastructures.builtin;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1241YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[(int) Math.pow(2, n)];
            for (int i = 0; i < m; i++) {
                arr[sc.nextInt() - 1] = 1;
            }
            int ret = 0;
            while (true) {
                int[] res = new int[arr.length / 2];
                for (int i = 0, j = 0; i < arr.length; i += 2, j++) {
                    if (arr[i] == 1 && arr[i + 1] == 1) {
                        res[j] = 1;
                    } else if (arr[i] == 1 || arr[i + 1] == 1) {
                        ret++;
                    }
                }
                arr = new int[res.length];
                System.arraycopy(res, 0, arr, 0, res.length);
                if (arr.length == 1) {
                    break;
                }
            }
            System.out.println(ret);
        }
    }
}
