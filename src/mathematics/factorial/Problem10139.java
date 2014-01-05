package mathematics.factorial;

import java.io.*;

/**
 * Factovisors.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10139 {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String s;
        while ((s = br.readLine()) != null) {
            String[] temp = s.split("[ ]");
            int m = Integer.parseInt(temp[0]);
            int n = Integer.parseInt(temp[1]);
            if (isPrime(n) && n > m) {
                pw.println(n + " does not divide " + m + "!");
                continue;
            }
            long fak = 1;
            boolean ada = false;
            for (int i = m; i >= 2; i--) {
                fak *= i;
                if (fak % n == 0) {
                    ada = true;
                    System.out.println(m + " == " + n + " >> " + fak + " % " + n + " = " + (fak % n));
                    break;
                }
            }
            if (ada) {
                pw.println(n + " divides " + m + "!");
            } else {
                pw.println(n + " does not divide " + m + "!");
            }
            /*int y = n;
             HashMap<Integer, Integer> factor = new HashMap<Integer, Integer>();
             int x = 2;
             boolean prime = false;
             if (isPrime(n)) {
             prime = true;
             factor.put(x, 1);
             }
             while (n >= x && !prime) {
             if (n % x == 0) {
             if (factor.containsKey(x)) {
             factor.put(x, factor.get(x) + 1);
             } else {
             factor.put(x, 1);
             }
             n /= x;
             } else x++;
             }
             if (n > 1 && !prime) factor.put(x, 1);

             if (prime && y > m) {
             pw.println(y + " does not divide " + m + "!");
             continue;
             }

             Integer[] key = factor.keySet().toArray(new Integer[0]);
             boolean bisa = true;
             for (int i = 0; i < key.length; i++) {
             int tot = factor.get(key[i]);
             for (int j = 1; j <= tot; j++) {
             long vv = j * key[i];
             long gg = n * n;
             if (vv > gg) {
             bisa = false;
             break;
             }
             }
             if (!bisa) break;
             }
             if (bisa && y > 0) {
             pw.println(y + " divides " + m + "!");
             } else {
             pw.println(y + " does not divide " + m + "!");
             }*/
            pw.flush();
        }
        pw.close();
    }
}
