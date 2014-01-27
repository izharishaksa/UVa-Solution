package problemsolvingparadigms.greedy;

import java.util.Scanner;

/**
 * Scarecrow.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12405YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int T = 1; T <= TC; T++) {
            int len = sc.nextInt();
            String s = sc.next();
            System.out.print("Case " + T + ": ");
            if ((len == 1 && s.charAt(0) == '.') || (len == 2 && s.charAt(0) == '.') || (len == 2 && s.charAt(1) == '.')) {
                System.out.println(1);
                continue;
            } else if (len <= 2) {
                System.out.println(0);
                continue;
            }
            boolean[] cov = new boolean[len];
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '#') {
                    cov[i] = true;
                }
            }
            int total = 0;
            for (int i = 0; i < len; i++) {
                if (!cov[i]) {
                    total++;
                    cov[i] = true;
                    if (i + 1 < len && !cov[i + 1]) {
                        cov[i + 1] = true;
                    }
                    if (i + 2 < len && !cov[i + 2]) {
                        cov[i + 2] = true;
                    }
                }
            }
            System.out.println(total);
        }
    }
}
