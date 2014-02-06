package implementation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class MergeSort {

    static List<Integer> sort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        for (int i = 0; i < mid; i++) {
            left.add(arr.get(i));
        }
        for (int i = mid; i < arr.size(); i++) {
            right.add(arr.get(i));
        }
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
            if (left.size() == 0 && right.size() > 0) {
                result.addAll(right);
            }
            if (right.size() == 0 && left.size() > 0) {
                result.addAll(left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 9, 6, 8, 3, 4};
        List<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        list = sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
