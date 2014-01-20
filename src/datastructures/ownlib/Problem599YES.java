package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * The Forest for the Trees.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem599YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String line;
            boolean[][] map = new boolean[26][26];
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '*') {
                    break;
                }
                int a = line.charAt(1) - 'A';
                int b = line.charAt(3) - 'A';
                map[a][b] = true;
                map[b][a] = true;
            }
            int[] exist = new int[26];
            line = br.readLine();
            for (int i = 0, j = 1; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    exist[c - 'A'] = j++;
                }
            }
            boolean[] sudah = new boolean[26];
            for (int i = 0; i < 26; i++) {
                if (exist[i] != 0 && !sudah[i]) {
                    Queue<Integer> q = new ArrayDeque<Integer>();
                    q.add(i);
                    sudah[i] = true;
                    int g = exist[i];
                    while (!q.isEmpty()) {
                        int cur = q.poll();
                        for (int j = 0; j < 26; j++) {
                            if (exist[j] != 0 && !sudah[j] && map[cur][j]) {
                                q.add(j);
                                exist[j] = g;
                                sudah[j] = true;
                            }
                        }
                    }
                }
            }
            int[] group = new int[27];
            for (int i = 0; i < 26; i++) {
                if (exist[i] == 0) {
                    continue;
                }
                group[exist[i]]++;
            }
            int tree = 0;
            int acorn = 0;
            for (int i = 0; i < 27; i++) {
                if (group[i] == 1) {
                    acorn++;
                } else if (group[i] > 1) {
                    tree++;
                }
            }
            pw.println("There are " + tree + " tree(s) and " + acorn + " acorn(s).");
            pw.flush();
        }
        pw.close();
    }
}
