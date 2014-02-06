package problemsolvingparadigms.dynamicprogramming;

import java.util.Scanner;

/**
 * Maximum Product.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11059YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ind = 1;
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            long max = 0;
            for (int i = 0; i < N; i++) {
                int res = 1;
                for (int j = i; j < N; j++) {
                    res *= arr[j];
                    max = Math.max(max, res);
                }
            }
            System.out.println("Case #" + ind + ": The maximum product is " + max + ".\n");
            ind++;
        }
    }
}
