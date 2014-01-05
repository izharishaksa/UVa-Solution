package mathematics.biginteger;

import java.util.*;
import java.math.*;

/**
 * What Base Is This?
 *
 * @author Izhari Ishak Aksa
 */
public class Problem343YES {

    static String conv(String a) {
        String ret = "";
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            if (x >= 'A' && x <= 'Z') {
                ret += (x + "").toLowerCase();
            } else if (x >= 'a' && x <= 'z') {
                ret += (x + "").toUpperCase();
            } else {
                ret += x;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            String c = conv(a);
            String d = conv(b);
            int kiri = -1;
            int kanan = -1;
            boolean bisa = false;
            for (int i = 2; i <= 36; i++) {
                BigInteger aa = BigInteger.ZERO;
                try {
                    aa = new BigInteger(c, i);
                } catch (Exception e) {
                    continue;
                }
                for (int j = 2; j <= 36; j++) {
                    BigInteger bb = BigInteger.ZERO;
                    try {
                        bb = new BigInteger(d, j);
                    } catch (Exception e) {
                        continue;
                    }
                    if (aa.compareTo(bb) == 0) {
                        kiri = i;
                        kanan = j;
                        bisa = true;
                        break;
                    }
                }
                if (bisa) {
                    break;
                }
            }
            if (bisa) {
                System.out.println(a + " (base " + kiri + ") = " + b + " (base " + kanan + ")");
            } else {
                System.out.println(a + " is not equal to " + b + " in any base 2..36");
            }
        }
    }
}
