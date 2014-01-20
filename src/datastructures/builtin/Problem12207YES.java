package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * That is Your Queue.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12207YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int ind = 1;
        while ((s = br.readLine()) != null) {
            if (s.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            System.out.println("Case " + (ind++) + ":");
            Queue<Integer> q = new ArrayDeque<Integer>();
            if (p > 1000) {
                p = 1000;
            }
            for (int i = 1; i <= p; i++) {
                q.offer(i);
            }
            String[] temp;
            for (int i = 0; i < c; i++) {
                s = br.readLine();
                temp = s.split(" ");
                if (temp.length == 1) {
                    int x = q.poll();
                    System.out.println(x);
                    q.offer(x);
                } else {
                    int x = Integer.parseInt(temp[1]);
                    Integer[] qq = q.toArray(new Integer[0]);
                    q.clear();
                    q.offer(x);
                    for (int j : qq) {
                        if (j != x) {
                            q.offer(j);
                        }
                    }
                }
            }
        }
    }
}
