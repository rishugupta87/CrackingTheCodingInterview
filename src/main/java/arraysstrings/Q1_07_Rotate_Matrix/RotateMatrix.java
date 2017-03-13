package arraysstrings.Q1_07_Rotate_Matrix;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degrees. (an you do this in place?
 */
public class RotateMatrix {

    /**
     * ask interviewer if its a square matrix, rotate left or right ?
     * we do this layer by layer stating from outer most layer and do cell by cell rotation.
     *
     * T(n) = O(n^2)
     *
     * Revisit this later to write on your own.
     *
     *
     * @param matrix
     * @return
     */
    public static boolean rotate_cci(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }
}
