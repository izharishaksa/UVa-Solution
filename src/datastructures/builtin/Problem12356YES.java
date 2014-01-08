package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Army Buddies.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12356YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        String line;
        int[] LL = new int[100005];
        int[] RR = new int[100005];
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int S = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if (S == 0 && R == 0) {
                break;
            }
            for (int i = 1; i <= S; i++) {
                LL[i] = i - 1;
                RR[i] = i + 1;
            }
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (LL[a] == 0 | LL[b] < 1) {
                    pw.print("* ");
                } else {
                    pw.print(LL[a] + " ");
                }
                if (RR[b] == 0 || RR[b] > S) {
                    pw.print("*\n");
                } else {
                    pw.print(RR[b] + "\n");
                }
                LL[RR[b]] = LL[a];
                RR[LL[a]] = RR[b];
            }
            pw.print("-\n");
        }
        br.close();
        pw.close();
    }
}
