package mathematics.adhoc;

import java.util.Scanner;

/**
 * Brick Game.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11875YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int min = N, ind = arr[0];
            for (int i = 0; i < N; i++) {
                int a = 0, b = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (arr[j] < arr[i]) {
                        a++;
                    }
                    if (arr[j] > arr[i]) {
                        b++;
                    }
                }
                if (Math.abs(a - b) < min) {
                    min = Math.abs(a - b);
                    ind = arr[i];
                }
            }
            System.out.println("Case " + t + ": " + ind);
        }
    }
}
