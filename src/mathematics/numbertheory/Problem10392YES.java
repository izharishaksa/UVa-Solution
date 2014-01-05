package mathematics.numbertheory;

import java.util.Scanner;

/**
 * Factoring Large Numbers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10392YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            if (n == -1) {
                break;
            }
            long p = n / 2 + 1;
            long x = 2;
            long total = 1;
            long m = n;
            while (x * x <= n) {
                if (n % x == 0) {
                    n /= x;
                    System.out.println("    " + x);
                    total *= x;
                } else {
                    x++;
                }
            }
            if (n != 1) {
                System.out.println("    " + n);
            }
            System.out.println();
        }
    }
}
