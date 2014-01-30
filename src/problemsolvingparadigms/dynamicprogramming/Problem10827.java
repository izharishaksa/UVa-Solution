package problemsolvingparadigms.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Maximum Sum on a Torus.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10827 {

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
        int TC = readInt();
        while (TC-- > 0) {
            int N = readInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = readInt();
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    
                }
            }
            System.out.println(max);
        }
    }
}
