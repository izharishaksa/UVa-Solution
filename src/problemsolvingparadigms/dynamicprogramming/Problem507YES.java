package problemsolvingparadigms.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Jill Rides Again.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem507YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(br.readLine().trim());
            }
            int curMax = 0, max = Integer.MIN_VALUE, a0 = 1, maxa0 = 1, maxan = 1;
            for (int i = 0; i < n - 1; ++i) {
                curMax += arr[i];
                if (curMax > max || (curMax == max && (i + 2 - a0 > maxan - maxa0))) {
                    max = curMax;
                    maxa0 = a0;
                    maxan = i + 2;
                }
                if (curMax < 0) {
                    curMax = 0;
                    a0 = i + 2;
                    maxa0 = max <= 0 ? a0 : maxa0;
                }
            }
            if (max <= 0) {
                System.out.println("Route " + t + " has no nice parts");
            } else {
                System.out.println("The nicest part of route " + t + " is between stops " + maxa0 + " and " + maxan);
            }
        }
    }
}
