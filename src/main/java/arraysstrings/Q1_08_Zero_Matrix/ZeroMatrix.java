package arraysstrings.Q1_08_Zero_Matrix;

/**
 *
 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 its entire row and column are set to O.

 Need to do this in place
 */
public class ZeroMatrix {

    /**

     Idea1:
     At first glance, this problem seems easy: just iterate through the matrix and every
     time we see a cell with value zero, set its row and column to 0.

     Problem ?
     There's one problem with that
     solution though: when we come across other cells in that row or column, we'll see the zeros and change their
     row and column to zero. Pretty soon, our entire matrix will be set to zeros.

     Idea2:
     One way around this is to keep a second matrix which flags the zero locations.
     We would then do a second pass through the matrix to set the zeros. This would ta ke 0 (MN) space.

     Idea3:
     Do we really need O(MN) space? No.

     Since we're going to set the entire row and column to zero,
     we don't need to track that it was exactly ce11[2] [4] (row 2, column 4). We only need to know that row 2
     has a zero somewhere, and column 4 has a zero somewhere.We'll set the entire row and column to zero anyway,
     so why would we care to keep track of the exact location of the zero?
     The code below implements this algorithm.We use two arrays to keep track ofall the rows with zeros and
     all the columns with zeros.We then nullify rows and columns based on the values in these arrays.

     Idea4: (Best)
     We can reduce the space to 0 (1) by using the first row as a replacement for the row
     array and the first column as a replacement for the column array. This works as follows:
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        //set first row and column zero or not
        // Check if the first row and first column have any zeros, and set
        // variables firstRowZero and firstColumnZero. (We'll nullify the first row and first column later, if necessary.)
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        //mark zeros on first row and column
        //Iterate through the rest of the matrix,
        // setting matrix[i][0] and matrix[0][j] to zero whenever there's a zero in matrix[i][j].
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use mark to set elements
        //Iterate through rest of matrix,nullifying row if there's a zero in matrix[i][0] or matrix[0][j].
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //set first column and row
        //Nullify the first row and first column, if necessary
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }

    }
}
