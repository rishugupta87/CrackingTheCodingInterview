package sortingandsearching.Q10_05_Sparse_Search;

/**
 Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a method to find
 the location of a given string.

 Inout: ball, {"at", "", "", "", "ball", "", "", "car, " ", " ", "dad", "", ""}
 Output: 4
 */
public class SparseSearch {

    public static int sparseSearch(String[] strings, String lookString) {
        return search(strings, 0, strings.length - 1, lookString);
    }

    private static int search(final String[] strings, final int first, final int last, String lookString) {

        if (first > last) {
            return -1;
        }

        int mid = (first + last)/2;

        //if mid point is "", go left and right to find first not empty string, that will be the new mid
        if(strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while(true) {
                if (left < first && right > last) {
                    return -1;
                }
                if(left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }

                if(right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }

                left--;
                right++;
            }
        }

        if(strings[mid].equals(lookString)) {
            return mid;
        } else if(strings[mid].compareTo(lookString) < 0) { //since strings are sorted compare lexicographically, search right
            return search(strings, mid+1, last, lookString);
        } else { //search left
            return search(strings, first, mid - 1, lookString);
        }
    }

    public static void main(String[] args) {
        String[] stringList1 = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        String[] stringList2 = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        //System.out.println(sparseSearch(stringList1, "banana"));
        System.out.println(sparseSearch(stringList2, "ball"));
    }
}
