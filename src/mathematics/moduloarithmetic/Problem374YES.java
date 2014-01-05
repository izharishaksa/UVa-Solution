package mathematics.moduloarithmetic;

import java.util.*;
import java.math.*;

/**
 * Big Mod.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem374YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(new BigInteger(a + "").modPow(new BigInteger(b + ""), new BigInteger(c + "")));
        }
    }
}
