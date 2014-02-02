package series2014.problemsolvingparadigms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Bob's Beautiful Balls.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12337YES {

    static class Dimension implements Comparable<Dimension> {

        int x, y;

        public Dimension(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Dimension o) {
            return (x + y) - (o.x + o.y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int T = 1; T <= TC; T++) {
            char[] s = br.readLine().toCharArray();
            int size = s.length;
            List<Dimension> list = new ArrayList<Dimension>();
            for (int i = 2; i < size; i++) {
                for (int j = 2; j < size; j++) {
                    if (i * j == size) {
                        list.add(new Dimension(i, j));
                    }
                }
            }
            Collections.sort(list);
            boolean ok = false;
            System.out.print("Case " + T + ": ");
            for (Dimension d : list) {
                int x = d.x;
                int y = d.y;
                int count = 0, face = 1, curX = 0, curY = 0;
                char[][] c = new char[x][y];
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        c[i][j] = ' ';
                    }
                }
                while (count != size) {
                    if (face == 0) {
                        if (curX < x && c[curX][curY] == ' ') {
                            c[curX++][curY] = s[count++];
                        } else {
                            face = 1;
                            curX--;
                            curY++;
                        }
                    } else if (face == 1) {
                        if (curY < y && c[curX][curY] == ' ') {
                            c[curX][curY++] = s[count++];
                        } else {
                            face = 2;
                            curY--;
                            curX--;
                        }
                    } else if (face == 2) {
                        if (curX >= 0 && c[curX][curY] == ' ') {
                            c[curX--][curY] = s[count++];
                        } else {
                            face = 3;
                            curX++;
                            curY--;
                        }
                    } else {
                        if (curY >= 0 && c[curX][curY] == ' ') {
                            c[curX][curY--] = s[count++];
                        } else {
                            face = 0;
                            curY++;
                            curX++;
                        }
                    }
                }
                ok = true;
                for (int i = 0; i < y && ok; i++) {
                    for (int j = 1; j < x && ok; j++) {
                        if (c[j][i] != c[j - 1][i]) {
                            ok = false;
                        }
                    }
                }
                if (ok) {
                    System.out.println(x + y);
                    break;
                }
            }
            if (!ok) {
                System.out.println(-1);
            }
        }
    }
}
