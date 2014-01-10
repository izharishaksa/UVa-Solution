package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Pasti Pas! (ICPC2013 Jakarta).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem6439 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            String s = br.readLine();
            int i = 0, j = s.length() - 1, ret = 0, x = 2147483647;
            long L = 0, R = 0, P = 1;
            while (i <= j) {
                L = L * P + (s.charAt(i) - 'A' + 1);
                R = R + (s.charAt(j) - 'A' + 1) * P;
                L %= x;
                R %= x;
                P = P * x;
                P %= x;
                if (L == R && i <= j) {
                    ret += 2;
                    L = 0;
                    R = 0;
                    P = 1;
                }
                i++;
                j--;
            }
            if (L != 0) {
                ret++;
            }
            System.out.println("Case #" + t + ": " + ret);
        }
    }
}