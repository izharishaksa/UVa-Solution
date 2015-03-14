package problemsolvingparadigms.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Maximum Sum (II).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10656YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                if (x > 0) {
                    list.add(x);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                System.out.print(x);
                if (i < list.size() - 1) {
                    System.out.print(" ");
                }
            }
            if (list.isEmpty()) {
                System.out.print(0);
            }
            System.out.println();
        }
    }
}
