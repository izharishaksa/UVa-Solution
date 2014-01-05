package problemsolvingparadigms.completesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Expert Enough?
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1237YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] name = new String[N];
            int[] lowest = new int[N];
            int[] highest = new int[N];
            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().split(" ");
                name[i] = temp[0];
                lowest[i] = Integer.parseInt(temp[1]);
                highest[i] = Integer.parseInt(temp[2]);
            }
            int Q = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < Q; i++) {
                int P = Integer.parseInt(br.readLine().trim());
                int count = 0;
                String ret = "";
                for (int j = 0; j < N; j++) {
                    if (P >= lowest[j] && P <= highest[j]) {
                        ret = name[j];
                        count++;
                    }
                }
                if (count == 1) {
                    System.out.println(ret);
                } else {
                    System.out.println("UNDETERMINED");
                }
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
