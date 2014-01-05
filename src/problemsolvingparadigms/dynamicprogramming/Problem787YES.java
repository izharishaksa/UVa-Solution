package problemsolvingparadigms.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Maximum Sub-sequence Product.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem787YES {

    static BigInteger[] input = new BigInteger[105];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int top = 0;
        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("-999999")) {
                BigInteger max = new BigInteger("-99999");
                for (int lo = 0; lo < top; lo++) {
                    for (int hi = lo; hi < top; hi++) {
                        BigInteger prod = new BigInteger("1");
                        for (int i = lo; i <= hi; i++) {
                            prod = prod.multiply(input[i]);
                        }
                        if (prod.compareTo(max) > 0) {
                            max = prod;
                        }
                    }
                }
                System.out.println(max);
                top = 0;
            } else {
                input[top++] = new BigInteger(s);
            }
        }
    }
}
