package problemsolvingparadigms.completesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * CD.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem624YES {

    static int max = 0;
    static List<Integer> result;

    static void dfs(int N, int[] arr, List<Integer> list, boolean[] added, int cur, int ind) {
        if (cur > max && cur <= N) {
            max = cur;
            result.clear();
            result.addAll(list);
        }
        if (cur < N) {
            for (int i = ind; i < arr.length; i++) {
                if (!added[i]) {
                    added[i] = true;
                    list.add(arr[i]);
                    dfs(N, arr, list, added, cur + arr[i], i);
                    added[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(" ");
            int N = Integer.parseInt(temp[0]);
            int[] arr = new int[Integer.parseInt(temp[1])];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(temp[i + 2]);
            }
            result = new ArrayList<Integer>();
            boolean[] added = new boolean[arr.length];
            max = 0;
            dfs(N, arr, new ArrayList<Integer>(), added, 0, 0);
            for (Integer i : result) {
                pw.print(i + " ");
            }
            pw.println("sum:" + max);
            pw.flush();
        }
        pw.close();
    }
}
