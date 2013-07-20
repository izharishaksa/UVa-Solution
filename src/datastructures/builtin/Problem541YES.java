package datastructures.builtin;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem541YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[][] arr = new int[n][n];
            int[] row = new int[n];
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    row[i] += arr[i][j];
                    col[j] += arr[i][j];
                }
            }
            int count = 0;
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] % 2 == 1 && col[j] % 2 == 1) {
                        row[i]--;
                        col[j]--;
                        x = i + 1;
                        y = j + 1;
                        count++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (row[i] % 2 == 1 || col[i] % 2 == 1) {
                    count = 10;
                }
            }
            if (count == 0) {
                System.out.println("OK");
            } else if (count == 1) {
                System.out.println("Change bit (" + x + "," + y + ")");
            } else {
                System.out.println("Corrupt");
            }
        }
    }
    
}
