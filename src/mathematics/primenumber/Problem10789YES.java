package mathematics.primenumber;

import java.util.*;

/**
 * Prime Frequency.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10789YES {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int t = 1; t <= n; t++) {
            String s = sc.next();
            int[] arr = new int[62];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    arr[c - '0']++;
                } else if (c >= 'A' && c <= 'Z') {
                    arr[c - 'A' + 10]++;
                } else {
                    arr[c - 'a' + 36]++;
                }
            }
            String ret = "";
            for (int i = 0; i < 62; i++) {
                if (isPrime(arr[i])) {
                    ret += temp.charAt(i);
                }
            }
            if (ret.compareTo("") == 0) {
                System.out.println("Case " + t + ": empty");
            } else {
                System.out.println("Case " + t + ": " + ret);
            }
        }
    }
}
