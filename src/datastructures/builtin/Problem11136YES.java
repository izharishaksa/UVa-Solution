package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 * Hoax or What.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11136YES {

    static BufferedReader br;

    static int nextInt() throws Exception {
        int ret = 0, x;
        while (true) {
            x = br.read();
            if (x == 10 || x == 32 || x == -1) {
                return ret;
            }
            ret *= 10;
            ret += x - 48;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while (true) {
            int N = nextInt();
            if (N == 0) {
                break;
            }
            TreeSet<Integer> set = new TreeSet<Integer>();
            int[] arr = new int[1000001];
            long total = 0;
            for (int i = 0; i < N; i++) {
                int M = nextInt();
                for (int j = 0; j < M; j++) {
                    int x = nextInt();
                    arr[x]++;
                    set.add(x);
                }
                int a = set.first();
                int b = set.last();
                total += b - a;
                arr[a]--;
                arr[b]--;
                if (arr[a] == 0) {
                    set.remove(a);
                }
                if (arr[b] == 0) {
                    set.remove(b);
                }
            }
            pw.println(total);
            pw.flush();
        }
        pw.close();
    }
}
