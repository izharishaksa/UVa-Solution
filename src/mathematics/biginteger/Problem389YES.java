package mathematics.biginteger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Basically Speaking.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem389YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            String n = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(n, a);
            String ret = Long.toString(x, b).toUpperCase();
            if (ret.length() > 7) {
                System.out.println("  ERROR");
            } else {
                for (int i = 0; i < 7 - ret.length(); i++) {
                    System.out.print(" ");
                }
                System.out.println(ret);
            }
        }
    }
}
