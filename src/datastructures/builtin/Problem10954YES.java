package datastructures.builtin;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Add All.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10954YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            PriorityQueue<Long> pq = new PriorityQueue<Long>();
            for (int i = 0; i < n; i++) {
                pq.offer(sc.nextLong());
            }
            long cost = 0;
            while (!pq.isEmpty() && n > 1) {
                long x = pq.poll() + pq.poll();
                cost += x;
                pq.offer(x);
                n--;
            }
            System.out.println(cost);
        }
    }
}
