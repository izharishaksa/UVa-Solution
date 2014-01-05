package mathematics.factorial;

import java.util.*;

/**
 * Recover Factorial.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10856 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prev = 0;
        long start = System.currentTimeMillis();
        //int x = 0, y = 0;
        for (int i = 0; prev < 1000002; i++) {
            int x = 2;
            int y = i;
            int count = 0;
            while (y > x) {
                if (map.containsKey(y)) {
                    count += map.get(y);
                    break;
                }
                if (y % x == 0) {
                    y /= x;
                    count++;
                } else {
                    x++;
                }
            }
            if (y > 1) {
                count++;
            }
            map.put(prev + count, i);
            prev += count;
        }
        System.out.println(System.currentTimeMillis() - start);
        Scanner sc = new Scanner(System.in);
        int n;
        int t = 1;
        while ((n = sc.nextInt()) != -1) {
            if (map.containsKey(n)) {
                System.out.println("Case " + t + ": " + map.get(n) + "!");
            } else {
                System.out.println("Case " + t + ": Not possible.");
            }
            t++;
        }
    }
}
