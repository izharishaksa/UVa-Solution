package mathematics.factorial;

import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10220YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger bi = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                bi = bi.multiply(new BigInteger(i + ""));
            }
            String s = bi.toString();
            int ret = 0;
            for (int i = 0; i < s.length(); i++) {
                ret += s.charAt(i) - '0';
            }
            System.out.println(ret);
        }
    }

}
