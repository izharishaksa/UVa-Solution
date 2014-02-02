package series2014.problemsolvingparadigms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Football.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12673YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        String[] in;
        while ((line = br.readLine()) != null) {
            in = line.split(" ");
            int N = Integer.parseInt(in[0]), G = Integer.parseInt(in[1]);
            int total = 0;
            int[] arr = new int[101];
            for (int i = 0; i < N; i++) {
                in = br.readLine().split(" ");
                int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]);
                if (a > b) {
                    total += 3;
                } else if (a == b) {
                    if (G > 0) {
                        G--;
                        total += 3;
                    } else {
                        arr[0]++;
                    }
                } else if (G > 0) {
                    arr[b - a]++;
                }
            }
            if (G > 0) {
                for (int i = 1; i <= 100 && G > 0; i++) {
                    if (arr[i] > 0) {
                        int x = G / (i + 1);
                        x = Math.min(x, arr[i]);
                        total += 3 * x;
                        G -= x * (i + 1);
                        arr[i] -= x;
                        if (arr[i] > 0 && G == i) {
                            total++;
                            G = 0;
                        }
                    }
                }
            } else {
                total += arr[0];
            }
            pw.println(total);
            pw.flush();
        }
        pw.close();
    }
}
