package problemsolvingparadigms.dynamicprogramming;

import java.util.Scanner;

/**
 * The Jackpot.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10684YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int max = 0, maxN = 0;
            for (int i = 0; i < n; i++) {
                maxN = Math.max(0, maxN + sc.nextInt());
                max = Math.max(max, maxN);
            }
            if (max > 0) {
                System.out.println("The maximum winning streak is " + max + ".");
            } else {
                System.out.println("Losing streak.");
            }
        }
    }
}
