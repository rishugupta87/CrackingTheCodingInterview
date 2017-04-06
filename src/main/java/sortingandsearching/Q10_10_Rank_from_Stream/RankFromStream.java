package sortingandsearching.Q10_10_Rank_from_Stream;

public class RankFromStream {
    BinarySearchTree bst;

    /**
     * We use binary serach tree as the internal data structure to hold the numbers. note that the node has an additional field of leftSize which has info
     * of no of nodes in the left subtree of the current node . We create this trr
     *
     * Time complexity = O(logn) if the tree is balanced else O(n)
     *
     * @param x
     */
    public void track(int x) {
        if(bst == null) {
            bst = new BinarySearchTree();
        }
        bst.add(x);
    }

    /**
     *
      As long as we're moving left during searching for x, the counter won't change. Why? Because all the values we're skipping on the right side are greater than x.
      After all, the very smallest element (with rank of 1) is the leftmost node. When we move to the right though, we skip over a bunch of elements on the left.
      All of these elements are less than x, so we'll need to increment counter by the number of elements in the left subtree.
     *
     * @param x
     * @return
     */
    public int getRankFromStream(int x) {
        return getRank(x, bst.root, 0);
    }

    private int getRank(final int x, final TreeNode root, int count) {
        //If we are at the curr Node no of elements less than it will be count(prev calculated) + no of nodes in left subtree = root.leftSize
        if(x == root.data) {
            count += root.leftSize;
            return count;
        }
        if(x > root.data) {
            //if we look for the node greater than the curr node, count will be count(prev calculated) + no of nodes in left subtree = root.leftSize + 1(add root too)
            count += 1 + root.leftSize;
            return getRank(x, root.right, count);
        } else {
            //while going left count is not incremented
            return getRank(x, root.left, count);
        }
    }

    public static void main(String[] args) {
        int[] arr = {60, 50, 75, 45, 55, 70, 80, 35, 90};
        RankFromStream rankFromStream = new RankFromStream();

        for(int num : arr) {
            rankFromStream.track(num); //creates a bst
        }
        for(int num : arr) {
            System.out.println("Rank for elem:" + num + " = " + rankFromStream.getRankFromStream(num));
        }
    }
}
