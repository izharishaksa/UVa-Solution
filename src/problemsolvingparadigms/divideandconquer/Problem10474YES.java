package problemsolvingparadigms.divideandconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Where is the Marble?
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10474YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        String s;
        while ((s = br.readLine()) != null) {
            String[] temp = s.split(" ");
            int N = Integer.parseInt(temp[0]);
            int Q = Integer.parseInt(temp[1]);
            if (N == 0 && Q == 0) {
                break;
            }
            int[] arr = new int[N];
            int[] count = new int[10001];
            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                count[arr[i]]++;
            }
            int[] index = new int[10001];
            int prev = count[0];
            for (int i = 1; i < 10001; i++) {
                if (count[i] > 0) {
                    index[i] += prev + 1;
                    prev += count[i];
                }
            }
            System.out.println("CASE# " + (T++) + ":");
            for (int i = 0; i < Q; i++) {
                int key = Integer.parseInt(br.readLine());
                if (index[key] > 0) {
                    System.out.println(key + " found at " + (index[key]));
                } else {
                    System.out.println(key + " not found");
                }
            }
        }
    }
}