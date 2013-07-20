package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem755 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rep = "ABCDEFGHIJKLMNOPRSTUVWXY";
        String with = "222333444555666777888999";
        String s;
        int n = Integer.parseInt(br.readLine());
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            String ret = "";
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '-') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    ret += c;
                } else {
                    int x = rep.indexOf(c);
                    ret += with.charAt(x);
                }
            }
            temp[i] = ret.substring(0, 3) + "-" + ret.substring(3, ret.length());
        }
        int c = 1;
        Arrays.sort(temp);
        boolean ada = false;
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i].compareTo(temp[i + 1]) == 0) {
                c++;
            } else {
                if (c > 1) {
                    System.out.println(temp[i] + " " + c);
                    ada = true;
                }
                c = 1;
            }
        }
        if (c > 1) {
            System.out.println(temp[temp.length - 1] + " " + c);
            ada = true;
        }
        if (!ada) {
            System.out.println("No duplicates.");
        }
    }
}
