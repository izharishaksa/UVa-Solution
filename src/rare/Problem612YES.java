package rare;

import java.util.Scanner;

/**
 * DNA Sorting.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem612YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), m = sc.nextInt();
            String h = sc.nextLine();
            String[] temp = new String[m];
            int[] dis = new int[m];
            for (int i = 0; i < m; i++) {
                temp[i] = sc.nextLine();
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (temp[i].charAt(j) > temp[i].charAt(k)) {
                            dis[i]++;
                        }
                    }
                }
            }
            do {
                int min = 10000;
                int i = 0, pos = 0;
                for (i = 0; i < m; i++) {
                    if (dis[i] < min) {
                        pos = i;
                        min = dis[i];
                    }
                }
                dis[pos] = 10000;
                if (min == 10000) {
                    break;
                }
                System.out.println(temp[pos]);
            } while (true);
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
}
