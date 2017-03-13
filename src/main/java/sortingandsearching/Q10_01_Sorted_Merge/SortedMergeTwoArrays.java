package sortingandsearching.Q10_01_Sorted_Merge;

import java.util.Arrays;

/**
 * Created by rg029761 on 3/12/17.
 */
public class SortedMergeTwoArrays {

    public static int[] sortedMerge(int[] A, int[] B) {
        //base cases
        int[] longArray;
        int[] shortArray;

        //find which array is the longest
        if(A.length >= B.length) {
            longArray = A;
            shortArray = B;
        } else {
            longArray = B;
            shortArray = A;
        }

        //we use three variables.
        int k = longArray.length - 1;
        int i = longArray.length - shortArray.length - 1;
        int j = shortArray.length - 1;

        while(i >= 0 && j >= 0) {
            if(longArray[i] >= shortArray[j]) {
                longArray[k--] = longArray[i--];
            } else {
                longArray[k--] = shortArray[j--];
            }
        }

        while(i >= 0) {
            longArray[k--] = longArray[i--];
        }

        while(j >= 0) {
            longArray[k--] = shortArray[j--];
        }

        return longArray;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 10, 20, 30 , 40, -1, -1, -1, -1, -1};
        int[] B = {1, 5, 11, 35, 55 };

        System.out.println(Arrays.toString(SortedMergeTwoArrays.sortedMerge(A, B)));
    }
}
