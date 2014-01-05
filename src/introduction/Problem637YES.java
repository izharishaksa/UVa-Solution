package introduction;

import java.util.Scanner;

/**
 * Booklet Printing.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem637YES {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = 0, ind = 1;
        while (sc.hasNext()) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int tot = n / 4;
            if (n % 4 > 0) {
                tot++;
            }
            int[][] front = new int[tot][2];
            int[][] back = new int[tot][2];
            int akhir = 4 * tot;
            int awal = 1;
            for (int i = 0; i < front.length; i++) {
                front[i][0] = akhir--;
                front[i][1] = awal++;
                back[i][0] = awal++;
                back[i][1] = akhir--;
            }
            System.out.println("Printing order for " + n + " pages:");
            String kiri = "", kanan = "";
            for (int i = 0; i < front.length; i++) {
                if (front[i][0] > n) {
                    front[i][0] = 0;
                }
                if (front[i][1] > n) {
                    front[i][1] = 0;
                }
                if (back[i][0] > n) {
                    back[i][0] = 0;
                }
                if (back[i][1] > n) {
                    back[i][1] = 0;
                }
                if ((front[i][0] | front[i][1]) != 0) {
                    kiri = front[i][0] + "";
                    kanan = front[i][1] + "";
                    if (front[i][0] == 0) {
                        kiri = "Blank";
                    }
                    if (front[i][1] == 0) {
                        kanan = "Blank";
                    }
                    System.out.println("Sheet " + (i + 1) + ", front: " + kiri + ", " + kanan);
                } else {
                    break;
                }
                if ((back[i][0] | back[i][1]) != 0) {
                    kiri = back[i][0] + "";
                    kanan = back[i][1] + "";
                    if (back[i][0] == 0) {
                        kiri = "Blank";
                    }
                    if (back[i][1] == 0) {
                        kanan = "Blank";
                    }
                    System.out.println("Sheet " + (i + 1) + ", back : " + kiri + ", " + kanan);
                } else {
                    break;
                }
            }
        }
    }
}
