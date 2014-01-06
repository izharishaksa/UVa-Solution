package mathematics.adhoc;

import java.util.Scanner;

/**
 * Digit Counting.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1225YES {
    
    public static void main(String[] args) {
        int[][] arr = new int[10000][10];
        for (int i = 1; i < 10000; i++) {
            System.arraycopy(arr[i - 1], 0, arr[i], 0, 10);
            int x = i;
            while (x > 0) {
                arr[i][x % 10]++;
                x /= 10;
            }
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[N][j]);
                if (j < 9) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
}
