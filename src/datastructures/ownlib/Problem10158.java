package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * War.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10158 {

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
        int N = readInt();
        DisjoinSet ds = new DisjoinSet(N);
        for (int i = 0; i < N; i++) {
            ds.makeSet(i);
        }
        boolean[] set = new boolean[N];
        while (true) {
            pw.flush();
            int c = readInt();
            int x = readInt();
            int y = readInt();
            if (c == 0 && x == 0 && y == 0) {
                break;
            }
            if (c == 1) {
                if (!set[x] || !set[y]) {
                    ds.union(x, y);
                    set[x] = true;
                    set[y] = true;
                } else {
                    int px = ds.find(x);
                    int py = ds.find(y);
                    if (px != py) {
                        pw.println(-1);
                    }
                }
            } else if (c == 2) {
                if (x == y) {
                    pw.println(0);
                    continue;
                }
                if (!set[x] || !set[y]) {
                    if (!set[x]) {
                        ds.union(x, x);
                        set[x] = true;
                    }
                    if (!set[y]) {
                        ds.union(y, y);
                        set[y] = true;
                    }
                } else {
                    int px = ds.find(x);
                    int py = ds.find(y);
                    if (px == py) {
                        pw.println(-1);
                    }
                }
            } else if (c == 3) {
                if (x == y) {
                    pw.println(1);
                    continue;
                }
                if (set[x] && set[y]) {
                    int px = ds.find(x);
                    int py = ds.find(y);
                    if (px == py) {
                        pw.println(1);
                    } else {
                        pw.println(0);
                    }
                } else {
                    pw.println(0);
                }
            } else if (c == 4) {
                if (x == y) {
                    pw.println(0);
                    continue;
                }
                if (set[x] && set[y]) {
                    int px = ds.find(x);
                    int py = ds.find(y);
                    if (px != py) {
                        pw.println(1);
                    } else {
                        pw.println(0);
                    }
                } else {
                    pw.println(0);
                }
            }
        }
        pw.close();
        br.close();
    }

    static class DisjoinSet {

        int[] parent, rank;

        public DisjoinSet(int N) {
            parent = new int[N];
            rank = new int[N];
        }

        public void makeSet(int x) {
            parent[x] = x;
            rank[x] = 1;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // public int find
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
            if (rank[px] == rank[py]) {
                rank[px]++;
            }
        }
    }
}
