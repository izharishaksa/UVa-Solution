package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ID Codes.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem146YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("#")) {
                break;
            }
            boolean ada = false;
            int[] arr = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                arr[i] = line.charAt(i) - 'a';
            }
            while (nextPermutation(arr)) {
                ada = true;
                for (int i = 0; i < arr.length; i++) {
                    System.out.print((char) (arr[i] + 'a'));
                }
                System.out.println();
                break;
            }
            if (!ada) {
                System.out.println("No Successor");
            }
        }
    }

    static boolean nextPermutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a) {
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1; ; --b) {
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
