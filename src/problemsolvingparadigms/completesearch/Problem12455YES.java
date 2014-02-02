package problemsolvingparadigms.completesearch;

import java.util.Scanner;

/**
 * Bars.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12455YES {

    static int T, N;
    static int[] arr;
    static boolean[] used;
    static boolean found;

    static void dfs(int cur) {
        if (cur == T) {
            found = true;
            System.out.println("YES");
        } else if (cur < T && !found) {
            for (int i = 0; i < N; i++) {
                if (!used[i] && cur + arr[i] <= T) {
                    used[i] = true;
                    dfs(cur + arr[i]);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while (TC-- > 0) {
            T = sc.nextInt();
            N = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            used = new boolean[N];
            found = false;
            dfs(0);
            if (!found) {
                System.out.println("NO");
            }
        }
    }
}
