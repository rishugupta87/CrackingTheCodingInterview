package sortingandsearching;

import java.util.Arrays;

/**
 * Selection sort is the child's algorithm: simple, but inefficient. Find the smallest element using a
 * linear scan and move it to the front (swapping it with the front element).Then, find the second smallest and move it,
 * again doing a linear scan. Continue doing this until all the elements are in place.
 *
 * Selection Sort Runtime: O(n2) average and worst case. Memory: 0 (1) .
 */
public class SelectionSort {

    public static void sort(int[] array) {
        int n = array.length;

        for(int i = 0 ; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            //find the min element
            for(int j = i ; j < n; j++) {
                if(array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            //swap the min element with the first element, next time first element will be i+1
            swap(array, minIndex, i);
        }
    }

    private static void swap(final int[] array, final int minIndex, final int i) {
        if(minIndex == i) { //already in correct position.
            return;
        }
        int tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 20, 30, 1, 5, 100, 200, 3, -1};
        SelectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
