package treesandgraphs.Q4_02_Minimal_BST;

import cciLibrary.BinaryTreePrinter;
import cciLibrary.TreeNode;

/**
 *
 * Given an nums where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Minimal_BST {

    public static TreeNode createBSTMinimalHeight(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(final int[] nums, final int low, final int high) {
        if(low > high) {
            return null;
        }

        int mid = (low + high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, low, mid - 1);
        root.right = buildTree(nums, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        int[] array1 = {1,8,10,15,35,40,60 } ;
        TreeNode root = createBSTMinimalHeight(array1);
        BinaryTreePrinter.printNode(root);
    }
}
