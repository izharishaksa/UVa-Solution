package mathematics.factorial;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10323YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ret = new String[]{"40320", "362880", "3628800", "39916800", "479001600", "6227020800"};
        while (sc.hasNext()) {
            int x = sc.nextInt();

            if (x <= -1) {
                if ((x * -1) % 2 == 1) {
                    System.out.println("Overflow!");
                } else {
                    System.out.println("Underflow!");
                }
                continue;
            }
            if (x < 8) {
                System.out.println("Underflow!");
            } else if (x > 13) {
                System.out.println("Overflow!");
            } else {
                System.out.println(ret[x - 8]);
            }
        }
    }

}