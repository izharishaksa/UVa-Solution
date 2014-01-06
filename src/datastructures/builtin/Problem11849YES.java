package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * CD.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11849YES {

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
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(br.readLine());
                set.add(x);
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(br.readLine());
                if (set.contains(x)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
