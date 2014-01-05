package mathematics.biginteger;

import java.util.*;
import java.math.*;

/**
 * Product.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10106YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.multiply(b));
        }
    }

}
