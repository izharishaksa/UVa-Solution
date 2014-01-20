package datastructures.ownlib;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Forests.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10227YES {

    static class DisjointSet {

        int[] parent, rank;

        public DisjointSet(int N, int M) {
            parent = new int[N + 1];
            rank = new int[N + 1];
        }

        void makeSet(int x) {
            parent[x] = x;
            rank[x] = 0;
        }

        void union(int x, int y) {
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

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    static boolean isSameOpinions(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int TC = sc.nextInt();
        for (int T = 0; T < TC; T++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            DisjointSet ds = new DisjointSet(N, M);
            for (int i = 1; i <= N; i++) {
                ds.makeSet(i);
            }
            sc.nextLine();
            boolean[][] opinions = new boolean[N + 1][M + 1];
            while (sc.hasNext()) {
                String[] temp = sc.nextLine().split(" ");
                if (temp.length == 1) {
                    break;
                }
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                opinions[a][b] = true;
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (isSameOpinions(opinions[i], opinions[j])) {
                        ds.union(i, j);
                    }
                }
            }
            HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
            for (int i = 1; i <= N; i++) {
                map.put(ds.parent[i], Boolean.TRUE);
            }
            pw.println(map.size());
            if (T < TC - 1) {
                pw.println();
            }
            pw.flush();
        }
        pw.close();
    }
}
