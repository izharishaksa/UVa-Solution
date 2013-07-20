package mathematics.numbertheory;

import java.util.*;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10235 {

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    static int rev(int n) {
        String v = n + "";
        String ret = "";
        for (int i = 0; i < v.length(); i++)
            ret = v.charAt(i) + ret;
        return Integer.parseInt(ret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (isPrime(n)) {
                if (isPrime(rev(n))) {
                    System.out.println(n + " is emirp.");
                } else {
                    System.out.println(n + " is prime.");
                }
            } else {
                System.out.println(n + " is not prime.");
            }
        }
    }

}
