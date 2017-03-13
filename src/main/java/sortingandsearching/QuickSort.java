package sortingandsearching;

import java.util.Arrays;

/**
 * Quick Sort IRuntime: 0 (n log (n)) average, 0 (n2) worst case. Memory: 0 (log (n) ) .
 *
 In quick sort, we pick a random element and partition the array, such that all numbers that are less than
 the partitioning element come before all elements that are greater than it. The partitioning can be performed
 efficiently through a series of swaps (see below).
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1); 
    }

    private static void sort(final int[] array, final int start, final int end) {
        if(start >= end) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        sort(array, start, pivotIndex - 1);
        sort(array, pivotIndex + 1, end);
    }

    private static int partition(final int[] array, final int start, final int end) {
        int pivot = array[end];
        int pIndex = start;

        for(int i = start; i < end; i++) {
            if(array[i] <= pivot) {
                swap(array, pIndex, i);
                pIndex++;
            }
        }
        swap(array, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] array, final int index1, final int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 1, 8, 15, 20, 4};
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
