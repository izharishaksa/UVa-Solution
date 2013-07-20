package mathematics.combinatorics;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10450YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long[] fib = new long[52];
        fib[1] = 1;
        fib[0] = 1;
        for (int i = 2; i <= 51; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println("Scenario #" + (i + 1) + ":");
            System.out.println(fib[a + 1] + "\n");
        }
    }
}
