package datastructures.builtin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Containers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1062 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("end")) {
                break;
            }
            String[] arr = new String[26];
            Arrays.fill(arr, "");
            for (int i = 0; i < s.length(); i++) {
                boolean bisa = false;
                for (int j = 0; j < 26; j++) {
                    if (!arr[j].equals("") && arr[j].charAt(0) >= s.charAt(i)) {
                        bisa = true;
                        arr[j] = s.charAt(i) + arr[j];
                        break;
                    }
                }
                if (!bisa) {
                    arr[s.charAt(i) - 'A'] = s.charAt(i) + arr[s.charAt(i) - 'A'];
                }
            }
            int ret = 0;
            for (int i = 0; i < 26; i++) {
                if (!arr[i].equals("")) {
                    ret++;
                }
            }
            System.out.println("Case " + (T++) + ": " + ret);
        }
    }
}
