package mathematics.numbertheory;

import java.io.*;
import java.util.*;

/**
 * Prime Factors.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem583YES {

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        boolean[] benar = new boolean[46342];
        Arrays.fill(benar, true);
        for (int i = 2; i <= 46341; i++) {
            if (benar[i]) {
                list.add(i);
                for (int j = i + i; j <= 46341; j += i) {
                    benar[j] = false;
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if (n == 0) {
                break;
            }
            boolean sign = false;
            int temp = n;
            if (n < 0) {
                sign = true;
                n *= -1;
            }
            HashMap<Integer, Integer> factor = new HashMap<Integer, Integer>();
            int ind = 0;
            int x = list.get(ind);
            while (n >= x * x) {
                if (n % x == 0) {
                    if (factor.containsKey(x)) {
                        factor.put(x, factor.get(x) + 1);
                    } else {
                        factor.put(x, 1);
                    }
                    n /= x;
                } else {
                    ind++;
                    if (ind == list.size()) {
                        break;
                    }
                    x = list.get(ind);
                }
            }
            if (n > 1) {
                if (factor.containsKey(n)) {
                    factor.put(n, factor.get(n) + 1);
                } else {
                    factor.put(n, 1);
                }
            }
            Integer[] key = factor.keySet().toArray(new Integer[0]);
            pw.print(temp + " = ");
            if (sign) {
                pw.print("-1 x ");
            }
            Arrays.sort(key);
            for (int i = 0; i < key.length; i++) {
                int vv = factor.get(key[i]);
                for (int j = 0; j < factor.get(key[i]); j++) {
                    pw.print(key[i]);
                    if (i < key.length - 1) {
                        pw.print(" x ");
                    } else if (j < vv - 1) {
                        pw.print(" x ");
                    }
                }
            }
            pw.println();
            pw.flush();
        }
        pw.close();
    }
}
