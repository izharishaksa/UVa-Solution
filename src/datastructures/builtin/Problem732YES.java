package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Anagrams by Stack.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem732YES {

    static boolean isGood(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] != bb[i]) {
                return false;
            }
        }
        return true;
    }

    static void dfs(StringBuilder input, String target, StringBuilder cur, StringBuilder stack, StringBuilder path, int n) {
        if (cur.toString().equals(target)) {
            System.out.println(path.toString().trim());
        } else {
            if (input.length() > 0) {
                char c = input.charAt(0);
                String x = path.toString();
                dfs(input.deleteCharAt(0), target, cur, stack.insert(0, c), path.append("i "), n + 1);
                input.insert(0, c);
                stack.deleteCharAt(0);
                path = new StringBuilder(x);
            }
            if (stack.length() > 0 && stack.charAt(0) == target.charAt(cur.length())) {
                char c = stack.charAt(0);
                String x = path.toString();
                dfs(input, target, cur.append(c), stack.deleteCharAt(0), path.append("o "), n + 1);
                cur.deleteCharAt(cur.length() - 1);
                stack.insert(0, c);
                path = new StringBuilder(x);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source;
        while ((source = br.readLine()) != null) {
            String target = br.readLine();
            System.out.println("[");
            if (source.length() == target.length() && isGood(source, target)) {
                dfs(new StringBuilder(source), target, new StringBuilder(), new StringBuilder(), new StringBuilder(), 0);
            }
            System.out.println("]");
        }
    }
}
