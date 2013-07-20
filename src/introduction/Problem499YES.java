package introduction;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem499YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int[] arr = new int[52];
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    arr[c - 'A']++;
                }
                if (c >= 'a' && c <= 'z') {
                    arr[(c - 'a') + 26]++;
                }
            }
            for (int i = 0; i < 52; i++)
                max = Math.max(max, arr[i]);
            for (int i = 0; i < 52; i++)
                if (arr[i] == max) {
                    if (i < 26)
                        System.out.print((char) (i + 'A'));
                    else
                        System.out.print((char) (i + 'a' - 26));
                }
            System.out.println(" " + max);
        }
    }

}
