package mathematics.primenumber;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10650YES {

    static boolean isPrime(int n ) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Note:
     * 1. If all numbers are in the sequence not included in interval, then don't print them.
     * 2. Last number in one sequence could be used in the next sequence.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> primeList = new ArrayList<Integer>();
        for (int i = 2; i < 32000; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n > m) {
                n ^= m;
                m ^= n;
                n ^= m;
            }
            if (n == m && n == 0) break;
            for (int i = 0; i < primeList.size() - 2; i++) {
                int a = primeList.get(i);
                int b = primeList.get(i + 1);
                int c = primeList.get(i + 2);
                int d = b - a;
                int e = c - b;
                if (d != e) continue;
                List<Integer> list = new ArrayList<Integer>();
                list.add(a); list.add(b); list.add(c);
                int j = i + 3;
                for (j = i + 3; j < primeList.size(); j++) {
                    int f = primeList.get(j);
                    if (f - c == d) {
                        c = f;
                        list.add(f);
                    } else {
                        break;
                    }
                }
                i = j - 2;
                if (list.get(0) >= n && list.get(list.size() - 1) <= m) {
                    int size = list.size();
                    for (int k = 0; k < size - 1; k++) {
                        System.out.print(list.get(k) + " ");
                    }
                    System.out.println(list.get(size - 1));
                }
            }
        }
    }

}
