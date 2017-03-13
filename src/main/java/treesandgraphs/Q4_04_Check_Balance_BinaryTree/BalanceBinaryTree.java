package treesandgraphs.Q4_04_Check_Balance_BinaryTree;

import cciLibrary.BinaryTree;
import cciLibrary.TreeNode;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never
 * differ by more than one.
 */
public class BalanceBinaryTree {

    /**
     consider each node as root and calculate height of left and right subtree
     if at any instant the left and right heights differ by more than 1 then its not a balanced binary tree.

     Although this works, it's not very efficient. On each node, we recurse through its entire subtree.
     This means that getHeight is called repeatedly on the same nodes. The algorithm is O(N log N) if tree is balanced else
     O(n2) if not balanced since each node is "touched" once per node above it.

     To make this efficient We need to cut out some of the calls to getHeight.
     * @param root
     * @return
     */
    public static boolean isBalancedBinaryTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(BinaryTree.height(root.left) - BinaryTree.height(root.right)) > 1) {
            return false;
        }
        return isBalancedBinaryTree(root.left) && isBalancedBinaryTree(root.right);
    }

    /**
     *
     If we inspect this method, we may notice that getHeight could actually check if the tree is balanced at the same
     time as it's checking heights. What do we do when we discover that the subtree isn't balanced? Just return an error code.
     This improved algorithm works by checking the height of each subtree as we recurse down from the root. On each node,
     we recursively get the heights of the left and right subtrees through the checkHeight method. If the subtree is balanced,
     then checkHeight will return the actual height of the subtree. If the subtree is not balanced, then checkHeight will
     return an error code. We will immediately break and return an error code from the current call.
     *
     * @param root
     * @return
     */
    public static boolean isBalancedBinaryTree_Efficient(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(final TreeNode root) {
        if(root == null) {
            return 0;
        }
        int hLeft = checkHeight(root.left);
        if(hLeft == -1) return -1;
        int hright = checkHeight(root.right);
        if(hright == -1) return -1;

        if(Math.abs(hLeft - hright) > 1) {
            return -1;
        }
        return 1 + Math.max(hLeft, hright);
    }
}
