package graph.dfs;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem260 {

    public static void main(String[] args) {
        String s = "a";
        int i, j, k , len, tot = -1;
        String r = s;
        for (i = 0; i < s.length(); i++) {
            len = 0;
            for (j = i, k = 0; j < s.length(); j++, k++) {
                if (s.charAt(j) != r.charAt(k)) break;
                else len++;
            }
            if (len > tot) tot = len;
        }
        for (i = tot; i < s.length(); i++) {
            r += s.charAt(i);
        }
        System.out.println(r);

    }

}
