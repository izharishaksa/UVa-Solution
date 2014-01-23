package series2014.datastructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Good Teacher.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12662YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] students = br.readLine().split(" ");
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int P = Integer.parseInt(br.readLine());
            P--;
            if (!students[P].equals("?")) {
                System.out.println(students[P]);
                continue;
            }
            String kanan = "";
            int nKanan = 0;
            for (int j = P - 1; j >= 0; j--) {
                nKanan++;
                if (!students[j].equals("?")) {
                    kanan = students[j];
                    break;
                }
            }
            if (kanan.equals("")) {
                nKanan = 105;
            }
            String kiri = "";
            int nKiri = 0;
            for (int j = P + 1; j < N; j++) {
                nKiri++;
                if (!students[j].equals("?")) {
                    kiri = students[j];
                    break;
                }
            }
            if (kiri.equals("")) {
                nKiri = 105;
            }
            if (nKiri == nKanan) {
                System.out.println("middle of " + kanan + " and " + kiri);
            } else if ((kiri.equals("") && !kanan.equals("")) || (nKanan < nKiri)) {
                for (int j = 0; j < nKanan; j++) {
                    System.out.print("right of ");
                }
                System.out.println(kanan);
            } else if ((!kiri.equals("") && kanan.equals("")) || (nKiri < nKanan)) {
                for (int j = 0; j < nKiri; j++) {
                    System.out.print("left of ");
                }
                System.out.println(kiri);
            }
        }
    }
}
