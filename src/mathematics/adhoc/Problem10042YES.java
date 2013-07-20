package mathematics.adhoc;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10042YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = 0, m = 0, a = 0, b = 0, x = 2;
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            n = sc.nextLong();
            if (n == 0) {
                break;
            }
            for (long i = n + 1;; i++) {
                m = i;
                a = 0;
                b = 0;
                while (m / 10 > 0) {
                    a += m % 10;
                    m /= 10;
                }
                a += m;
                x = 2;
                m = i;
                String ret = "";
                while (x * x <= m) {
                    if (m % x == 0) {
                        ret += x;
                        m /= x;
                    } else {
                        x++;
                    }
                }
                if (ret.compareTo("") == 0) {
                    continue;
                }
                ret += m;
                for (int j = 0; j < ret.length(); j++) {
                    b += ret.charAt(j) - '0';
                }
                if (a == b) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
