package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Word Index.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem417YES {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        int ind = 1;
        List<String> dp = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            Queue<String> cur = new ArrayDeque<String>();
            for (int j = 0; j < dp.size(); j++) {
                cur.add(dp.get(j));
            }
            dp = new ArrayList<String>();
            if (cur.isEmpty()) {
                cur.offer("");
            }
            while (!cur.isEmpty()) {
                String a = cur.poll();
                if (a.length() == i) {
                    temp.put(a, ind++);
                    dp.add(a);
                } else {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (a.length() > 0) {
                            if (j > a.charAt(a.length() - 1)) {
                                cur.add(a + j + "");
                            }
                        } else {
                            cur.add(j + "");
                        }
                    }
                }
            }
        }
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (temp.containsKey(s)) {
                System.out.println(temp.get(s));
            } else {
                System.out.println("0");
            }
        }
    }
}
