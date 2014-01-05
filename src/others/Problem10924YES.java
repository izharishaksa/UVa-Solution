package others;

import java.util.*;

/**
 * Prime Words.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10924YES {

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[10000];
        Arrays.fill(prime, false);
        prime[1] = true;
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                prime[i] = true;
            }
        }
        String s = "";
        while (sc.hasNext()) {
            s = sc.next();
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    total += (c - 'a') + 1;
                } else {
                    total += (c - 'A') + 27;
                }
            }
            if (prime[total]) {
                System.out.println("It is a prime word.");
            } else {
                System.out.println("It is not a prime word.");
            }
        }
    }
}
