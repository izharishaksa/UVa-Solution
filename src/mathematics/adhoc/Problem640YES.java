package mathematics.adhoc;

import java.util.Scanner;

/**
 * Self Numbers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem640YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean[] self = new boolean[1000001];
        for (int i = 1; i <= 1000000; i++) {
            int tot = 0, x = i;
            while (x / 10 > 0) {
                tot += x % 10;
                x /= 10;
            }
            String ret = "";
            if (tot == 0 && x == i) {
                ret = i + "";
                for (int j = 0; j < ret.length(); j++) {
                    tot += ret.charAt(j) - '0';
                }
            } else {
                tot += x;
            }
            tot += i;
            if (tot <= 1000000) {
                self[tot] = true;
            }
        }
        for (int i = 1; i <= 1000000; i++) {
            if (!self[i]) {
                System.out.println(i);
            }
        }
    }
}
