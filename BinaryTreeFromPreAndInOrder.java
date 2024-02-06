public class BinaryTreeFromPreAndInOrder {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int inOrderIndex = 0, preOrderIndex = 0;

    public static TreeNode buildTree(int[] pre, int[] in, int stop) {
        if (preOrderIndex >= pre.length)
            return null;

        //If the element at inorder is found then the left tree for that element 
        //is constructed so return and try to construct its right subtree
        if (in[inOrderIndex] == stop) {
            inOrderIndex++;
            return null;
        }

        TreeNode node = new TreeNode(pre[preOrderIndex++]);
        node.left = buildTree(pre, in, node.val);
        node.right = buildTree(pre, in, stop);

        return node;
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        int[] in = { 4, 2, 5, 1, 6, 3, 7 };
        test t = new test();
        TreeNode n = buildTree(pre, in, Integer.MIN_VALUE);
        System.out.println("");
    }
}
