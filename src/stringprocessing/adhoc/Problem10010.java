package stringprocessing.adhoc;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10010 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] map = new char[row][col];
            for (int i = 0; i < row; i++) {
                map[i] = sc.next().toCharArray();
            }
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                String s = sc.next();
            }
        }
    }
    
}
