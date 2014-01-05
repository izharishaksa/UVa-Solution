package others;

import java.util.*;

/**
 * Jolly Jumpers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10038YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean[] temp = new boolean[n];
            for (int i = 1; i < n; i++) {
                try {
                    temp[Math.abs(arr[i] - arr[i - 1])] = true;
                } catch (Exception e) {
                }
            }
            boolean ada = false;
            for (int i = 1; i < temp.length; i++) {
                if (!temp[i]) {
                    ada = true;
                    break;
                }
            }
            if (!ada) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}
