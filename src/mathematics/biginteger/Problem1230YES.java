package mathematics.biginteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1230YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(new BigInteger(sc.nextInt() + "")
                    .modPow(new BigInteger(sc.nextInt() + ""), new BigInteger(sc.nextInt() + "")));
        }
    }
    
}
