package problemsolvingparadigms.dynamicprogramming;

import java.util.*;
/**
 * This problem is solved using DP (LIS)
 *
 * @author Izhari Ishak Aksa
 */
public class Problem103YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            Box[] box = new Box[K];
            int max = 0;
            for (int i = 0; i < K; i++) {
                int[] arr = new int[N];
                for (int j = 0; j < N; j++) {
                    arr[j] = sc.nextInt();
                }
                Arrays.sort(arr);
                box[i] = new Box(i + 1, arr);
            }
            Arrays.sort(box);
            int[] dp = new int[K];
            int[] flag = new int[K];
            Arrays.fill(dp, 1);
            for (int i = 1; i < K; i++) {
                int[] arr1 = box[i].arr;
                for (int j = i - 1; j >= 0; j--) {
                    boolean ok = true;
                    int[] arr2 = box[j].arr;
                    for (int k = 0; k < N; k++) {
                        if (arr1[k] <= arr2[k]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        flag[i] = j;
                    }
                }
            }
            int ans = 1;
            int ind = -1;
            for (int i = 0; i < K; i++) {
                if (ans <= dp[i]) {
                    ans = dp[i];
                    ind = i;
                }
            }
            System.out.println(ans);
            int[] temp = new int[ans];
            for (int i = 0; i < ans; i++) {
                temp[ans - 1 - i] = box[ind].id;
                ind = flag[ind];
            }
            for (int i = 0; i < ans - 1; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println(temp[ans - 1]);
        }
    }

}

class Box implements Comparable<Box> {

    int id;
    int[] arr;

    public Box(int id, int[] arr) {
        this.id = id;
        this.arr = arr;
    }

    public int compareTo(Box o) {
        for (int i = 0; i < arr.length; i++) {
            if (o.arr[i] < this.arr[i]) return 1;
            if (o.arr[i] > this.arr[i]) return -1;
        }
        return 1;
    }

}