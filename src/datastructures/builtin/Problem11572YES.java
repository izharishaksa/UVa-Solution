package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Unique Snowflakes.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11572YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int max = 0, count = 0, start = 0;
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                if (map.containsKey(x)) {
                    int pos = map.get(x);
                    if (pos >= start) {
                        start = pos + 1;
                    }
                    max = Math.max(max, i - start + 1);
                    map.put(x, i);
                } else {
                    map.put(x, i);
                    max = Math.max(max, i + 1 - start);
                }
            }
            System.out.println(max);
        }
    }
}
