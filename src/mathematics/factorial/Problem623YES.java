package mathematics.factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 500!
 *
 * @author Izhari Ishak Aksa
 */
public class Problem623YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger ret = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                ret = ret.multiply(new BigInteger(i + ""));
            }
            System.out.println(n + "!");
            System.out.println(ret);
        }
    }
}
