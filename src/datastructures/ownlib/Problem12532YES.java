package datastructures.ownlib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Interval Product.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12532YES {

    static int[] treeZero;
    static int[] treeNegative;

    public static void buildFenwickTree(int[] arr) {
        treeZero = new int[arr.length + 1];
        treeNegative = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            int idx = i;
            int a = 0, b = 0;
            if (arr[i - 1] == 0) {
                a = 1;
            }
            if (arr[i - 1] == -1) {
                b = 1;
            }
            do {
                treeZero[idx] += a;
                treeNegative[idx] += b;
                idx += (idx & -idx);
            } while (idx <= arr.length);
        }
    }

    public static int[] read(int idx) {
        int a = 0, b = 0;
        while (idx > 0) {
            a += treeZero[idx];
            b += treeNegative[idx];
            idx -= idx & -idx;
        }
        return new int[]{a, b};
    }

    public static void update(int idx, int val1, int val2) {
        while (idx < treeZero.length) {
            treeZero[idx] += val1;
            treeNegative[idx] += val2;
            idx += (idx & -idx);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String line;
        String[] in;
        while ((line = br.readLine()) != null) {
            in = line.split("[ ]");
            int N = Integer.parseInt(in[0]), K = Integer.parseInt(in[1]);
            int[] arr = new int[N];
            in = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(in[i]);
                if (x < 0) {
                    arr[i] = -1;
                } else if (x > 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            buildFenwickTree(arr);
            for (int i = 0; i < K; i++) {
                in = br.readLine().split(" ");
                int a = Integer.parseInt(in[1]);
                int b = Integer.parseInt(in[2]);
                if (in[0].charAt(0) == 'C') {
                    if (b < 0) {
                        b = -1;
                    }
                    if (b > 0) {
                        b = 1;
                    }
                    if (b != arr[a - 1]) {
                        if (arr[a - 1] == 0 && b == 1) {
                            update(a, -1, 0);
                        } else if (arr[a - 1] == 0 && b == -1) {
                            update(a, -1, 1);
                        } else if (arr[a - 1] == 1 && b == 0) {
                            update(a, 1, 0);
                        } else if (arr[a - 1] == 1 && b == -1) {
                            update(a, 0, 1);
                        } else if (arr[a - 1] == -1 && b == 0) {
                            update(a, 1, -1);
                        } else if (arr[a - 1] == -1 && b == 1) {
                            update(a, 0, -1);
                        }
                        arr[a - 1] = b;
                    }
                } else {
                    int[] temp1 = read(b);
                    int[] temp2 = read(a - 1);
                    temp1[0] -= temp2[0];
                    temp1[1] -= temp2[1];
                    if (temp1[0] > 0) {
                        pw.print("0");
                    } else if (temp1[1] % 2 == 1) {
                        pw.print("-");
                    } else {
                        pw.print("+");
                    }
                }
            }
            pw.println();
            pw.flush();
        }
        pw.close();
    }
}
