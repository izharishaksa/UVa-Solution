package mathematics.biginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Basic Remains.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10551YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int b = sc.nextInt();
            if (b == 0) {
                break;
            }
            String p = sc.next();
            String m = sc.next();
            BigInteger pp = new BigInteger(p, b);
            BigInteger mm = new BigInteger(m, b);
            System.out.println(pp.mod(mm).toString(b));
        }
    }
}
