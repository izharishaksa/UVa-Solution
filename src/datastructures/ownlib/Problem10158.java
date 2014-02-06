package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

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
        while (true) {
            int c = readInt();
            int x = readInt();
            int y = readInt();
            if (c == 0 && x == 0 && y == 0) {
                break;
            }
            if (c == 1) {
                if (!ds.isEnemy(x, y)) {
                    ds.union(x, y);
                } else {
                    pw.println(-1);
                }
            } else if (c == 2) {
                boolean res = ds.setEnemy(x, y);
                if (!res) {
                    pw.println(-1);
                }
            } else if (c == 3) {
                int px = ds.find(x);
                int py = ds.find(y);
                if (px == py) {
                    pw.println(1);
                } else {
                    pw.println(0);
                }
            } else if (c == 4) {
                if (ds.isEnemy(x, y)) {
                    pw.println(1);
                } else {
                    pw.println(0);
                }
            }
            pw.flush();
        }
        pw.close();
        br.close();
    }

    static class DisjoinSet {

        int[] parent, rank;
        Set<Integer>[] enemy;

        public DisjoinSet(int N) {
            parent = new int[N];
            rank = new int[N];
            enemy = new HashSet[N];
        }

        public void makeSet(int x) {
            parent[x] = x;
            rank[x] = 1;
            enemy[x] = new HashSet<Integer>();
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] >= rank[py]) {
                    parent[py] = px;
                    for (int i : enemy[py]) {
                        enemy[px].add(i);
                    }
                } else {
                    parent[px] = py;
                    for (int i : enemy[px]) {
                        enemy[py].add(i);
                    }
                }
                if (rank[px] == rank[py]) {
                    rank[px]++;
                }
            }
        }

        public boolean isEnemy(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (enemy[px].contains(py)) {
                return true;
            }
            return false;
        }

        public boolean setEnemy(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }
            enemy[px].add(py);
            enemy[py].add(px);
            for (int i : enemy[px]) {
                union(py, i);
            }
            for (int i : enemy[py]) {
                union(px, i);
            }
            return true;
        }
    }
}