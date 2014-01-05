package datastructures.builtin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Updating a Dictionary.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12504YES {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String a = sc.next();
            String b = sc.next();
            HashMap<String, String> aa = new HashMap<String, String>();
            StringBuilder key = new StringBuilder(), value = new StringBuilder();
            boolean first = true;
            for (int i = 1; i < a.length(); i++) {
                char c = a.charAt(i);
                if (c == ':') {
                    first = false;
                } else if ((c == ',' || c == '}') && (!key.toString().equals("") && !value.toString().equals(""))) {
                    aa.put(key.toString(), value.toString());
                    key = new StringBuilder();
                    value = new StringBuilder();
                    first = true;
                } else if (first) {
                    key.append(c);
                } else {
                    value.append(c);
                }
            }
            key = new StringBuilder();
            value = new StringBuilder();
            HashMap<String, String> bb = new HashMap<String, String>();
            for (int i = 1; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c == ':') {
                    first = false;
                } else if ((c == ',' || c == '}') && (!key.toString().equals("") && !value.toString().equals(""))) {
                    bb.put(key.toString(), value.toString());
                    key = new StringBuilder();
                    value = new StringBuilder();
                    first = true;
                } else if (first) {
                    key.append(c);
                } else {
                    value.append(c);
                }
            }
            
            Set<String> set2 = bb.keySet();
            ArrayList<String> newKeys = new ArrayList<String>();
            ArrayList<String> newValue = new ArrayList<String>();
            for (String i : set2) {
                if (!aa.containsKey(i)) {
                    newKeys.add(i);
                } else {
                    String val1 = aa.get(i);
                    String val2 = bb.get(i);
                    if (!val1.equals(val2)) {
                        newValue.add(i);
                    }
                }
            }
            Set<String> set1 = aa.keySet();
            ArrayList<String> remKeys = new ArrayList<String>();
            for (String i : set1) {
                if (!bb.containsKey(i)) {
                    remKeys.add(i);
                }
            }
            boolean ada = false;
            if (newKeys.size() > 0) {
                Collections.sort(newKeys);
                System.out.print("+");
                for (int i = 0; i < newKeys.size() - 1; i++) {
                    System.out.print(newKeys.get(i) + ",");
                }
                System.out.println(newKeys.get(newKeys.size() - 1));
                ada = true;
            }
            if (remKeys.size() > 0) {
                Collections.sort(remKeys);
                System.out.print("-");
                for (int i = 0; i < remKeys.size() - 1; i++) {
                    System.out.print(remKeys.get(i) + ",");
                }
                System.out.println(remKeys.get(remKeys.size() - 1));
                ada = true;
            }
            if (newValue.size() > 0) {
                Collections.sort(newValue);
                System.out.print("*");
                for (int i = 0; i < newValue.size() - 1; i++) {
                    System.out.print(newValue.get(i) + ",");
                }
                System.out.println(newValue.get(newValue.size() - 1));
                ada = true;
            }
            if (!ada) {
                System.out.println("No changes");
            }
            System.out.println();            
        }
    }
}
