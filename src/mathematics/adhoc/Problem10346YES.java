package mathematics.adhoc;

import java.util.*;

/**
 * Peter's Smokes.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10346YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = a;
            while (a >= b) {
                res += (a / b);
                a = (a / b) + (a % b);
            }
            System.out.println(res);
        }
    }

}
