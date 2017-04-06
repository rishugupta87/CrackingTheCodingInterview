package recursiondynamicprogramming.Q8_03_Magic_Index;

/**
 * A magic index in an array A[e... n-1] is defined to be an index such that A[ i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 *
 * FOLLOWUP: What if the values are not distinct?
 */
public class MagicIndex_SortedArray {

    /**
     * We can obviously do this in O(n) time
     *
     * However we can use binary search to gain O(logn) complexity
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int getMagicIndex(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid){
            return getMagicIndex(array, start, mid - 1);
        } else {
            return getMagicIndex(array, mid + 1, end);
        }
    }
}
