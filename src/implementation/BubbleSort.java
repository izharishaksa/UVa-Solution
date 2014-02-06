package implementation;

/**
 * Bubble Sort.
 *
 * @author Izhari Ishak Aksa
 */
public class BubbleSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 9, 4, 5, 7, 10, 1};
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
}
