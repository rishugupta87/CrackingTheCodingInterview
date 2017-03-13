package treesandgraphs.Q4_10_Subtree;

import cciLibrary.TreeNode;

public class BinaryTreeSubtreeApproach2 {
    /**
     Can we reduce the space complexity of Approach1 ?

     We traverse the tree T1. Everytime we encounter the node with value same as T1's root(Note there can be duplicate nodes)
     we call a function that matches the subtree T2 and from the node which matched T1's roots value

     We will gain significantly on space complexity:
     Space = O (logn + logm) => still need to figure how, may be at any point in a stack thats the maximum number.

     What will be the time complexity of this approach ?
     T(n) = O(n + km) where k is the no of times T2's root node appeared in T1
     However the km time might be lesser since everytime when we call Matchtree if at any stage we dont match on two nodes we exit
     so ideally we dont even go though m nodes.

     what if k was a random number picked between 0 and p
     probability that a node in T1 matches with T2's root will be 1/p
     so for n nodes this will be n/p
     T(n) = O (n + (n/p)*m)

     Analysis: If we analyze this approach is better than approach 1 even though the time complexity looks higher its not
     if we get the tighter upper bound. and in terms of space also its better
     */
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) {
            return false;
        }
        return isSubtreeTemp(t1, t2);
    }

    private static boolean isSubtreeTemp(final TreeNode t1, final TreeNode t2) {
        if(t1 == null) {
            return false; // we haven found an identical match yet.
        }
        if(t1.val  == t2.val) {
            boolean isIdentical = isIdentical(t1, t2);
            if(!isIdentical) {
                return false;
            } else {
                return true;
            }
        }
        return isSubtreeTemp(t1.left, t2) || isSubtreeTemp(t1.right, t2);
    }

    private static boolean isIdentical(final TreeNode t1, final TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2== null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }
}
