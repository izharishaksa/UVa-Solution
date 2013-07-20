package mathematics.sequencenumbersystem;

import java.util.*;
/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem686YES {

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 2; i < 32768; i++) {
            if (isPrime(i))
                temp.add(i);
        }
        int[] prime = new int[temp.size()];
        for (int i = 0; i < prime.length; i++)
            prime[i] = temp.get(i);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int ret = 0;
            for (int i = 0; i < prime.length; i++) {
                for (int j = i; j < prime.length; j++)
                    if (prime[i] + prime[j] == n)
                        ret++;
            }
            System.out.println(ret);
        }
    }

}
