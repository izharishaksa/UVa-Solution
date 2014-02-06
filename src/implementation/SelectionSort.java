package implementation;

/**
 * Selection Sort.
 *
 * @author Izhari Ishak Aksa
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 9, 4, 5, 7, 10, 1};
        for (int i = 0; i < arr.length; i++) {
            int ind = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[ind]) {
                    ind = j;
                }
            }
            if (ind != i) {
                arr[i] ^= arr[ind];
                arr[ind] ^= arr[i];
                arr[i] ^= arr[ind];
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();        
    }
    
}
