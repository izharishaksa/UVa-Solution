package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Broken Keyboard (a.k.a Beiju Text).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11988YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s;
        boolean home;
        char[] c;
        StringBuilder cur;
        LinkedList<StringBuilder> list;
        while ((s = br.readLine()) != null) {
            home = false;
            cur = new StringBuilder();
            list = new LinkedList<StringBuilder>();
            c = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (c[i] == '[') {
                    if (home) {
                        list.addFirst(cur);
                    } else {
                        list.addLast(cur);
                    }
                    cur = new StringBuilder();
                    home = true;
                } else if (c[i] == ']') {
                    if (home) {
                        list.addFirst(cur);
                    } else {
                        list.addLast(cur);
                    }
                    cur = new StringBuilder();
                    home = false;
                } else {
                    cur.append(c[i]);
                }
            }
            if (home) {
                list.addFirst(cur);
            } else {
                list.addLast(cur);
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder sb : list) {
                res.append(sb);
            }
            pw.println(res);
            pw.flush();
        }
        pw.close();
    }
}
