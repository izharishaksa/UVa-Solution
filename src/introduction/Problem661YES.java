package introduction;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem661YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int c = sc.nextInt();
            if (n == 0 && m == 0 && c == 0) break;
            boolean[] on = new boolean[n];
            int[] arr = new int[n];
            Arrays.fill(on, false);
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int cur = 0;
            int max = 0;
            boolean finish = true;
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                if (on[x]) {
                    cur -= arr[x];
                } else {
                    cur += arr[x];
                }
                max = Math.max(max, cur);
                if (cur > c) {
                    finish = false;
                }
                on[x] = !on[x];
            }
            System.out.println("Sequence " + (t++));
            if (finish) {
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was " + max + " amperes.");
            } else {
                System.out.println("Fuse was blown.");
            }
            System.out.println();
        }
    }

}
