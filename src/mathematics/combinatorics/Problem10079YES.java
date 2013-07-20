package mathematics.combinatorics;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10079YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while ((n = sc.nextInt()) >= 0) {
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res += i;
            }
            System.out.println(res);
        }
    }

}
