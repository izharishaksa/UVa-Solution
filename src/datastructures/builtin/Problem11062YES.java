package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 * Andy's Second Dictionary.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11062YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<String>();
        while ((line = br.readLine()) != null) {
            if (line.length() == 0) {
                continue;
            }
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '-' && i < line.length() - 1)) {
                    sb.append(c);
                } else if (sb.length() > 0 && c != '-') {
                    set.add(sb.toString().toLowerCase());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 0 && line.charAt(line.length() - 1) != '-') {
                set.add(sb.toString().toLowerCase());
                sb = new StringBuilder();
            }
        }
        for (String s : set) {
            pw.println(s);
        }
        pw.flush();
        pw.close();
        br.close();
    }
}
