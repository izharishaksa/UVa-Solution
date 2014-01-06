package mathematics.biginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Multiple of 17.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11879YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("0")) {
                break;
            }
            if (s.length() == 1) {
                System.out.println(0);
            }
            BigInteger bi = new BigInteger(s.substring(0, s.length() - 1));
            BigInteger b = new BigInteger(((s.charAt(s.length() - 1) - '0') * 5) + "");
            if (bi.subtract(b).mod(new BigInteger("17")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
