package mathematics.biginteger;

import java.util.Scanner;

/**
 * Arithmetic.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11952YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s;
        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            s = sc.next();
            int b = sc.nextInt();
            s = sc.next();
            int c = sc.nextInt();
            boolean found = false;

            if ((a == 1 || a == 11 || a == 111 || a == 1111 || a == 11111 || a == 111111)
                    && (b == 1 || b == 11 || b == 111 || b == 1111 || b == 11111 || b == 111111)
                    && (c == 1 || c == 11 || c == 111 || c == 1111 || c == 11111 || c == 111111)) {
                int res = 0;
                if ((a + "").length() + (b + "").length() == (c + "").length()) {
                    res = 1;
                }
                System.out.println(res);
                continue;
            }

            for (int i = 1; !found && i < 60; i++) {
                if (i == 58) {
                    System.out.println(0);
                    found = true;
                }
                try {
                    int aa = Integer.parseInt(a + "", i);
                    int bb = Integer.parseInt(b + "", i);
                    int cc = Integer.parseInt(c + "", i);
                    if (aa + bb == cc) {
                        System.out.println(i);
                        found = true;
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
