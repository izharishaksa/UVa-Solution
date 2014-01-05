package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Conformity.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11286YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if (n == 0) {
                break;
            }
            HashMap<Courses, Integer> map = new HashMap<Courses, Integer>();
            int max = 1;
            for (int i = 0; i < n; i++) {
                int[] arr = new int[5];
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    arr[j] = Integer.parseInt(temp[j]);
                }
                Courses c = new Courses(arr);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    max = Math.max(max, map.get(c));
                } else {
                    map.put(c, 1);
                }
            }
            int res = 0;
            for (Map.Entry<Courses, Integer> i : map.entrySet()) {
                int x = i.getValue();
                if (x == max) {
                    res += x;
                }
            }
            System.out.println(res);
        }
    }

    static class Courses {

        int[] arr;
        int id = 0;

        public Courses(int[] arr) {
            this.arr = arr;
            Arrays.sort(arr);
            for (int i = 0; i < 5; i++) {
                id += arr[i] << 1;
            }
        }

        @Override
        public boolean equals(Object o) {
            Courses obj = (Courses) o;
            for (int i = 0; i < 5; i++) {
                if (arr[i] != obj.arr[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}