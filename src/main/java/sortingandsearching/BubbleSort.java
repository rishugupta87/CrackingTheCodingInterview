package sortingandsearching;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Compare adjacent elements. if curr elem is > elem+1 swap . In every pass largest element bubbles at the end.
     * Runtime: 0(n2) average and worst case. Memory: 0(1).
     *
     * @param array
     */
    public static void sort(int[] array) {
        int n = array.length;

        for(int pass = n ; pass > 0 ; pass --) {
            int i = 0;
            while(i < pass - 1) {
                if(array[i] > array[i+1]) {
                    swap(array, i);
                }
                i++;
            }
        }
        System.out.println();
    }

    private static void swap(final int[] array, final int i) {
        int tmp = array[i];
        array[i] = array[i+1];
        array[i+1] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 20, 30, 1, 5, 100, 200, 3, -1};
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
