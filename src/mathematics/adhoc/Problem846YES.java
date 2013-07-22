package mathematics.adhoc;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem846 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == b) {
                System.out.println(0);
            } else if (b - a == 1) {
                System.out.println(1);                
            } else {
                int total = 2;
                a++;
                b--;
                int len = b - a;
                total += Math.floor(Math.sqrt(len));
                total += len % 2;
                System.out.println(total);
            }
        }
    }
    
}
