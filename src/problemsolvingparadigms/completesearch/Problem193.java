package problemsolvingparadigms.completesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Graph Coloring.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem193 {

    static BufferedReader br;
    static List<Integer> result;
    static boolean[][] map;
    static int N, max;
    static boolean[] colored;

    static void recurse(List<Integer> list) {
        int nColored = 0;
        for (int i = 0; i < N; i++) {
            if (colored[i]) {
                nColored++;
            }
        }
        if (nColored == N) {
            if (list.size() > max) {
                result.clear();
                for (int i : list) {
                    result.add(i);
                }
                max = list.size();
            }
        } else if ((N - nColored) / 2 + list.size() > max) {
            for (int i = 0; i < N; i++) {
                if (!colored[i]) {
                    colored[i] = true;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j]) {
                            colored[j] = true;
                        }
                    }
                    list.add(i);
                    recurse(list);
                    colored[i] = false;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j]) {
                            colored[j] = false;
                        }
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = readInt();
        while (T-- > 0) {
            N = readInt();
            int M = readInt();
            map = new boolean[N][N];
            for (int i = 0; i < M; i++) {
                int a = readInt() - 1;
                int b = readInt() - 1;
                map[a][b] = true;
                map[b][a] = true;
            }
            int start = 0, minDegree = N;
            for (int i = 0; i < N; i++) {
                int degree = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j]) {
                        degree++;
                    }
                }
                if (degree < minDegree) {
                    minDegree = degree;
                    start = i;
                }
            }
            colored = new boolean[N];
            result = new ArrayList<Integer>();
            max = 0;
            colored[start] = true;
            System.arraycopy(map[start], 0, colored, 0, N);
            List<Integer> temp = new ArrayList<Integer>();
            recurse(temp);
            pw.println(result.size());
            for (int i = 0; i < result.size() - 1; i++) {
                pw.print((result.get(i) + 1) + " ");
            }
            try {
                pw.println(result.get(result.size() - 1) + 1);
            } catch (Exception e) {
                pw.println(0);
            }
            pw.flush();
        }
        pw.close();
    }

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
}
