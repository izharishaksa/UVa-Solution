package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Matrix Transpose.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10895YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] temp;
        List[] map = new ArrayList[10001];
        while ((line = br.readLine()) != null) {
            temp = line.split(" ");
            int M = Integer.parseInt(temp[0]);
            int N = Integer.parseInt(temp[1]);
            for (int i = 1; i <= N; i++) {
                map[i] = new ArrayList();
            }
            for (int i = 1; i <= M; i++) {
                temp = br.readLine().split(" ");
                int x = Integer.parseInt(temp[0]);
                String[] temp2 = br.readLine().split(" ");
                for (int j = 0; j < x; j++) {
                    int jj = Integer.parseInt(temp[j + 1]);
                    map[jj].add(new Value(i, Integer.parseInt(temp2[j])));
                }
            }
            System.out.println(N + " " + M);
            for (int i = 1; i <= N; i++) {
                if (map[i] != null && map[i].size() > 0) {
                    System.out.print(map[i].size() + " ");
                    for (int j = 0; j < map[i].size(); j++) {
                        Value val = (Value) map[i].get(j);
                        System.out.print(val.row);
                        if (j < map[i].size() - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    for (int j = 0; j < map[i].size(); j++) {
                        Value val = (Value) map[i].get(j);
                        System.out.print(val.val);
                        if (j < map[i].size() - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                } else if (map[i] != null) {
                    System.out.println(0);
                    System.out.println();
                }
            }

            for (int i = 0; i < 10001; i++) {
                map[i] = null;
            }
        }
    }

    static class Value {

        int row, val;

        public Value(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }
}
