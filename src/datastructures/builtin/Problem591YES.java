package datastructures.builtin;

import java.util.Scanner;

/**
 * Box of Bricks.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem591YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ind = 1;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                total += arr[i];
            }
            int exp = total / n;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > exp) {
                    res += arr[i] - exp;
                }
            }
            System.out.println("Set #" + ind++);
            System.out.println("The minimum number of moves is " + res + ".\n");
        }
    }
    
}
