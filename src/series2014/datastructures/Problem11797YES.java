package series2014.datastructures;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

/**
 * Drutojan Express.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11797YES {

    public static void main(String[] args) {
        HashMap<String, Integer> names = new HashMap<String, Integer>();
        names.put("Ja", 0);
        names.put("Sam", 1);
        names.put("Sha", 2);
        names.put("Sid", 3);
        names.put("Tan", 4);
        String[] namesArr = new String[]{"Ja", "Sam", "Sha", "Sid", "Tan"};
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int T = 1; T <= TC; T++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            String cur = sc.next();
            Queue<String>[] Q = new ArrayDeque[5];
            for (int i = 0; i < 5; i++) {
                int K = sc.nextInt();
                Q[i] = new ArrayDeque<String>();
                for (int j = 0; j < K; j++) {
                    Q[i].offer(sc.next());
                }
            }
            int[] result = new int[5];
            while (N > 0) {
                N -= M;
                if (N < 0) {
                    M += N;
                }
                N -= 2;
                int ind = names.get(cur);
                result[ind] += M;
                String x = Q[ind].poll();
                cur = x;
                Q[ind].offer(x);
            }
            System.out.println("Case " + T + ":");
            for (int i = 0; i < 5; i++) {
                System.out.println(namesArr[i] + " " + result[i]);
            }
        }
    }
}
