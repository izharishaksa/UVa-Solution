package datastructures.ownlib;

import java.util.Scanner;

/**
 * My Dear Neighbours.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10928YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while (TC-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            sc.nextLine();
            int min = N - 1;
            for (int i = 0; i < N; i++) {
                String[] temp = sc.nextLine().split(" ");
                arr[i] = temp.length;
                min = Math.min(min, arr[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (arr[i] == min) {
                    sb.append(i + 1).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
