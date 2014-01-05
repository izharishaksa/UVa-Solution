package mathematics.biginteger;

import java.util.*;

/**
 * Kibbles "n" Bits "n" Bits "n" Bits "n" Bits.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem446YES {

    static String add(String s) {
        int n = s.length();
        for (int i = 0; i < 13 - n; i++) {
            s = "0" + s;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            if (b.compareTo("+") == 0) {
                int aa = Integer.parseInt(a, 16);
                int cc = Integer.parseInt(c, 16);
                int dd = aa + cc;
                System.out.println(add(Integer.toBinaryString(aa)) + " + " + add(Integer.toBinaryString(cc)) + " = " + dd);
            } else {
                int aa = Integer.parseInt(a, 16);
                int cc = Integer.parseInt(c, 16);
                int dd = aa - cc;
                System.out.println(add(Integer.toBinaryString(aa)) + " - " + add(Integer.toBinaryString(cc)) + " = " + dd);
            }
        }
    }
}
