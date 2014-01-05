package stringprocessing.adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Word-Search Wonder.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem422YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean[][] pakai = new boolean[n][n];
        while (true) {
            boolean finish = true;
            s = br.readLine();
            if (s.compareTo("0") == 0) {
                break;
            }
            boolean ketemu = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == s.charAt(0) && !pakai[i][j]) {
                        String[] temp = new String[8];
                        Arrays.fill(temp, map[i][j] + "");
                        int eI = i, eJ = j, c = -1;
                        for (int k = 1; k < s.length(); k++) {
                            for (int l = 0; l < 8; l++) {
                                int x = (dir[l][0] * k) + i, y = (dir[l][1] * k) + j;
                                if (x >= 0 && x < n && y >= 0 && y < n) {
                                    if (temp[l].length() < s.length()) {
                                        temp[l] += map[x][y];
                                    }
                                    if (temp[l].compareTo(s) == 0) {
                                        ketemu = true;
                                        c = l;
                                        eI = x + 1;
                                        eJ = y + 1;
                                        break;
                                    }
                                }
                            }
                        }
                        if (ketemu) {
                            System.out.println((i + 1) + "," + (j + 1) + " " + (eI) + "," + (eJ));
                        }
                    }
                    if (ketemu) {
                        break;
                    }
                }
                if (ketemu) {
                    break;
                }
            }
            if (!ketemu) {
                System.out.println("Not found");
            }
        }

    }
}
