package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Number Assignments. (ICPC2013 Jakarta).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem6434YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int t = 1; t <= TC; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("Case #" + t + ": ");
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            Arrays.sort(arr);
            int[] temp = new int[n - 1];
            for (int i = 1; i < n; i++) {
                temp[i - 1] = arr[i] - arr[i - 1];
            }
            boolean[] remove = new boolean[temp.length];
            for (int i = 0; i < m - 1; i++) {
                int ind = 0, max = 0;
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] >= max && !remove[j]) {
                        max = temp[j];
                        ind = j;
                    }
                }
                remove[ind] = true;
            }
            int ret = 0;
            for (int i = 0; i < temp.length; i++) {
                if (!remove[i]) {
                    ret += temp[i];
                }
            }
            System.out.println(ret);
        }
    }
}
