package mathematics.adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Numbering Roads.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11723YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int T = 1;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s, " ");
            int R = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (R == 0) {
                break;
            }
            System.out.print("Case " + T + ": ");
            if (N * 26 < R - N) {
                System.out.print("impossible\n");
            } else if (N >= R) {
                System.out.print("0\n");
            } else {
                int x = R - N;
                R -= N;
                int min = x / N;
                min += x % N > 0 ? 1 : 0;
                System.out.print(min + "\n");
            }
            T++;
        }
    }
}
