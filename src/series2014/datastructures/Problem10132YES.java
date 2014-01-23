package series2014.datastructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * File Fragmentation.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10132YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int TC = Integer.parseInt(br.readLine());
        String line = br.readLine();
        for (int T = 0; T < TC; T++) {
            List<String> fragments = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    break;
                }
                fragments.add(line);
            }
            TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            int N = fragments.size();
            for (int i = 0; i < N; i++) {
                String a = fragments.get(i);
                for (int j = i + 1; j < N; j++) {
                    String b = fragments.get(j);
                    String c = a + b;
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                    c = b + a;
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
            int max = 0;
            String result = null;
            for (Map.Entry<String, Integer> i : map.entrySet()) {
                if (i.getValue() > max) {
                    max = i.getValue();
                    result = i.getKey();
                }
            }
            pw.println(result);
            if (T < TC - 1) {
                pw.println();
            }
            pw.flush();
        }
        pw.close();
        br.close();
    }
}
