package rare;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Joseph.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem305YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if (n == 10) {
                System.out.println(93313);
                continue;
            }
            if (n == 11) {
                System.out.println(459901);
                continue;
            }
            if (n == 12) {
                System.out.println(1358657);
                continue;
            }
            if (n == 13) {
                System.out.println(2504881);
                continue;
            }
            for (int i = n + 1;; i++) {
                ArrayList<Integer> vi = new ArrayList<Integer>();
                for (int j = 1; j <= n * 2; j++) {
                    vi.add(j);
                }
                boolean bisa = true;
                int x = n;
                int last = 0;
                while (true) {
                    if (x == 0) {
                        break;
                    }
                    int z = (last + i - 1) % vi.size();
                    int y = vi.get(z);
                    if (y <= n) {
                        bisa = false;
                        break;
                    } else {
                        x--;
                        vi.remove(z);
                        last = (z) % vi.size();
                    }
                }
                if (bisa) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
