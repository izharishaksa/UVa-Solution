package introduction;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11945YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            double[] temp = new double[12];
            double tot = 0;
            for (int i = 0; i < 12; i++) {
                temp[i] = Double.parseDouble(sc.next());
                tot += temp[i];
            }
            tot /= 12;
            if (tot != 0) {
                String s = String.format("%.2f", tot);
                String res = "." + s.substring(s.length() - 2, s.length());
                for (int i = s.length() - 4, j = 1; i >= 0; i--, j++) {
                    res = s.charAt(i) + res;
                    if (j % 3 == 0 && i != 0) {
                        res = "," + res;
                    }
                }
                System.out.println(t + " $" + res);
            } else {
                System.out.print(t + " $0.00\n");
            }
        }
    }
}
