package mathematics.biginteger;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem1210YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> prime = new ArrayList<Integer>();
        prime.add(2);
        prime.add(3);
        int[] temp = new int[10001];
        for (int i = 4; i <= 10000; i++) {
            boolean p = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    p = false;
                    break;
                }
            }
            if (p) {
                prime.add(i);
            }
        }
        for (int i = 0; i < prime.size(); i++) {
            int tot = 0;
            for (int j = i; j < prime.size(); j++) {
                tot += prime.get(j);
                if (tot > 10000) {
                    break;
                }
                temp[tot]++;
            }
        }
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(temp[n]);
        }
    }
}