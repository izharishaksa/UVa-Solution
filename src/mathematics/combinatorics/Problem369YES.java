package mathematics.combinatorics;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem369YES {

    static HashMap<Integer, Integer> factorize(int a, int b) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = a; i <= b; i++) {
            int x = i;
            int prime = 2;
            while (x >= prime) {
                if (x % prime == 0) {
                    if (map.containsKey(prime)) {
                        int z = map.get(prime);
                        map.put(prime, z + 1);
                    } else {
                        map.put(prime, 1);
                    }
                    x /= prime;

                } else {
                    prime++;
                }
            }
            if (x > 1) {
                map.put(x, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            long ans = 1;
            int start = n - m + 1;
            HashMap<Integer, Integer> a = factorize(start, n);
            HashMap<Integer, Integer> b = factorize(2, m);

            Integer[] keyA = a.keySet().toArray(new Integer[0]);
            Integer[] keyB = b.keySet().toArray(new Integer[0]);

            for (int i = 0; i < keyB.length; i++) {
                int x = b.get(keyB[i]);
                int y = a.get(keyB[i]) - x;
                a.put(keyB[i], y);
            }

            for (int i = 0; i < keyA.length; i++) {
                int x = a.get(keyA[i]);
                if (x < 1) {
                    continue;
                }
                ans *= (long) Math.pow(keyA[i], x);
            }

            System.out.println(n + " things taken " + m + " at a time is " + ans + " exactly.");
        }
    }
}
