package introduction;

import java.util.*;

/**
 * Kindergarten Counting Game.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem494YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine().toLowerCase();
            int res = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    count++;
                } else {
                    if (count > 0) res++;
                    count = 0;
                }
            }
            if (count > 0) res++;
            System.out.println(res);
        }
    }

}
