package sortingandsearching.Q10_09_SortedMatrixSearch;

/**
 * Given an M x N matrix in which each row and each column is sorted in ascending order, write a method to find an element.
 */
public class SortedMatrixSearch {

    /**
       Solution #1: Naive Solution
       We can do a binary serach on each row to find the element.
       This algorithm will be O(M log(N)),
       since there are M rows and it takes O(log(N))time to search each one.
       This is a good approach to mention to your interviewer before you proceed with generating a better algorithm.

       Solution #2:
       Start from the top right cell say cellVal. if the x > cellVal move down else move left
       At each step we eliminate either a row or a column.
     */
    public static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
