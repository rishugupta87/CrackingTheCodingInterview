package sortingandsearching.Q10_10_Rank_from_Stream;

public class BinarySearchTree {
    TreeNode root;

    public void add(int data) {
        if(root == null) {
            root = new TreeNode(data);
            return;
        }
        addToBST(root, data);
    }

    private TreeNode addToBST(TreeNode root, final int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }
        if(data <= root.data) {
            root.leftSize++;
            root.left = addToBST(root.left, data);
        } else {
            root.right = addToBST(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(60);
        bst.add(50);
        bst.add(75);
        bst.add(70);
        bst.add(80);
        bst.add(55);
        bst.add(45);
        bst.add(35);
        bst.add(90);

        System.out.println();
    }
}
