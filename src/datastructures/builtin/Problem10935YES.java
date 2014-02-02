package datastructures.builtin;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Throwing Cards Away I.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10935YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            Queue<Integer> q = new ArrayDeque<Integer>();
            for (int i = 1; i <= N; i++) {
                q.add(i);
            }
            Queue<Integer> q2 = new ArrayDeque<Integer>();
            int last = 0;
            while (!q.isEmpty()) {
                int x = q.poll();
                if (q.isEmpty()) {
                    last = x;
                } else {
                    q2.offer(x);
                    x = q.poll();
                    q.add(x);
                }
            }
            System.out.print("Discarded cards:");
            boolean first = true;
            while (!q2.isEmpty()) {
                if (first) {
                    System.out.print(" ");
                    first = false;
                }
                int x = q2.poll();
                System.out.print(x);
                if (!q2.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println("\nRemaining card: " + last);
        }
    }
}
