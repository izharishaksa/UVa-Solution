package datastructures.builtin;

import java.util.Scanner;

/**
 * Multitasking.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11926YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n + m == 0) {
                break;
            }
            int[][] sch = new int[n + m][3];
            for (int i = 0; i < n; i++) {
                sch[i][0] = sc.nextInt();
                sch[i][1] = sc.nextInt();
            }
            for (int i = n; i < n + m; i++) {
                sch[i][0] = sc.nextInt();
                sch[i][1] = sc.nextInt();
                sch[i][2] = sc.nextInt();
            }
            boolean conflict = false;
            boolean[] arr = new boolean[1000001];
            for (int i = 0; i < n && !conflict; i++) {
                int a = sch[i][0];
                int b = sch[i][1];
                for (int j = a; j < b; j++) {
                    if (arr[j]) {
                        conflict = true;
                        break;
                    }
                    arr[j] = true;
                }
            }
            if (!conflict) {
                for (int i = n; i < n + m; i++) {
                    int a = sch[i][0];
                    int b = sch[i][1];
                    int c = sch[i][2];
                    while (a < 1000001) {
                        for (int j = a; j < b && j < 1000001; j++) {
                            if (arr[j]) {
                                conflict = true;
                                break;
                            }
                            arr[j] = true;
                        }
                        a += c;
                        b += c;
                    }
                }
            }
            if (conflict) {
                System.out.println("CONFLICT");
            } else {
                System.out.println("NO CONFLICT");
            }
        }
    }
}
