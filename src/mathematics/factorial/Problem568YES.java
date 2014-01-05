package mathematics.factorial;

import java.util.Scanner;

/**
 * Just the Facts.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem568YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10001];
        arr[0] = arr[1] = 1;
        int z = 1;
        for (int i = 2; i <= 10000; i++) {
            z *= i;
            while (z % 10 == 0) {
                z /= 10;
            }
            z = z % 100000;
            arr[i] = z % 10;
        }
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(addSpace(n) + " -> " + arr[n]);
        }
    }

    static String addSpace(int n) {
        String x = n + "";
        int len = x.length();
        for (int i = 0; i < 5 - len; i++) {
            x = " " + x;
        }
        return x;
    }
}
