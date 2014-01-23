package series2014.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Last Blood.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12667YES {

    static class Submission {

        int time, team;
        String problem;
        boolean verdict;

        public Submission(int time, int team, String problem, boolean verdict) {
            this.time = time;
            this.team = team;
            this.problem = problem;
            this.verdict = verdict;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int M = sc.nextInt();
        List<Submission> sub = new ArrayList<Submission>();
        boolean[][] accepted = new boolean[T][N];
        for (int i = 0; i < M; i++) {
            int time = sc.nextInt();
            int team = sc.nextInt();
            String problem = sc.next();
            boolean verdict = sc.next().equals("Yes") ? true : false;
            if (!accepted[team - 1][problem.charAt(0) - 'A'] && verdict) {
                sub.add(new Submission(time, team, problem, verdict));
                accepted[team - 1][problem.charAt(0) - 'A'] = true;
            }
        }
        String[] result = new String[N];
        Arrays.fill(result, "");
        for (int i = sub.size() - 1; i >= 0; i--) {
            Submission s = sub.get(i);
            if (s.verdict && result[s.problem.charAt(0) - 'A'].equals("")) {
                result[s.problem.charAt(0) - 'A'] = s.time + " " + s.team;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print((char) ('A' + i) + " ");
            if (result[i].equals("")) {
                System.out.println("- -");
            } else {
                System.out.println(result[i]);
            }
        }
    }
}
