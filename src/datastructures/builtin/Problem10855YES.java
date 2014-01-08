package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Rotated square.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10855YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            char[][] s1 = new char[n][n];
            for (int i = 0; i < n; i++) {
                s1[i] = br.readLine().toCharArray();
            }
            char[][] s2 = new char[m][m];
            for (int i = 0; i < m; i++) {
                s2[i] = br.readLine().toCharArray();
            }
            int[] res = new int[4];
            for (int i = 0; i < 4; i++) {
                for (int o = 0; o <= n - m; o++) {
                    for (int p = 0; p <= n - m; p++) {
                        boolean sama = true;
                        for (int q = 0; q < m; q++) {
                            for (int r = 0; r < m; r++) {
                                if (s1[o + q][p + r] != s2[q][r]) {
                                    sama = false;
                                }
                            }
                        }
                        if (sama) {
                            res[i]++;
                        }
                    }
                }
                char[][] temp = new char[m][m];
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < m; k++) {
                        temp[j][k] = s2[m - 1 - k][j];
                    }
                }
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < m; k++) {
                        s2[j][k] = temp[j][k];
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println(res[3]);
        }
    }
}
