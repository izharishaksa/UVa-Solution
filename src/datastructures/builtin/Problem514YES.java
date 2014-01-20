package datastructures.builtin;

import java.util.Scanner;
import java.util.Stack;

/**
 * Rails.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem514YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            boolean br = true;
            while (br) {
                Stack<Integer> stack = new Stack<Integer>();
                int j = 0;
                for (int i = 0; i < N; i++) {
                    int x = sc.nextInt();
                    if (x == 0) {
                        br = false;
                        break;
                    }
                    while (j < N && j != x) {
                        if (stack.size() > 0 && stack.peek() == x) {
                            break;
                        }
                        j++;
                        stack.push(j);
                    }
                    if (stack.peek() == x) {
                        stack.pop();
                    }
                }
                if (br) {
                    if (stack.size() == 0) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
            System.out.println();
        }
    }
}
