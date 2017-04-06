package recursiondynamicprogramming.Q8_03_Magic_Index;

/**
 *
 *
 * When we see that A[mid] < mid, we cannot conclude which side the magic index is on. It could be on
 * the right side, as before. Or, it could be on the left side (as it, in fact, is).
 Could it be anywhere on the left side? Not exactly. Since A[5] = 3, we know that A[ 4] couldn't be a magic
 index.A[4] would need to be 4 to be the magic index, but A[4] must be less than or equal to A[5].
 In fact, when we see that A[5] = 3, we'll need to recursively search the right side as before. But,
 to search the left side, we can skip a bunch of elements and only recursively search elements A[e] through A[3]. A[ 3]
 is the first element that could be a magic index.
 The general pattern is that we compare midIndex and midValue for equality first. Then, if they are not equal, we
 recursively search the left and right sides as follows:
 Left side: search indices start through Math. min (midIndex - 1, midValue). • Right side:search indices
 Math. max(midIndex + 1, midValue) through end.
 */
public class MagicIndex_UnsortedArray {

    public static int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }
		/* Search left */
		//consider = {-2, 1, 2, 2, 4, 5, 6}
        //consider = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13}
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

		/* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast(array, rightIndex, end);

        return right;
    }
}
