package mathematics.factorial;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Factorial Factors.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem884YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] factor = new int[1000001];
        Arrays.fill(factor, 1);
        for (int i = 2; i < 1000000; i++) {
            for (int j = 2; j <= i; j++) {
                try {
                    factor[j * i] = factor[i] + factor[j];
                } catch (Exception e) {
                    break;
                }
            }
        }
        for (int i = 3; i <= 1000000; i++) {
            factor[i] += factor[i - 1];
        }
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(factor[n]);
        }
    }
}
