package introduction;

import java.io.IOException;
import java.util.Scanner;

/**
 * LCD Display.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem706YES {

    static String[] a = {" - ", "   ", " - ", " - ", "   ", " - ", " - ", " - ", " - ", " - "};
    static String[] b = {"| |", "  |", "  |", "  |", "| |", "|  ", "|  ", "  |", "| |", "| |"};
    static String[] c = {"   ", "   ", " - ", " - ", " - ", " - ", " - ", "   ", " - ", " - "};
    static String[] d = {"| |", "  |", "|  ", "  |", "  |", "  |", "| |", "  |", "| |", "  |"};
    static String[] e = {" - ", "   ", " - ", " - ", "   ", " - ", " - ", "   ", " - ", " - "};

    static void atas(String s, int m) {
        String u = "";
        for (int i = 0; i < s.length(); i++) {
            String ret = "", sp = " ", add = " ";
            if (a[s.charAt(i) - '0'].indexOf("-") >= 0) {
                add = "-";
            }
            for (int j = 0; j < m; j++) {
                ret += add;
                sp += " ";
            }
            sp = " ";
            ret = " " + ret + " ";
            u += ret;
            if (i != s.length() - 1) {
                u += sp;
            }
        }
        System.out.println(u);
    }

    static void bawah(String s, int m) {
        String u = "";
        for (int i = 0; i < s.length(); i++) {
            String ret = "", sp = "", add = " ";
            if (e[s.charAt(i) - '0'].indexOf("-") >= 0) {
                add = "-";
            }
            for (int j = 0; j < m; j++) {
                ret += add;
                sp += " ";
            }
            ret = " " + ret + " ";
            u += ret;
            sp = " ";
            if (i != s.length() - 1) {
                u += sp;
            }
        }
        System.out.println(u);
    }

    static void tengah(String s, int m) {
        String u = "";
        for (int i = 0; i < s.length(); i++) {
            String ret = "", sp = "", add = " ";
            if (c[s.charAt(i) - '0'].indexOf("-") >= 0) {
                add = "-";
            }
            for (int j = 0; j < m; j++) {
                ret += add;
                sp += " ";
            }
            ret = " " + ret + " ";
            u += ret;
            sp = " ";
            if (i != s.length() - 1) {
                u += sp;
            }
        }
        System.out.println(u);
    }

    static void tegak1(String s, int m) {
        for (int i = 0; i < m; i++) {
            String x = "";
            for (int k = 0; k < s.length(); k++) {
                String ret = "", sp = "";
                for (int j = 0; j < m; j++) {
                    ret += " ";
                    sp += " ";
                }
                if (b[s.charAt(k) - '0'].charAt(0) == '|') {
                    ret = "|" + ret;
                } else {
                    ret = " " + ret;
                }
                if (b[s.charAt(k) - '0'].charAt(2) == '|') {
                    ret += "|";
                } else {
                    ret += " ";
                }
                x += ret;
                sp = " ";
                if (k != s.length() - 1) {
                    x += sp;
                }
            }
            System.out.println(x);
        }
    }

    static void tegak2(String s, int m) {
        for (int i = 0; i < m; i++) {
            String x = "";
            for (int k = 0; k < s.length(); k++) {
                String ret = "", sp = "";
                for (int j = 0; j < m; j++) {
                    ret += " ";
                    sp += " ";
                }
                if (d[s.charAt(k) - '0'].charAt(0) == '|') {
                    ret = "|" + ret;
                } else {
                    ret = " " + ret;
                }
                if (d[s.charAt(k) - '0'].charAt(2) == '|') {
                    ret += "|";
                } else {
                    ret += " ";
                }
                x += ret;
                sp = " ";
                if (k != s.length() - 1) {
                    x += sp;
                }
            }
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0) {
                break;
            }
            String s = m + "";
            atas(s, n);
            tegak1(s, n);
            tengah(s, n);
            tegak2(s, n);
            bawah(s, n);
            System.out.println();
        }
    }
}
