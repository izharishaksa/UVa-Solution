package mathematics.numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10622YES {

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            boolean negatif = false;
            if (n < 0) {
                n *= -1;
                negatif = true;
            }
            long m = n;
            if (n == 0) {
                break;
            }
            long i = 2;
            Hashtable<Long, Long> hi = new Hashtable<Long, Long>();
            do {
                if (n % i == 0) {
                    if (hi.containsKey(i)) {
                        long q = hi.get(i) + 1;
                        hi.put(i, q);
                    } else {
                        hi.put(i, (long) 1);
                    }
                    n /= i;
                } else {
                    i++;
                }
            } while (i * i <= n);
            if (hi.containsKey(n)) {
                long q = hi.get(n) + 1;
                hi.put(n, q);
            } else {
                hi.put(n, (long) 1);
            }
            if (hi.size() == 1) {
                if (negatif) {
                    Set<Long> key = hi.keySet();
                    Long[] temp = key.toArray(new Long[0]);
                    long x = hi.get(temp[0]);
                    while (x % 2 == 0) {
                        x /= 2;
                    }
                    System.out.println(x);
                } else {
                    Set<Long> key = hi.keySet();
                    Long[] temp = key.toArray(new Long[0]);
                    System.out.println(hi.get(temp[0]));
                }
            } else {
                Set<Long> s = hi.keySet();
                Long[] key = s.toArray(new Long[0]);
                long g = hi.get(key[0]);
                long hasil = 1;
                for (int j = 1; j < key.length; j++) {
                    g = gcd(g, hi.get(key[j]));
                }
                if (negatif) {
                    while (g % 2 == 0) {
                        g /= 2;
                    }
                }
                for (int j = 0; j < key.length; j++) {
                    long p = (long) Math.pow(key[j], hi.get(key[j]) / g);
                    hasil *= p;
                }
                long total = hasil;
                for (int j = 1;; j++) {
                    if (total == m) {
                        System.out.println(j);
                        break;
                    }
                    if (total > m) {
                        System.out.println(1);
                        break;
                    }
                    total *= hasil;
                }
            }
        }
    }
}
