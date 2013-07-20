package mathematics.primenumber;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem406YES {

    static boolean isPrime(int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), c = sc.nextInt();
            List<Integer> prime = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                if (isPrime(i)) {
                    prime.add(i);
                }
            }
            System.out.print(n + " " + c + ":");
            int aa = c * 2;
            int bb = c * 2 - 1;
            int size = prime.size();
            int start = 0;
            int len = 0;
            if (size % 2 == 0) {
                len = 2 * c;
                start = (size - len) / 2;
            } else {
                len = 2 * c - 1;
                start = (size - len) / 2;
            }
            if (len > size) {
                start = 0;
                len = size;
            }
            for (int i = start; i < start + len; i++) {
                System.out.print(" " + prime.get(i));
            }
            System.out.println("\n");
        }
    }
}
