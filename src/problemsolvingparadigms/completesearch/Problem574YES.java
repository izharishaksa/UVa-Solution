package problemsolvingparadigms.completesearch;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Sum It Up.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem574YES {

    static PrintWriter pw;
    static HashMap<String, Boolean> map;
    static int total, n;
    static int[] arr;
    static boolean[] used;

    static void recurse(int curTotal, int pos, List<Integer> list) {
        if (curTotal == total) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append("+");
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), Boolean.TRUE);
                pw.println(sb.deleteCharAt(sb.length() - 1));
            }
        } else if (curTotal < total) {
            for (int i = pos + 1; i < n; i++) {
                if (!used[i] && curTotal + arr[i] <= total) {
                    used[i] = true;
                    list.add(arr[i]);
                    recurse(curTotal + arr[i], i, list);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        while (sc.hasNext()) {
            map = new HashMap<String, Boolean>();
            total = sc.nextInt();
            n = sc.nextInt();
            if (total == 0 && n == 0) {
                break;
            }
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            used = new boolean[n];
            pw.println("Sums of " + total + ":");
            recurse(0, -1, new ArrayList<Integer>());
            if (map.isEmpty()) {
                pw.println("NONE");
            }
            pw.flush();
        }
        pw.close();
    }
}
