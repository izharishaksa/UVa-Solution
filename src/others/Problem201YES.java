package others;

import java.util.*;
import java.io.*;
/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem201YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ind = 1;
        String s;
        while ((s = br.readLine()) != null) {
            if (ind > 1) {
                System.out.println("\n**********************************\n");
            }
            int N = Integer.parseInt(s);
            int[][] arr = new int[N][N];
            int m = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < m; i++) {
                s = br.readLine();
                map.put(s, 1);
            }
            int[] res = new int[10];
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        boolean ok = true;
                        for (int l = 0; l < i; l++) {
                            if (!map.containsKey("V " + (j + 1) + " " + (k + l + 1))) {
                                ok = false;
                            }
                            if (!map.containsKey("V " + (j + 1 + i) + " " + (k + l + 1))) {
                                ok = false;
                            }
                            if (!map.containsKey("H " + (k + 1) + " " + (j + l + 1))) {
                                ok = false;
                            }
                            if (!map.containsKey("H " + (k + 1 + i) + " " + (j + l + 1))) {
                                ok = false;
                            }
                            if (!ok) break;
                        }
                        if (ok) {
                            res[i]++;
                        }
                    }
                }
            }
            System.out.println("Problem #" + (ind++) + "\n");
            boolean ok = false;
            for (int i = 0; i < 10; i++) {
                if (res[i] != 0) {
                    System.out.println(res[i] + " square (s) of size " + i);
                    ok = true;
                }
            }
            if (!ok) {
                System.out.println("No completed squares can be found.");
            }
        }
    }
}
