package cciLibrary;

/**
 * Created by rg029761 on 2/4/17.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent; // we wont be using this though for our programs
    public TreeNode(int x) {
        val = x;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
