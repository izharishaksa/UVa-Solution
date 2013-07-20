package graph.dijkstra;

import java.util.Scanner;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10801 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] T = new int[N];
            for (int i = 0; i < N; i++) {
                T[i] = sc.nextInt();
            }
            String s = sc.nextLine();
            int[][] map = new int[100][100];            
            for (int i = 0; i < N; i++) {
                String[] temp = sc.nextLine().split("[ ]");
                for (int j = 0; j < temp.length; j++) {
                    int o = Integer.parseInt(temp[i]);
                }
            }
        }
    }
    
}
