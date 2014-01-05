package problemsolvingparadigms.completesearch;

import java.util.*;

/**
 * Lotto.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem441YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ind = 0;
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            if (ind > 0) {
                System.out.println();
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        for (int l = k + 1; l < N; l++) {
                            for (int m = l + 1; m < N; m++) {
                                for (int n = m + 1; n < N; n++) {
                                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l] + " " + arr[m] + " " + arr[n]);
                                }
                            }
                        }
                    }
                }
            }
            ind++;
        }
    }
}
