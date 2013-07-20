package others;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10783YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int total = 0;
            for (int i = a; i <= b; i++) {
                if (i % 2 == 1) total += i;
            }
            System.out.println("Case " + t + ": " + total);
        }
    }

}
