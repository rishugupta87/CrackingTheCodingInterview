package treesandgraphs.Q4_09_BSTSequences;

import cciLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 BST Sequences: A binary search tree was created by traversing through an array from left to right and inserting each element.
 Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.

 EXAMPLE:
      2
    /  \
   1    3

 Subsequences = {2,1,3}, {2,3,1}

     12
    /  \
   1    13
    \    \
     2   14

 First find subsequences of left and right subtree
 array1 = {1, 2}
 array2 = {13,14}
 Need to merge these two arrays in all possible ways keeping the elemenets within each array in same order

 weaved: {1,2,13,14}, {1,13,14,2}, {1,13,2,14}, {13,14,1,2}, {13,1,2,14}, {13,1,14,2}
 Subsequences : {12,1,2,13,14}, {12,1,13,14,2}, {12,1,13,2,14}, {12,13,14,1,2}, {12,13,1,2,14}, {12,13,1,14,2}

 */
public class BSTSequence {

    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		/* One list is empty. Add the remainder to [a cloned] prefix and
		 * store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

		/* Recurse with head of first added to the prefix. Removing the
		 * head will damage first, so we’ll need to put it back where we
		 * found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

		/* Do the same thing with second, damaging and then restoring
		 * the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if (root == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(root.val);

		/* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(root.right);

		/* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(13);
        root.right.right = new TreeNode(14);

        ArrayList<LinkedList<Integer>> allSeq = allSequences(root);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }
}
