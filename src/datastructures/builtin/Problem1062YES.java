package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Containers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1062YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = 1;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("end")) {
                break;
            }
            String[] arr = new String[26];
            Arrays.fill(arr, "");
            int len = line.length();
            for (int i = 0; i < len; i++) {
                boolean bisa = false;
                for (int j = 0; j < 26; j++) {
                    if (!arr[j].equals("") && arr[j].charAt(0) >= line.charAt(i)) {
                        bisa = true;
                        arr[j] = line.charAt(i) + arr[j];
                        break;
                    }
                }
                if (!bisa) {
                    for (int j = 0; j < 26; j++) {
                        if (arr[j].equals("")) {
                            arr[j] = line.charAt(i) + arr[j];
                            break;
                        }
                    }
                }
            }
            int ret = 0;
            for (int i = 0; i < 26; i++) {
                if (!arr[i].equals("")) {
                    ret++;
                }
            }
            pw.println("Case " + (T++) + ": " + ret);
            pw.flush();
        }
        pw.close();
    }
}
