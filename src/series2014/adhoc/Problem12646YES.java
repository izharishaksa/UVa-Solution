package series2014.adhoc;

import java.util.Scanner;

/**
 * Zero or One.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12646YES {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if ((a == 1 && b == 0 && c == 0) || (a == 0 && b == 1 && c == 1)) {
                System.out.println("A");
            } else if ((b == 1 && a == 0 && c == 0) || (b == 0 && a == 1 && c == 1)) {
                System.out.println("B");
            } else if ((c == 1 && b == 0 && a == 0) || (c == 0 && b == 1 && a == 1)) {
                System.out.println("C");
            } else {
                System.out.println("*");
            }
        }
    }
    
}
