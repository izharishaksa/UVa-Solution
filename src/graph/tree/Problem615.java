package graph.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Is It A Tree?
 *
 * @author Izhari Ishak Aksa
 */
public class Problem615 {

    static boolean cek(ArrayList<Integer> s) {
        for (int i = s.size() - 1; i > 1; i--) {
            int v = s.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (v == s.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, ind = 1;
        boolean complete = false;
        while (sc.hasNext()) {
            ArrayList<Integer> leaf = new ArrayList<Integer>();
            ArrayList<Integer> root = new ArrayList<Integer>();
            while (true) {
                a = sc.nextInt();
                b = sc.nextInt();
                if (a == 0 && b == 0) {
                    break;
                }
                if (a == -1 && b == -1) {
                    complete = true;
                    break;
                }
                root.add(a);
                leaf.add(b);
            }
            if (complete) {
                break;
            }
            ArrayList<Integer> root_copy = (ArrayList<Integer>) root.clone();
            ArrayList<Integer> leaf_copy = (ArrayList<Integer>) leaf.clone();
            if (root_copy.isEmpty() || leaf_copy.isEmpty()) {
                System.out.println("Case " + (ind++) + " is a tree.");
                continue;
            }
            Collections.sort(leaf);
            Collections.sort(root);
            boolean benar = true;
            for (int i = 0; i < leaf.size() - 1; i++) {
                int x = leaf.get(i);
                int y = leaf.get(i + 1);
                if (x == y) {
                    benar = false;
                }
            }
            if (!benar) {
                System.out.println("Case " + (ind++) + " is not a tree.");
                continue;
            }

            HashMap<Integer, Integer> hi = new HashMap<Integer, Integer>();
            for (int i = 0; i < root.size(); i++) {
                int x = root.get(i);
                boolean tambah = true;
                for (int j = 0; j < leaf.size(); j++) {
                    int y = leaf.get(j);
                    if (x == y) {
                        tambah = false;
                    }
                }
                if (tambah) {
                    hi.put(x, 1);
                }
            }
            int c = hi.size();
            if (c != 1) {
                System.out.println("Case " + ind + " is not a tree.");
            } else {
                Set<Integer> rr = hi.keySet();
                Integer[] r = rr.toArray(new Integer[0]);
                ArrayList<Integer> vi1 = new ArrayList<Integer>();
                ArrayList<Integer> vi2 = new ArrayList<Integer>();
                vi1.add(r[0]);
                boolean[] sudah = new boolean[root_copy.size()];
                boolean salah = false, lanjut;
                do {
                    lanjut = false;
                    for (int i = 0; i < vi1.size(); i++) {
                        int z = vi1.get(i);
                        for (int j = 0; j < root_copy.size(); j++) {
                            int u = root_copy.get(j);
                            if (u == z && !sudah[j]) {
                                vi2.add(leaf_copy.get(j));
                                sudah[j] = true;
                                lanjut = true;
                            }
                        }
                    }
                    for (int i = 0; i < vi2.size(); i++) {
                        int x = vi2.get(i);
                        for (int j = 0; j < vi1.size(); j++) {
                            int z = vi1.get(j);
                            if (x == z) {
                                salah = true;
                            }
                        }
                    }
                    for (int i = 0; i < vi2.size(); i++) {
                        vi1.add(vi2.get(i));
                    }
                    vi2 = new ArrayList<Integer>();
                } while (!salah && !lanjut);
                if (!salah) {
                    System.out.println("Case " + ind + " is a tree.");
                } else {
                    System.out.println("Case " + ind + " is not a tree.");
                }
            }
            ind++;
        }
    }
}
