package mathematics.adhoc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Perfection.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem382YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> vs = new ArrayList<String>();
        int max = 0;
        do {
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
            if ((a + "").length() > max) {
                max = (a + "").length();
            }
            int ret = 0;
            for (int j = 1; j < a; j++) {
                if (a % j == 0) {
                    ret += j;
                }
            }
            String s = a + "";
            if (a == 1) {
                vs.add(s + "  DEFICIENT");
            } else if (ret == a) {
                vs.add(s + "  PERFECT");
            } else if (ret < a) {
                vs.add(s + "  DEFICIENT");
            } else {
                vs.add(s + "  ABUNDANT");
            }
        } while (true);
        System.out.println("PERFECTION OUTPUT");
        for (int i = 0; i < vs.size(); i++) {
            String[] ss = vs.get(i).split("  ");
            int o = ss[0].length();
            String ret = "";
            for (int j = 0; j < 5 - o; j++) {
                ret += " ";
            }
            System.out.println(ret + ss[0] + "  " + ss[1]);
        }
        System.out.println("END OF OUTPUT");
    }
}
