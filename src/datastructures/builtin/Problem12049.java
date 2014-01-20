package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

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
        for (int T = 0; T < TC; T++) {
            int A = readInt();
            int B = readInt();
            int[] arrA = new int[A];
            for (int i = 0; i < A; i++) {
                int x = readInt();
                arrA[i] = x;
            }
            Arrays.sort(arrA);
            int[] arrB = new int[B];
            for (int i = 0; i < B; i++) {
                int x = readInt();
                arrB[i] = x;
            }
            Arrays.sort(arrB);
            int indA = 0, indB = 0, same = 0;
            while (indA < A && indB < B) {
                if (arrA[indA] == arrB[indB]) {
                    same++;
                    indA++;
                    indB++;
                } else if (arrA[indA] > arrB[indB]) {
                    indB++;
                } else {
                    indA++;
                }
            }
            pw.println(A + B - (2 * same));
        }
        pw.flush();
        pw.close();
        br.close();
    }
}
