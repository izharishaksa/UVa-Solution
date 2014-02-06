package implementation;

/**
 * Insertion Sort.
 *
 * @author Izhari Ishak Aksa
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 9, 4, 5, 7, 10, 1};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int cur = i;
            while (cur > 0 && arr[cur - 1] >= temp) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            arr[cur] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
