package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Nature.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10685YES {

    static class DisjointSet {

        int[] parent, rank, total;

        public DisjointSet(int N) {
            this.parent = new int[N];
            this.rank = new int[N];
            this.total = new int[N];
        }

        public void makeSet(int x) {
            parent[x] = x;
            rank[x] = x;
            total[x] = 1;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                    total[px] += total[py];
                    total[py] = 0;
                } else {
                    parent[px] = py;
                    total[py] += total[px];
                    total[px] = 0;
                }
                if (rank[px] == rank[py]) {
                    rank[px]++;
                }
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] in;
        while ((line = br.readLine()) != null) {
            in = line.split(" ");
            int C = Integer.parseInt(in[0]);
            int R = Integer.parseInt(in[1]);
            if (C == 0 && R == 0) {
                break;
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            DisjointSet ds = new DisjointSet(C);
            for (int i = 0; i < C; i++) {
                line = br.readLine();
                map.put(line, i);
                ds.makeSet(i);
            }
            for (int i = 0; i < R; i++) {
                in = br.readLine().split(" ");
                int a = map.get(in[0]);
                int b = map.get(in[1]);
                ds.union(a, b);
            }
            int max = 0;
            for (int i = 0; i < C; i++) {
                max = Math.max(max, ds.total[i]);
            }
            System.out.println(max);
            br.readLine();
        }
    }
}
