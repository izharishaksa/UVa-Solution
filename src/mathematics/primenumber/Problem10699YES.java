package mathematics.primenumber;

import java.util.*;

/**
 * Count the factors.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10699YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean[] prime = new boolean[1000001];
        for (int i = 2; i < 1000000; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < 1000000; j += i) {
                    prime[j] = true;
                }
            }
        }
        while ((n = sc.nextInt()) != 0) {
            int ret = 0;
            if (!prime[n]) {
                System.out.println(n + " : " + 1);
                continue;
            }
            for (int i = 2; i <= n / 2; i++) {
                if (!prime[i] && n % i == 0) {
                    ret++;
                }
            }
            System.out.println(n + " : " + ret);
        }
    }
}
