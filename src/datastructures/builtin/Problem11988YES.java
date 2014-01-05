package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Broken Keyboard (a.k.a Beiju Text).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11988YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            boolean home = false;
            StringBuilder cur = new StringBuilder();
            LinkedList<StringBuilder> list = new LinkedList<StringBuilder>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    if (home) {
                        list.addFirst(cur);
                    } else {
                        list.addLast(cur);
                    }
                    cur = new StringBuilder();
                    home = true;
                } else if (c == ']') {
                    if (home) {
                        list.addFirst(cur);
                    } else {
                        list.addLast(cur);
                    }
                    cur = new StringBuilder();
                    home = false;
                } else {
                    cur.append(c);
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
            System.out.println(res);
        }
    }
}
