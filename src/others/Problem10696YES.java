package others;

import java.io.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10696YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = 0;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int m = n;
            if (n > 100) n -= 10;
            else n = 91;
            //System.out.println("f91(" + m + ") = " + n);
            pw.println("f91(" + m + ") = " + n);
        }
        pw.flush();
        pw.close();
    }

}
