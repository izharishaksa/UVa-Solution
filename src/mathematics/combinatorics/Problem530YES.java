package mathematics.combinatorics;

import java.util.*;

/**
 * Binomial Showdown.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem530YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            long ans = 1;
            int temp = n - m;
            if (m < temp) {
                m ^= temp;
                temp ^= m;
                m ^= temp;
            }
            int start = m + 1;
            int[] arr = new int[temp];
            for (int i = 0; i < temp; i++) {
                arr[i] = start + i;
            }
            long res = 1;
            for (int i = 2; i <= temp; i++) {
                int x = i;
                boolean bisa = false;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] % x == 0) {
                        arr[j] /= x;
                        bisa = true;
                        break;
                    }
                }
                if (!bisa) {
                    res *= x;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                ans *= arr[i];
            }
            System.out.println(ans / res);
        }
    }
}
