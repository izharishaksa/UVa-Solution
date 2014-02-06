package problemsolvingparadigms.dynamicprogramming;

import java.util.*;

/**
 * Dollars.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem147 {

    static int[] res;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
        res = new int[30001];
        res[5] = 1;
        for (int i = 10; i <= 30000; i += 5) {
            
        }
        int n;
        while (sc.hasNext()) {
            n = (int) (Double.parseDouble(sc.next()) * 100);
            if (n == 0) {
                break;
            }
            System.out.println(res[n]);
        }
    }
}
