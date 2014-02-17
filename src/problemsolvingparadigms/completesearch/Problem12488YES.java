package problemsolvingparadigms.completesearch;

import java.util.Scanner;

/**
 * Start Grid.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12488YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int min = 0;
            for (int i = 0; i < N; i++) {
                int cur = sc.nextInt();
                if (arr[i] != cur) {
                    for (int j = i + 1; j < N; j++) {
                        if (arr[j] == cur) {
                            while (j > i) {
                                arr[j] = arr[j - 1];
                                min++;
                                j--;
                            }
                        }
                    }
                    arr[i] = cur;
                }
            }
            System.out.println(min);
        }
    }
}
