package problemsolvingparadigms.completesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The Sultan's Successors.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem167YES {

    static BufferedReader br;
    static int max = 0;

    static boolean isPossible(int col, int[] used, int row) {
        used[col] = row;
        for (int i = col - 1; i >= 0; i--) {
            if (used[i] == row || (Math.abs(row - used[i]) == col - i)) {
                return false;
            }
        }
        return true;
    }

    static void backtrack(int[][] arr, int col, int[] used, int score) {
        if (col == 7) {
            max = Math.max(max, score);
        } else {
            for (int i = 0; i < 8; i++) {
                if (isPossible(col + 1, used, i)) {
                    used[col + 1] = i;
                    backtrack(arr, col + 1, used, score + arr[col + 1][i]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int[][] arr = new int[8][8];
            for (int i = 0; i < 8; i++) {
                String[] temp = br.readLine().trim().split("\\s+");
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }
            int[] used = new int[8];
            max = 0;
            backtrack(arr, -1, used, 0);
            System.out.print("  ");
            if (max < 100) {
                System.out.print(" ");
            }
            if (max < 10) {
                System.out.print(" ");
            }
            System.out.println(max);
        }
    }
}