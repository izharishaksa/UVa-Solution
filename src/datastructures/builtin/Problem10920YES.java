package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Spiral Tap.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10920YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int S = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            if (S == 0 && P == 0) {
                break;
            }
            int ind = 1, cnt = 0, row = 0, col = 0;
            while (ind < P) {
                cnt++;
                if (ind + cnt >= P) {
                    row += P - ind;
                    break;
                }
                ind += cnt;
                row += cnt;
                if (ind + cnt >= P) {
                    col -= P - ind;
                    break;
                }
                ind += cnt;
                col -= cnt;
                cnt++;
                if (ind + cnt >= P) {
                    row -= P - ind;
                    break;
                }
                ind += cnt;
                row -= cnt;
                if (ind + cnt >= P) {
                    col += P - ind;
                    break;
                }
                ind += cnt;
                col += cnt;
            }
            S >>= 1;
            S++;
            System.out.println("Line = " + (S + row) + ", column = " + (S + col) + ".");
        }
    }
}
