package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem414YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            String s = sc.nextLine();
            int[] temp = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                s = sc.nextLine();
                int tot = 0;
                for (int j = 0; j < 25; j++) {
                    if (s.charAt(j) == 'X') {
                        tot++;
                    }
                }
                temp[i] = tot;
                max = Math.max(max, tot);
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {
                ret += max - temp[i];
            }
            System.out.println(ret);
        }
    }
}
