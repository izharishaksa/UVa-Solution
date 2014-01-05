package problemsolvingparadigms.completesearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Back to the 8-Queens.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11085YES {

    public static void main(String[] args) {
        int[] pos = new int[8];
        Arrays.fill(pos, -1);
        LinkedList<int[]> sol = new LinkedList<int[]>();
        sol.add(pos);
        int ret = 1;
        int[][] solution = new int[92][8];
        int ind = 0;
        while (!sol.isEmpty()) {
            int[] cur = sol.poll();
            boolean ada = false;
            for (int i = 0; i < 8 && !ada; i++) {
                ada = cur[i] == -1 ? true : false;
            }
            if (!ada) {
                for (int i = 0; i < 8; i++) {
                    solution[ind][i] = cur[i] + 1;
                }
                ind++;
            } else {
                for (int i = 0; i < 8; i++) {
                    if (cur[i] == -1) {
                        for (int j = 0; j < 8; j++) {
                            boolean bisa = true;
                            for (int k = 0; k < 8; k++) {
                                int x = cur[k];
                                if (x == -1) {
                                    continue;
                                }
                                if (j == x) {
                                    bisa = false;
                                }
                                if (Math.abs(i - k) == Math.abs(j - x)) {
                                    bisa = false;
                                }
                            }
                            if (bisa) {
                                int[] temp = cur.clone();
                                temp[i] = j;
                                sol.add(temp);
                            }
                        }
                        break;
                    }
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        int cases = 1;
        while (sc.hasNext()) {
            pos = new int[8];
            for (int i = 0; i < 8; i++) {
                pos[i] = sc.nextInt();
            }
            int min = 8;
            for (int i = 0; i < solution.length; i++) {
                int cur = 0;
                for (int j = 0; j < 8; j++) {
                    if (solution[i][j] != pos[j]) {
                        cur++;
                    }
                }
                min = Math.min(min, cur);
            }
            System.out.println("Case " + cases + ": " + min);
            cases++;
        }
    }
}
