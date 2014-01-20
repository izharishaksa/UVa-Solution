package datastructures.builtin;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Ferry Loading III.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10901YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while (C-- > 0) {
            int N = sc.nextInt();
            int T = sc.nextInt();
            int M = sc.nextInt();
            Queue<Car> q = new ArrayDeque<Car>();
            for (int i = 0; i < M; i++) {
                int t = sc.nextInt();
                String bank = sc.next();
                q.add(new Car(i, t, bank));
            }
            boolean left = true;
            int curTime = 0;
            int[] res = new int[M];
            while (!q.isEmpty()) {
                Car car = q.peek();
                int x = car.time;
                if (car.bank == left) {
                    int nLoad = 0;
                    Queue<Car> q2 = new ArrayDeque<Car>();
                    while (!q.isEmpty()) {
                        car = q.poll();
                        if (car.time <= curTime && car.bank == left && nLoad < N) {
                            res[car.id] = curTime + T;
                            nLoad++;
                        } else {
                            q2.add(car);
                        }
                    }
                    q.addAll(q2);
                    if (nLoad > 0) {
                        left = !left;
                        curTime += T;
                    } else {
                        curTime = x;
                    }
                } else {
                    int nLoad = 0;
                    Queue<Car> q2 = new ArrayDeque<Car>();
                    while (!q.isEmpty()) {
                        car = q.poll();
                        if (car.time <= curTime && car.bank == left && nLoad < N) {
                            res[car.id] = curTime + T;
                            nLoad++;
                        } else {
                            q2.add(car);
                        }
                    }
                    q.addAll(q2);
                    left = !left;
                    if (x > curTime) {
                        x -= curTime;
                    } else {
                        x = 0;
                    }
                    curTime += x + T;
                }
            }
            for (int i = 0; i < M; i++) {
                System.out.println(res[i]);
            }
            if (C > 0) {
                System.out.println();
            }
        }
    }

    static class Car {

        int time, id;
        boolean bank;

        public Car(int id, int time, String bank) {
            this.id = id;
            this.time = time;
            this.bank = bank.equals("left") ? true : false;
        }
    }
}
