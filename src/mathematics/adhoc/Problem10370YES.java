package mathematics.adhoc;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10370YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            double total = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr[i] = x;
                total += x;
            }
            total /= n;
            double res = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > total) res++;
            }
            System.out.printf("%.3f", (res * 100.0 / n));
            System.out.println("%");
        }
    }

}
