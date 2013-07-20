package mathematics.adhoc;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10035YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            int[] x = new int[10];
            int[] y = new int[10];
            String sa = a + "";
            String sb = b + "";
            for (int i = sa.length() - 1, j = 9; i >= 0; i--, j--) {
                x[j] = sa.charAt(i) - '0';
            }
            for (int i = sb.length() - 1, j = 9; i >= 0; i--, j--) {
                y[j] = sb.charAt(i) - '0';
            }
            int res = 0, sisa = 0;
            for (int i = 9; i >= 0; i--) {
                try {
                    int temp = x[i] + y[i] + sisa;
                    if (temp > 9) {
                        sisa = 1;
                        res++;
                    } else sisa = 0;
                } catch (Exception e) {

                }
            }
            if (res == 0) {
                System.out.println("No carry operation.");
            } else if (res == 1) {
                System.out.println("1 carry operation.");
            } else {
                System.out.println(res + " carry operations.");
            }
        }
    }

}
