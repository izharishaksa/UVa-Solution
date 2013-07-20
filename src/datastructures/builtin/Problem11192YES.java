package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11192YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            String[] temp = s.split("[ ]");
            if (Integer.parseInt(temp[0]) == 0) {
                break;
            }
            int G = Integer.parseInt(temp[0]);
            StringBuilder sb = new StringBuilder();
            int len = temp[1].length() / G;
            for (int i = 0; i < temp[1].length(); i += len) {
                s = temp[1].substring(i, i + len);
                StringBuilder ss = new StringBuilder(s);
                ss = ss.reverse();
                sb.append(ss);
            }
            System.out.println(sb);
        }
    }
    
}
