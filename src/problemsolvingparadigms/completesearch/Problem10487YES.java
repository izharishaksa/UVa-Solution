package problemsolvingparadigms.completesearch;

import java.util.Scanner;

/**
 * Closest Sums.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10487YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = 1;
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Case " + TC + ":");
            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int X = sc.nextInt(), dif = Integer.MAX_VALUE;
                int res = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (Math.abs(X - (arr[j] + arr[k])) < dif) {
                            dif = Math.abs(X - (arr[j] + arr[k]));
                            res = arr[j] + arr[k];
                        }
                    }
                }
                System.out.println("Closest sum to " + X + " is " + res + ".");
            }
            TC++;
        }
    }
}
