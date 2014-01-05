package datastructures.builtin;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Sort! Sort!! and Sort!!!
 * 
 * @author Izhari Ishak Aksa
 */
public class Problem11321YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String s;
        while ((s = br.readLine()) != null) {
            String[] temp = s.split("[ ]");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            System.out.println(n + " " + m);
            if (n == 0 && m == 0) {
                break;
            }
            PriorityQueue<Number> arr = new PriorityQueue<Number>();
            for (int i = 0; i < n; i++) {
                int res = Integer.parseInt(br.readLine());
                Number x = new Number(res, res % m);
                arr.add(x);
            }
            while (!arr.isEmpty()) {
                pw.println(arr.poll().n);
            }
            pw.flush();
        }
        pw.close();
    }
}

class Number implements Comparable<Number> {

    public int n;
    private boolean even;
    private int val;

    public Number(int n, int val) {
        this.n = n;
        this.even = false;
        if (n % 2 == 0) {
            even = true;
        }
        this.val = val;
    }

    public int compareTo(Number o) {
        if (this.val < o.val) {
            return -1;
        } else if (this.val == o.val) {
            if (!this.even && o.even) {
                return -1;
            } else if (!this.even && !o.even) {
                if (this.n > o.n) {
                    return -1;
                }
            } else if (this.even && o.even) {
                if (this.n < o.n) {
                    return -1;
                }
            }
        }
        return 1;
    }
}