package problemsolvingparadigms.dynamicprogramming;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem147 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n;
        while (sc.hasNext()) {
            n = Double.parseDouble(sc.next());
            n *= 100;
            if (n == 0) {
                break;
            }
            int[] arr = new int[]{5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
            int[] dp = new int[30001];
            Arrays.fill(dp, 0);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= n) {
                    dp[arr[i]]++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = arr[i]; j <= 30000; j += arr[i]) {
                    //System.out.println(j + " " + arr[i]);
                    dp[j]++;
                }
            }
            int z = (int) n;
            for (int i = 0; i <= z; i++) {
                System.out.println(i + " >> " + dp[i]);
            }
            System.out.println(dp[(int) n]);
        }
    }
}
