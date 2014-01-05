package mathematics.factorial;

import java.util.*;

/**
 * Mischievous Children.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10338YES {

    static long fact(int n) {
        long ret = 1L;
        for (int i = 2; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            char[] c = s.toCharArray();
            Arrays.sort(c);
            int v = c.length;
            long ret = fact(v);
            int diff = 1;
            for (int i = 1; i < c.length; i++) {
                if (c[i] == c[i - 1]) {
                    diff++;
                } else {
                    ret /= fact(diff);
                    diff = 1;
                }
            }
            ret /= fact(diff);
            System.out.println("Data set " + t + ": " + ret);
        }
    }
}
