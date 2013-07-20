package mathematics.biginteger;

import java.util.*;
import java.math.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem748YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigDecimal bi = sc.nextBigDecimal();
            BigDecimal temp = bi;
            int n = sc.nextInt();
            bi = bi.pow(n);
            String s = bi.stripTrailingZeros().toPlainString();
            if (s.charAt(0) == '0') s = s.substring(1);
            System.out.println(s);
        }
    }
}
