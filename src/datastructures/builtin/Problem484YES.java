package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The Department of Redundancy Department.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem484YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String s;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        while ((s = br.readLine()) != null) {
            String[] line = s.split(" ");
            for (int i = 0; i < line.length; i++) {
                int x = Integer.parseInt(line[i]);
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    list.add(x);
                    map.put(x, 1);
                }
            }
        }
        for (int i : list) {
            int x = map.get(i);
            pw.println(i + " " + x);
        }
        pw.flush();
        pw.close();
    }
}
