package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Virtual Friends.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11503YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            DisjoinSets ds = new DisjoinSets();
            String[] temp;
            for (int i = 0; i < N; i++) {
                temp = br.readLine().split(" ");
                ds.makeSet(temp[0]);
                ds.makeSet(temp[1]);
                ds.union(ds.map.get(temp[0]), ds.map.get(temp[1]));
                pw.println(ds.nMap.get(ds.find(ds.map.get(temp[0]))));
            }
        }
        pw.flush();
        pw.close();
    }

    static class DisjoinSets {

        List<Integer> parent, rank;
        HashMap<String, Integer> map;
        HashMap<Integer, Integer> nMap;
        int total;

        public DisjoinSets() {
            map = new HashMap<String, Integer>();
            nMap = new HashMap<Integer, Integer>();
            parent = new ArrayList<Integer>();
            rank = new ArrayList<Integer>();
            total = 0;
        }

        void makeSet(String s) {
            if (!map.containsKey(s)) {
                map.put(s, total);
                parent.add(total);
                rank.add(0);
                nMap.put(total, 1);
                total++;
            }
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                int totalFriend = nMap.get(px) + nMap.get(py);
                nMap.put(px, totalFriend);
                nMap.put(py, totalFriend);
            }
            if (rank.get(px) > rank.get(py)) {
                parent.set(py, px);
            } else {
                parent.set(px, py);
            }
            if (rank.get(px) == rank.get(py)) {
                rank.set(py, rank.get(py) + 1);
            }
        }

        int find(int x) {
            if (x != parent.get(x)) {
                parent.set(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
    }
}
