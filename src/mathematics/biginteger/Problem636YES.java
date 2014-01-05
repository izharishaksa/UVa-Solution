package mathematics.biginteger;

import java.util.Scanner;

/**
 * Squares (III).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem636YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int base = 2;
            String s = n + "";
            for (int i = 9; i >= 1; i--) {
                if (s.indexOf((char) i + '0') >= 0) {
                    base = i + 1;
                    break;
                }
            }
            boolean ada = false;
            for (; base < 100 && !ada; base++) {
                long x = 0;
                for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
                    x += (long) ((s.charAt(i) - '0') * Math.pow(base, j));
                }
                for (long i = 1; i * i <= x; i++) {
                    if (i * i == x) {
                        ada = true;
                        break;
                    }
                }
            }
            System.out.println(--base);
        }
    }
}
