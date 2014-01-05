package mathematics.biginteger;

import java.util.*;
import java.math.*;

/**
 * Very Easy!!!
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10523YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            BigInteger c = BigInteger.ZERO;
            for (int i = 1; i <= a; i++) {
                c = c.add(new BigInteger(i + "").multiply(new BigInteger(b + "").pow(i)));
            }
            System.out.println(c);
        }
    }

}
