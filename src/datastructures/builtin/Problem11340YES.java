package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Newspaper.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11340YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
            for (int i = 0; i <= 255; i++) {
                map.put((byte) i, 0);
            }
            String s;
            for (int i = 0; i < K; i++) {
                s = br.readLine();
                map.put((byte) s.charAt(0), Integer.parseInt(s.substring(2)));
            }
            int n = Integer.parseInt(br.readLine());
            double ans = 0;
            byte x;
            for (int i = 0; i < n; i++) {
                while ((x = (byte) br.read()) != '\n') {
                    ans += map.get(x);
                }
            }
            System.out.format("%.2f$\n", ans / 100);
        }
    }

}
