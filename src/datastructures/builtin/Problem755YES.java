package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Problem 755 - 487--3279
 * <p>
 * Given list of phone numbers in two forms (numbers and characters), each character mapped to a number. The problem ask
 * to output list of phone numbers in normal form (numbers) along with number of appearance, that appears more than once in the list.
 * <p>
 * The main problem is list of phone numbers could be up to 100k. We should use fastest input output method that available
 * in each programming language of our choice. For Java we could use <code>BufferedReader</code> and for C/C++ we could use
 * <code>scanf</code>.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem755YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 0, 7, 7, 8, 8, 8, 9, 9, 9, 0};
        String s;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < n; i++) {
                s = br.readLine();
                StringBuilder ret = new StringBuilder();
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (c == '-') {
                        continue;
                    }
                    if (c >= '0' && c <= '9') {
                        ret.append(c);
                    } else {
                        ret.append(arr[c - 'A']);
                    }
                    count++;
                    if (count == 3) {
                        ret.append("-");
                    }
                }
                String x = ret.toString();
                if (!map.containsKey(x)) {
                    map.put(x, 1);
                } else {
                    map.put(x, map.get(x) + 1);
                }
            }
            if (map.size() == n) {
                System.out.println("No duplicates.");
            } else {
                Set<String> set = map.keySet();
                Map<String, Integer> sMap = new TreeMap<String, Integer>();
                for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
                    String i = it.next();
                    int x = map.get(i);
                    if (x > 1) {
                        sMap.put(i, x);
                    }
                }
                for (Map.Entry<String, Integer> i : sMap.entrySet()) {
                    System.out.println(i.getKey() + " " + i.getValue());
                }
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
