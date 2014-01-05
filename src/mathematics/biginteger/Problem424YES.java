package mathematics.biginteger;

import java.math.BigInteger;
import java.util.*;

/**
 * Integer Inquiry.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem424YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger res = BigInteger.ZERO;
        while (sc.hasNext()) {
            res = res.add(sc.nextBigInteger());
        }
        System.out.println(res);
    }
}
