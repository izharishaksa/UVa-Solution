package mathematics.biginteger;

import java.util.*;
import java.math.*;

/**
 * Notice property:
 * if (a > b and a mod b = 0) then the result is: f(t, a, b) = t^a-b + t^a-b-b + t^a-b-b + ... + t^0
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10083YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.print("(" + t + "^" + a + "-1)/(" + t + "^" + b + "-1) ");
            if (t == 1) {
                System.out.println("is not an integer with less than 100 digits.");
            } else if (a == b) {
                System.out.println(1);
            } else if ((a < b) || (a % b != 0)) {
                System.out.println("is not an integer with less than 100 digits.");
            } else if (b <= 1000) {
                a -= b;
                BigInteger bi = new BigInteger(t + "").pow(b);
                BigInteger ret = BigInteger.ONE;
                BigInteger temp = BigInteger.ONE;
                boolean finish = true;
                for (int i = b; i <= a; i += b) {
                    temp = temp.multiply(bi);
                    ret = ret.add(temp);
                    if ((ret + "").length() > 99) {
                        finish = false;
                        break;
                    }
                }
                if ((ret + "").length() < 100 && finish) {
                    System.out.println(ret);
                } else {
                    System.out.println("is not an integer with less than 100 digits.");
                }
            } else {
                System.out.println("is not an integer with less than 100 digits.");
            }
        }
    }
}