package mathematics.adhoc;

import java.util.Scanner;

/**
 * Steps.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem846YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int diff = b - a;
            int sq = (int) Math.sqrt(diff);
            int result;
            if (diff == 0) {
                result = 0;
            } else if (sq * sq == diff) {
                result = sq * 2 - 1;
            } else if (sq * sq + sq < diff) {
                result = sq * 2 + 1;
            } else {
                result = sq * 2;
            }
            System.out.println(result);
        }
    }
}