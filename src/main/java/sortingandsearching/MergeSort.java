package sortingandsearching;

import java.util.Arrays;

/**
 *
 * Merge sort divides the array in half, sorts each of those halves, and then merges them back together.
 * Each of those halves has the same sorting algorithm applied to it. Eventually, you are merging just two single- element arrays.
 * It is the "merge" part that does all the heavy lifting.
 *
 * Merge Sort Runtime: O( n log (n) ) average and worst case. Memory: Depends.
 */
public class MergeSort {
    /**
     *
     * Merge Sort
     * Worst case : T(n) = O(nlogn)
     * Best Case : T(n) = O(nlogn)
     * Space complexity: O(n)
     */
    public static int[] sort(final int[] array) {
        int n = array.length;
        if (n == 1) {
            return array;
        }
        //find the mid point.
        int midpoint = n / 2;

        int[] left = new int[midpoint];
        int[] right = new int[n - midpoint];

        System.arraycopy(array, 0, left, 0, midpoint);
        System.arraycopy(array, midpoint, right, 0, n - midpoint);

        sort(left);
        sort(right);
        return merge(left, right, array);
    }

    private static int[] merge(final int[] array1, final int[] array2, int[] array) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < array1.length && j < array2.length) {
            if(array1[i] < array2[j]) {
                array[k++] = array1[i];
                i++;
            } else {
                array[k++] = array2[j];
                j++;
            }
        }

        while (i < array1.length) {
            array[k++] = array1[i++];
        }

        while (j < array2.length) {
            array[k++] = array2[j++];
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {2,54,1,6,8,5,3,17, -89, 100};
        int[] res = MergeSort.sort(array);
        System.out.println(Arrays.toString(res));
        //int[] left = {3,6,13,30,40};
        //int[] right = {0, 10};
        //System.out.println(Arrays.toString(MergeSort.merge(left, right, new int[10])));
    }

}
