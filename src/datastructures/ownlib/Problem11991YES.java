package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Easy problem from Rujia Liu?
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11991YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        String[] temp;
        int N, M;
        List[] map = new ArrayList[1000001];
        for (int i = 0; i < 1000001; i++) {
            map[i] = new ArrayList();
        }
        while ((line = br.readLine()) != null) {
            temp = line.split(" ");
            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);
            for (int i = 1; i <= N; i++) {
                int A = 0, x;
                while (true) {
                    x = br.read();
                    if (x == 10 || x == 32) {
                        break;
                    }
                    A *= 10;
                    A += (x - 48);
                }
                map[A].add(i);
            }
            for (int i = 0; i < M; i++) {
                int x;
                int K = 0;
                int V = 0;
                while (true) {
                    x = br.read();
                    if (x == 10 || x == 32) {
                        break;
                    }
                    K *= 10;
                    K += (x - 48);
                }
                while (true) {
                    x = br.read();
                    if (x == 10 || x == 32) {
                        break;
                    }
                    V *= 10;
                    V += (x - 48);
                }
                if (map[V].size() >= K) {
                    pw.write(map[V].get(K - 1) + "\n");
                } else {
                    pw.write("0\n");
                }
            }
            pw.flush();
        }
        pw.close();
    }
}
