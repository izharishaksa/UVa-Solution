package datastructures.builtin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Containers.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1062YES {

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
                    for (int j = 0; j < 26; j++) {
                        if (arr[j].equals("")) {
                            arr[j] = s.charAt(i) + arr[j];
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
            System.out.println("Case " + (T++) + ": " + ret);
        }
    }
}
