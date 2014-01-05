package mathematics.biginteger;

import java.util.Scanner;

/**
 * Ternary.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11185YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 0) {
                break;
            }
            System.out.println(Integer.toString(n, 3));
        }
    }
    
}
