package treesandgraphs.Q4_05_ValidateBST;

import cciLibrary.TreeNode;

/**
 * Created by rg029761 on 2/5/17.
 */
public class ValidateBinarySearchTree3 {

    //All values on the left sub tree must be less than root, and all values on the right sub tree
    // must be greater than root. So we just check the boundaries for each node.
    //This solution also goes to the left subtree first. If the violation occurs close to the root but
    // on the right subtree, the method still cost O(n)
    //T(n) = O(n)
    public boolean isValidBST3(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
