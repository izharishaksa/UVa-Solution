package problemsolvingparadigms.completesearch;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Fractions Again?!
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10976YES {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            double limit = 1.0 / N;
            LinkedList<String> result = new LinkedList<String>();
            for (int i = 2;; i++) {
                int z = N;
                int x = i;
                int g = gcd(x, z);
                int denominator = x * z / g;
                int kiri = 1;
                x = denominator / x;
                z = denominator / z;
                int sisa = z - x;
                if (sisa > 0) {
                    g = gcd(sisa, N);
                    if (sisa != g) {
                        continue;
                    }
                    int y = denominator / g;
                    result.add("1/" + N + " = " + "1/" + y + " + 1/" + i);
                    if (y == i) {
                        break;
                    }
                }
            }
            pw.println(result.size());
            for (String i : result) {
                pw.println(i);
            }
            pw.flush();
        }
        pw.close();
    }
}
