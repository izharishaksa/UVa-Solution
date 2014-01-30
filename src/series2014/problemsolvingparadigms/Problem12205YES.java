package series2014.problemsolvingparadigms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Happy Telephones.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12205YES {

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
        while (true) {
            int n = readInt();
            int m = readInt();
            if (n == 0 && m == 0) {
                break;
            }
            int[][] phones = new int[n][2];
            for (int i = 0; i < n; i++) {
                readInt();
                readInt();
                phones[i][0] = readInt();
                phones[i][1] = readInt();
            }
            for (int i = 0; i < m; i++) {
                int count = 0;
                int s = readInt(), t = readInt();
                t = s + t - 1;
                for (int j = 0; j < n; j++) {
                    int a = phones[j][0];
                    int b = a + phones[j][1] - 1;
                    if ((a >= s && b <= t) || (s >= a && t <= b) || (a >= s && a <= t) || (b >= s && b <= t)) {
                        count++;
                    }
                }
                pw.println(count);
            }
            pw.flush();
        }
        pw.close();
    }
}
