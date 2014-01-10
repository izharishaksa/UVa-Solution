package datastructures.builtin;

import java.util.Scanner;

/**
 * Splitting Numbers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11933YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            String s = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
            String a = "";
            String b = "";
            boolean first = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (first) {
                        a += "0";
                        b += "1";
                    } else {
                        a += "1";
                        b += "0";
                    }
                    first = !first;
                } else {
                    a += "0";
                    b += "0";
                }
            }
            System.out.println(Integer.parseInt(new StringBuilder(a).reverse().toString(), 2) + " " + Integer.parseInt(new StringBuilder(b).reverse().toString(), 2));
        }
    }
}
