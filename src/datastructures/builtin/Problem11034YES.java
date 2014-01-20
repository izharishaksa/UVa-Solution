package datastructures.builtin;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Ferry Loading IV.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11034YES {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while (TC-- > 0) {
            int l = sc.nextInt();
            l *= 100;
            int m = sc.nextInt();
            Queue<Car> q = new ArrayDeque<Car>();
            for (int i = 0; i < m; i++) {
                Car c = new Car(sc.nextInt(), sc.next());
                q.add(c);
            }
            int ret = 0;
            boolean left = true;
            while (!q.isEmpty()) {
                Queue<Car> temp = new ArrayDeque<Car>();
                int t = 0;
                boolean bisa = true;
                while (!q.isEmpty()) {
                    Car c = q.poll();
                    if (c.left == left) {
                        if (bisa && t + c.l <= l) {
                            t += c.l;
                        } else {
                            bisa = false;
                            temp.add(c);
                        }
                    } else {
                        temp.add(c);
                    }
                }
                left = !left;
                ret++;
                q.addAll(temp);
            }
            System.out.println(ret);
        }
    }
    
    static class Car {
        
        int l;
        boolean left;
        
        public Car(int l, String bank) {
            this.l = l;
            this.left = bank.equals("left") ? true : false;
        }
    }
}
