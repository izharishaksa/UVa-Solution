package problemsolvingparadigms.divideandconquer;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Exact Sum.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11057YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] count = new int[1000005];
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                count[arr[i]]++;
            }
            int M = sc.nextInt();
            int dif = 1000005, x = 0, y = 0;
            for (int i = 0; i < N; i++) {
                try {
                    int sisa = M - arr[i];
                    if (sisa > 0 && ((sisa == arr[i] && count[arr[i]] > 1) || (sisa != arr[i] && count[sisa] > 0)) && Math.abs(sisa - arr[i]) < dif) {
                        dif = Math.abs(sisa - arr[i]);
                        x = arr[i];
                        y = sisa;
                    }
                } catch (Exception e) {
                }
            }
            if (x > y) {
                x ^= y;
                y ^= x;
                x ^= y;
            }
            pw.println("Peter should buy books whose prices are " + x + " and " + y + ".\n");
            pw.flush();
        }
        pw.close();
    }
}
