package problemsolvingparadigms.completesearch;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Prime Ring Problem.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem524YES {

    static boolean[] prime;
    static PrintWriter pw;

    static void generateRing(boolean[] used, int prev, int count, int N, List<Integer> list) {
        if (count == N && prime[prev + 1]) {
            pw.print("1 ");
            for (int i = 0; i < N - 2; i++) {
                pw.print(list.get(i) + " ");
            }
            pw.println(list.get(N - 2));
        } else if (count < N) {
            for (int i = 2; i <= N; i++) {
                if (!used[i] && prime[i + prev]) {
                    used[i] = true;
                    list.add(i);
                    generateRing(used, i, count + 1, N, list);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        prime = new boolean[32];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= 32; i++) {
            if (prime[i]) {
                for (int j = i + i; j < 32; j += i) {
                    prime[j] = false;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        int T = 1;
        while (sc.hasNext()) {
            if (T > 1) {
                pw.println();
            }
            int n = sc.nextInt();
            boolean[] used = new boolean[n + 1];
            used[1] = true;
            pw.println("Case " + T + ":");
            generateRing(used, 1, 1, n, new ArrayList<Integer>());
            pw.flush();
            T++;
        }
        pw.close();
    }
}
