public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];

        // Recursively calculate the height of the tree and update the diameter array
        height(root, diameter);

        // Return the diameter of the tree
        return diameter[0];
    }

    public static int height(TreeNode root, int diameter[]) {

        // Base case: if the root is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int left = height(root.left, diameter);
        int right = height(root.right, diameter);

        // Update the diameter array by taking the maximum diameter that passes through
        // the current node
        diameter[0] = Math.max(diameter[0], left + right);

        // Return the maximum depth of the current node by adding 1 to the maximum depth
        // of its deepest subtree
        return Math.max(left, right) + 1;
    }
}

/*
 * 
 *  For a tree the diameter is the length of the longest path between any two nodes
 *  and also sometimes it does not pass throough the root.
 *  Hence the longest path can be found by finding the sum of maximum depths of left subtree and right
 *  subtree.
 * 
 */
