package stringprocessing.adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem444YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            try {
                if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                    s = new StringBuilder(s).reverse().toString();
                    for (int i = 0; i < s.length();) {
                        String ss = "";
                        if (s.charAt(i) == '1') {
                            sb.append((char) Integer.parseInt(s.substring(i, i + 3)));
                            i += 3;
                        } else {
                            sb.append((char) Integer.parseInt(s.substring(i, i + 2)));
                            i += 2;
                        }
                    }
                } else {
                    for (int i = s.length() - 1; i >= 0; i--) {
                        int c = s.charAt(i);
                        sb.append(new StringBuilder(c + "").reverse());
                    }
                }
                System.out.println(sb);
            } catch (Exception e) {
                System.out.println();
            }
        }
    }
}
