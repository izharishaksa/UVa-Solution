package introduction;

import java.util.*;

/**
 * Find the Telephone.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10921YES {

    public static void main(String[] args) {
        String[] arr = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0' || c == '1' || c == '-') {
                    ans += c;
                    continue;
                }
                for (int j = 2; j < arr.length; j++) {
                    if (arr[j].indexOf(c) >= 0) {
                        ans += (char) (j + '0');
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
