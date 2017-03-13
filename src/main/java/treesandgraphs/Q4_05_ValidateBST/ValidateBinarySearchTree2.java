package treesandgraphs.Q4_05_ValidateBST;

import cciLibrary.TreeNode;

/**
 * Created by rg029761 on 2/5/17.
 */
public class ValidateBinarySearchTree2 {
    //If you don't like the use of static variables, then you can tweak this code to use a
    // wrapper class for the integer, as shown below.
    // class WrapInt {
    //   public int value/
    // }
    public static Integer prevValue = null;

    /**
     Logic: Instead of a list here ?  keep track of last element and make sure currElement > last element.

     Test with LeetCode:
     [60,50,80,45,55,null,90,40,47,null,null,85]
     [1,1]

     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }
    private boolean checkBST(final TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!checkBST(root.left)) {
            return false;
        }
        if(prevValue != null && (root.val <= prevValue)) {
            return false;
        }
        prevValue = root.val;

        if(!checkBST(root.right)) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new ValidateBinarySearchTree2().isValidBST(root));
    }
}
