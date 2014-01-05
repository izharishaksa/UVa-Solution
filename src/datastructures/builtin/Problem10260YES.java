package datastructures.builtin;

import java.util.Scanner;

/**
 * Soundex.
 * 
 * @author Izhari Ishak Aksa
 */
public class Problem10260YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
        int[] temp = {0, 1, 2, 3, 0, 1, 2, 0, 0, 2, 2, 4, 5, 5, 0, 1, 2, 6, 2, 3, 0, 1, 0, 2, 0, 2};
        while (sc.hasNext()) {
            String s = sc.nextLine(), ret = "";
            int bef = 0;
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - 'A';
                if (temp[a] != bef && temp[a] != 0) {
                    bef = temp[a];
                    ret += bef + "";
                } else if (temp[a] == 0) {
                    bef = 0;
                }
            }
            System.out.println(ret);
        }
    }
}
