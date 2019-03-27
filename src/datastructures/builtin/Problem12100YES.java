package datastructures.builtin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Printer Queue.
 * <p>
 * Given your printing position in a set of printing queue along with each priority, output when is your printing job will be finished.
 * <p>
 * We could just simulate the printing queue based on their position and priority, break the simulation when your printing job is done.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12100YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(), pos = sc.nextInt();
            List<Integer> vi = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                vi.add(sc.nextInt());
            }
            int tot = 0;
            while (true) {
                boolean ada = false;
                for (int j = 1; j < vi.size(); j++) {
                    if (vi.get(j) > vi.get(0)) {
                        ada = true;
                        break;
                    }
                }
                if (!ada) {
                    tot++;
                    vi.remove(0);
                } else {
                    int x = vi.get(0);
                    vi.remove(0);
                    vi.add(x);
                }
                if (pos == 0 && !ada) {
                    break;
                }
                pos--;
                if (pos < 0) {
                    pos = vi.size() - 1;
                }
            }
            System.out.println(tot);
        }
    }
}
