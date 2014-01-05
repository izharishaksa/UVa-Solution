package problemsolvingparadigms.completesearch;

import java.util.Scanner;

/**
 * Ecological Bin Packing.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem102YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] arr = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            //B G C
            int min = Integer.MAX_VALUE;
            String ret = "";
            int cur = arr[1][0] + arr[2][0] + arr[0][2] + arr[2][2] + arr[0][1] + arr[1][1];
            if (cur < min) {
                min = cur;
                ret = "BCG";
            }
            cur = arr[1][0] + arr[2][0] + arr[0][1] + arr[2][1] + arr[0][2] + arr[1][2];
            if (cur < min) {
                min = cur;
                ret = "BGC";
            }
            cur = arr[1][2] + arr[2][2] + arr[0][0] + arr[2][0] + arr[0][1] + arr[1][1];
            if (cur < min) {
                min = cur;
                ret = "CBG";
            }
            cur = arr[1][2] + arr[2][2] + arr[0][1] + arr[2][1] + arr[0][0] + arr[1][0];
            if (cur < min) {
                min = cur;
                ret = "CGB";
            }
            cur = arr[1][1] + arr[2][1] + arr[0][0] + arr[2][0] + arr[0][2] + arr[1][2];
            if (cur < min) {
                min = cur;
                ret = "GBC";
            }
            cur = arr[1][1] + arr[2][1] + arr[0][2] + arr[2][2] + arr[0][0] + arr[1][0];
            if (cur < min) {
                min = cur;
                ret = "GCB";
            }
            System.out.println(ret + " " + min);
        }
    }
}
