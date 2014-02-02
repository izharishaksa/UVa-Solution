package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Symmetric Matrix.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11349YES {

    static BufferedReader br;

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    static long readInt() throws Exception {
        int c = br.read();
        while (isWhitespace(c)) {
            c = br.read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = br.read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = br.read();
        } while (!isWhitespace(c));
        return res * sgn;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int T = 1; T <= TC; T++) {
            int N = Integer.parseInt(br.readLine().split(" ")[2]);
            long[][] mat = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] = readInt();
                }
            }
            boolean symmetric = true;
            int len = N >> 1;
            if (N % 2 == 1) {
                len++;
            }
            for (int i = 0; i < len && symmetric; i++) {
                for (int j = 0; j < N && symmetric; j++) {
                    if (mat[i][j] < 0 || mat[i][j] != mat[N - i - 1][N - j - 1]) {
                        symmetric = false;
                    }
                }
            }
            System.out.print("Test #" + T + ": ");
            if (symmetric) {
                System.out.println("Symmetric.");
            } else {
                System.out.println("Non-symmetric.");
            }
        }
    }
}