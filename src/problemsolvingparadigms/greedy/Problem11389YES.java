package problemsolvingparadigms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The Bus Driver Problem.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11389YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int r = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] morning = new int[n];
            for (int i = 0; i < n; i++) {
                morning[i] = sc.nextInt();
            }
            int[] evening = new int[n];
            for (int i = 0; i < n; i++) {
                evening[i] = sc.nextInt();
            }
            Arrays.sort(morning);
            Arrays.sort(evening);
            int total = 0;
            for (int i = 0; i < n; i++) {
                int x = morning[i] + evening[n - i - 1];
                if (x > d) {
                    total += x - d;
                }
            }
            System.out.println(total * r);
        }
    }
}