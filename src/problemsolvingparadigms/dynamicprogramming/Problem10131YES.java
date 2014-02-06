package problemsolvingparadigms.dynamicprogramming;

import java.util.*;

/**
 * Is Bigger Smarter?
 *
 * This problem is solved using DP (longest decreasing sequence).
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10131YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Elephant> list = new ArrayList<Elephant>();
        int id = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Elephant c = new Elephant(a, b, id++);
            list.add(c);
        }
        int n = list.size();
        int[] dp = new int[n];
        int[] flag = new int[n];
        Arrays.fill(flag, 0);
        Arrays.fill(dp, 1);
        Collections.sort(list);
        for (int i = 1; i < n; i++) {
            Elephant a = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                Elephant b = list.get(j);
                if (b.weight < a.weight && b.iq > a.iq && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    flag[i] = j;
                }
            }
        }
        int ans = 1;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                ind = i;
            }
        }
        System.out.println(ans);
        int[] temp = new int[ans];
        for (int i = 0; i < ans; i++) {
            temp[ans - i - 1] = list.get(ind).id;
            ind = flag[ind];
        }
        for (int i = 0; i < ans; i++) {
            System.out.println(temp[i]);
        }
    }
}

class Elephant implements Comparable<Elephant> {

    int weight;
    int iq;
    int id;

    public Elephant(int weight, int iq, int id) {
        this.weight = weight;
        this.iq = iq;
        this.id = id;
    }

    public int compareTo(Elephant o) {
        if (o.weight > this.weight) {
            return -1;
        } else if (o.weight == this.weight) {
            if (o.iq > this.iq) {
                return 1;
            }
            return -1;
        }
        return 1;
    }
}