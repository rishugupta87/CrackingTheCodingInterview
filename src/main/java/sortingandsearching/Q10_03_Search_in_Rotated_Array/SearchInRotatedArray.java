package sortingandsearching.Q10_03_Search_in_Rotated_Array;

/**
 Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times,
 write code to find an element in the array. You may assume that the array was originally sorted in increasing order.

 EXAMPLE
 Input:find 5 in {15, 16, 19, 20, 25, 1, 3 ,4 ,5 ,7 , 10, 14}
 Output: 8 (the index of 5 in the array)
 */
public class SearchInRotatedArray {

    public static int searchInRotatedArray(int[] array, int element) {
        return search(array, element, 0 , array.length - 1);
    }

    private static int search(final int[] a, final int x, final int left,
                              final int right) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

		/* While there may be an inflection point due to the rotation, either the left or
		 * right half must be normally ordered.  We can look at the normally ordered half
		 * to make a determination as to which half we should search.
		 */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[left]) { // Right is normally ordered.
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (a[mid] != a[right]) { // If right half is different, search there
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
