package datastructures.builtin;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Contest Scoreboard.
 * 
 * @author Izhari Ishak Aksa
 */
public class Problem10258YES {

    static void printResult(Contestants[] con) {
        Arrays.sort(con);
        for (int i = 0; i < con.length; i++) {
            Contestants cc = con[i];
            if (con[i].participate) {
                System.out.println(cc.getId() + " " + cc.totalSolved + " " + cc.totalPenalty);
            }
        }
    }

    static Contestants[] init() {
        Contestants[] con = new Contestants[110];
        for (int i = 0; i < 110; i++) {
            con[i] = new Contestants(i);
        }
        return con;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        Contestants[] con = init();
        while (sc.hasNext()) {
            s = sc.nextLine();
            if (s.compareTo("") == 0) {
                printResult(con);
                System.out.println();
                con = init();
                continue;
            }
            String[] temp = s.split("[ ]");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            char d = temp[3].charAt(0);
            con[a].participate = true;
            if (con[a].solved[b]) continue;

            if (d == 'I') {
                con[a].penalty[b] += 20;
            } else if (d == 'C') {
                con[a].solved[b] = true;
                con[a].totalSolved++;
                con[a].totalPenalty += con[a].penalty[b] + c;
            }
        }
        printResult(con);
    }
}

class Contestants implements Comparable<Contestants> {

    private int id;
    public boolean[] solved;
    public int[] penalty;
    public int totalPenalty;
    public int totalSolved;
    public boolean participate;

    public Contestants(int id) {
        this.id = id;
        this.solved = new boolean[10];
        Arrays.fill(solved, false);
        this.penalty = new int[10];
        Arrays.fill(penalty, 0);
        totalPenalty = 0;
        totalSolved = 0;
        participate = false;
    }

    public int getId() {
        return this.id;
    }

    public boolean getSolved(int index) {
        return this.solved[index];
    }

    public int getPenalty(int index) {
        return this.penalty[index];
    }

    public int compareTo(Contestants o) {
        if (!this.participate) {
            return 1;
        }
        if ((this.totalSolved > o.totalSolved) || (this.totalSolved == o.totalSolved && this.totalPenalty < o.totalPenalty) || (this.totalSolved == o.totalSolved && this.totalPenalty == o.totalPenalty && this.id < o.id)) {
            return -1;
        }
        return 1;
    }
}