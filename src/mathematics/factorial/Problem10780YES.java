package mathematics.factorial;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10780YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
            int x = 2;
            while (m >= x) {
                if (m % x == 0) {
                    if (map1.containsKey(x)) {
                        map1.put(x, map1.get(x) + 1);
                    } else {
                        map1.put(x, 1);
                    }
                    m /= x;
                } else x++;
            }
            if (m > 1) {
                map1.put(m, 1);
            }
            int[] key = new int[map1.size()];
            int ind = 0;
            for (int i : map1.keySet()) {
                key[ind++] = i;
            }
            int[] res = new int[key.length];
            for (int i = 2; i <= n; i++) {
                x = i;
                for (int j = 0; j < key.length; j++) {
                    while (x % key[j] == 0) {
                        res[j]++;
                        x /= key[j];
                    }
                }
            }
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < res.length; i++) {
                x = map1.get(key[i]);
                max = Math.min(max, res[i] / x);
            }
            System.out.println("Case " + t + ":");
            if (max > 0 && max != Integer.MAX_VALUE) {
                System.out.println(max);
            } else {
                System.out.println("Impossible to divide");
            }
        }
    }
}