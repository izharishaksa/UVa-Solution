package mathematics.primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10533 {

    static boolean isDigitPrime(int n) {
        int tot = 0;
        while (n > 10) {
            tot += (n % 10);
            n /= 10;
        }
        tot += n;
        for (int i = 2; i * i <= tot; i++) {
            if (tot % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[1000001];
        prime[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    prime[j] = true;
                }
                if (!isDigitPrime(i)) {
                    prime[i] = true;
                }
            }
        }
        for (int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int ret = 0;
            for (int i = n; i <= m; i++) {
                if (!prime[i]) {
                    //System.out.println(i);
                    ++ret;
                }
            }
            System.out.println(ret);
        }
    }

}
