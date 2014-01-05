package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hardwood Species.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10226YES {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        br.readLine();
        for (int t = 0; t < T; t++) {
            Map<String, Integer> map = new TreeMap<String, Integer>();
            String s;
            int count = 0;
            while ((s = br.readLine()) != null) {
                if (s.equals("")) {
                    break;
                }
                if (map.containsKey(s)) {
                    int x = map.get(s);
                    map.put(s, x + 1);
                } else {
                    map.put(s, 1);
                }
                count++;
            }
            for (Map.Entry<String, Integer> i : map.entrySet()) {
                System.out.printf("%s %.4f\n", i.getKey(), i.getValue() * 100.0 / count);
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
    }
    
}
