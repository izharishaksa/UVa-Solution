package mathematics.biginteger;

import java.util.*;
import java.math.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem355YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String c = sc.next();
            try {
                BigInteger xx = new BigInteger(new BigInteger(c + "", a).toString(10));
                String d = xx.toString(b).toUpperCase();
                System.out.println(c + " base " + a + " = " + d + " base " + b);
            } catch (Exception e) {
                System.out.println(c + " is an illegal base " + a + " number");
            }
        }
    }

}
