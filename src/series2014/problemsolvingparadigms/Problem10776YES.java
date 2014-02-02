package series2014.problemsolvingparadigms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Determine Combination.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10776YES {

    static int N, len;
    static PrintWriter pw;
    static char[] c;
    static boolean[] flag;

    final static void dfs(int pos, int l) {
        if (l == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (flag[i]) {
                    sb.append(c[i]);
                }
            }
            pw.println(sb);
            pw.flush();
        } else if (l + len - pos >= N) {
            for (int i = pos; i < len; i++) {
                flag[i] = true;
                dfs(i + 1, l + 1);
                flag[i] = false;
                while (i + 1 < len && c[i] == c[i + 1]) {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(" ");
            N = Integer.parseInt(temp[1]);
            c = temp[0].toCharArray();
            Arrays.sort(c);
            len = c.length;
            flag = new boolean[len];
            dfs(0, 0);
        }
        pw.close();
    }
}
