package mathematics.factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem324YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while ((n = sc.nextInt()) != 0) {
            BigInteger bi = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                bi = bi.multiply(new BigInteger(i + ""));
            }
            String s = bi.toString();
            int[] arr = new int[10];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - '0']++;
            }
            System.out.println(n + "! --");
            System.out.println("   (0)" + addSpace(arr[0]) + "    (1)" + addSpace(arr[1]) + "    (2)" + addSpace(arr[2]) + "    (3)" + addSpace(arr[3]) + "    (4)" + addSpace(arr[4]));
            System.out.println("   (5)" + addSpace(arr[5]) + "    (6)" + addSpace(arr[6]) + "    (7)" + addSpace(arr[7]) + "    (8)" + addSpace(arr[8]) + "    (9)" + addSpace(arr[9]));

        }
    }

    static String addSpace(int n) {
        String s = n + "";
        int len = s.length();
        for (int i = 0; i < 5 - len; i++) {
            s = " " + s;
        }
        return s;
    }
}
