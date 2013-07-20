package introduction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10082YES {

    static int cek(int n) {
        if (n >= 101) {
            return n - 10;
        } else if (n <= 100) {
            return cek(n + 11);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String a = "`1234567890-=";
        String b = "QWERTYUIOP[]\\";
        String c = "ASDFGHJKL;'";
        String d = "ZXCVBNM,./";
        String s = "", ret = "";
        while (sc.hasNext()) {
            s = sc.nextLine();
            ret = "";
            char x = ' ';
            int p = 0, q = 0, r = 0, z = 0;
            for (int i = 0; i < s.length(); i++) {
                x = s.charAt(i);
                if (x == ' ') {
                    ret += ' ';
                } else {
                    p = a.indexOf(x);
                    q = b.indexOf(x);
                    r = c.indexOf(x);
                    z = d.indexOf(x);
                    if (p >= 0) {
                        ret += a.charAt(p - 1);
                    } else if (q >= 0) {
                        ret += b.charAt(q - 1);
                    } else if (r >= 0) {
                        ret += c.charAt(r - 1);
                    } else {
                        ret += d.charAt(z - 1);
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
