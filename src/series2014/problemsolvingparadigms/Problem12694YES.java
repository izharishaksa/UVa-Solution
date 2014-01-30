package series2014.problemsolvingparadigms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Meeting Room Arrangement.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12694YES {

    static BufferedReader br;

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    static int readInt() throws Exception {
        int c = br.read();
        while (isWhitespace(c)) {
            c = br.read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = br.read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = br.read();
        } while (!isWhitespace(c));
        return res * sgn;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int TC = readInt();
        while (TC-- > 0) {
            List<Integer> s = new ArrayList<Integer>();
            List<Integer> f = new ArrayList<Integer>();
            while (true) {
                int ss = readInt();
                int ff = readInt();
                if (ss == 0 && ff == 0) {
                    break;
                }
                s.add(ss);
                f.add(ff);
            }
            boolean[] sudah = new boolean[s.size()];
            boolean bisa = true;
            int curTime = -1, total = 0;
            while (bisa) {
                int ind = -1, min = 11;
                bisa = false;
                for (int i = 0; i < s.size(); i++) {
                    if (f.get(i) < min && s.get(i) >= curTime && !sudah[i]) {
                        ind = i;
                        min = f.get(i);
                        bisa = true;
                    }
                }
                if (bisa) {
                    curTime = min;
                    sudah[ind] = true;
                    total++;
                }
            }
            System.out.println(total);
        }
    }
}
