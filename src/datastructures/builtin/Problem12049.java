package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Just Prune the List.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12049 {

    static BufferedReader br;

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    static int readInt() throws Exception {
        int c = br.read();
        while (isWhitespace(c)) {
            c = br.read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = br.read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = br.read();
        } while (!isWhitespace(c));
        return res * sgn;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int TC = readInt();
        while (TC-- > 0) {
            int A = readInt();
            int B = readInt();
            for (int i = 0; i < A; i++) {
                int x = readInt();
            }
            for (int i = 0; i < B; i++) {
                int x = readInt();
            }

            int total = 0;
            pw.println(total);
            pw.flush();
        }
        pw.close();
        br.close();
    }
}
