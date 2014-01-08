package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The Most Potent Corner.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10264YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int[][] bit = new int[16385][15];
        for (int i = 1; i < 16385; i++) {
            int x = i, ind = 14;
            while (x > 0) {
                bit[i][ind--] = x % 2;
                x >>= 1;
            }
            if (ind > -1) {
                bit[i][ind] = x;
            }
        }

        int[][] neighbor = new int[16385][15];
        int[] temp = new int[15];
        StringBuffer sb;
        for (int i = 0; i < 16385; i++) {
            for (int j = 14, x = 0; j >= 0; j--) {
                System.arraycopy(bit[i], 0, temp, 0, 15);
                if (bit[i][j] == 1) {
                    temp[j] = 0;
                } else {
                    temp[j] = 1;
                }
                sb = new StringBuffer();
                for (int k = 0; k < 15; k++) {
                    sb.append(temp[k]);
                }
                neighbor[i][14 - j] = Integer.parseInt(sb.toString(), 2);
            }
        }

        int max, n, total;
        int[] pont, arr;
        while ((line = br.readLine()) != null) {
            n = Integer.parseInt(line);
            total = (int) Math.pow(2, n);
            arr = new int[total];
            for (int i = 0; i < total; i++) {
                int x = Integer.parseInt(br.readLine());
                arr[i] = x;
            }

            pont = new int[total];
            for (int i = 0; i < total; i++) {
                for (int j = 0; j < n; j++) {
                    pont[i] += arr[neighbor[i][j]];
                }
            }

            max = 0;
            for (int i = 0; i < total; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, pont[i] + pont[neighbor[i][j]]);
                }
            }
            System.out.println(max);
        }
    }
}
