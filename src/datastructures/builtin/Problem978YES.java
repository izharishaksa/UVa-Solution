package datastructures.builtin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Lemmings Battle!
 *
 * @author Izhari Ishak Aksa
 */
public class Problem978YES {

    static BufferedReader br;

    static int nextInt() throws Exception {
        int ret = 0, x;
        while (true) {
            x = br.read();
            if (x == 10 || x == 32 || x == -1) {
                return ret;
            }
            ret *= 10;
            ret += x - 48;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int TC = nextInt();
        while (TC-- > 0) {
            int B = nextInt();
            int SG = nextInt();
            int SB = nextInt();

            PriorityQueue<Integer> QG = new PriorityQueue<Integer>(SG, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    if (o1 > o2) {
                        return -1;
                    }
                    return 1;
                }
            });
            for (int i = 0; i < SG; i++) {
                QG.add(nextInt());
            }

            PriorityQueue<Integer> QB = new PriorityQueue<Integer>(SB, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    if (o1 > o2) {
                        return -1;
                    }
                    return 1;
                }
            });
            for (int i = 0; i < SB; i++) {
                QB.add(nextInt());
            }

            while (true) {
                if (QG.isEmpty() && QB.isEmpty()) {
                    pw.println("green and blue died");
                    break;
                } else if (QG.isEmpty()) {
                    pw.println("blue wins");
                    while (!QB.isEmpty()) {
                        pw.println(QB.poll());
                    }
                    break;
                } else if (QB.isEmpty()) {
                    pw.println("green wins");
                    while (!QG.isEmpty()) {
                        pw.println(QG.poll());
                    }
                    break;
                } else {
                    int count = 0;
                    List<Integer> LG = new ArrayList<Integer>();
                    List<Integer> LB = new ArrayList<Integer>();
                    while (!QG.isEmpty() && !QB.isEmpty() && count < B) {
                        int a = QG.poll();
                        int b = QB.poll();
                        if (a > b) {
                            LG.add(a - b);
                        } else if (b > a) {
                            LB.add(b - a);
                        }
                        count++;
                    }
                    QG.addAll(LG);
                    QB.addAll(LB);
                }
            }
            pw.flush();
            if (TC > 0) {
                pw.println();
            }
        }
    }
}
