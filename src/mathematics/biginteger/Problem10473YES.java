package mathematics.biginteger;

import java.io.*;

/**
 * Simple Base Conversion.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10473YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            if (s.charAt(0) == '-') {
                break;
            }
            if (s.indexOf("x") >= 0) {
                System.out.println(Integer.parseInt(s.substring(2), 16));
            } else {
                System.out.println("0x" + Integer.toHexString(Integer.parseInt(s)).toUpperCase());
            }
        }
    }
}
