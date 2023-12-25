public class LongestCommonAncestor {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
 /*
  * The intuition of the problem is that the tree is reduced from bottom  up until a common root is reached.
    We do dfs until we encounter either p or q in the way if we see them then we propogate them to
    the top.This way the parents are reduced like in path compression and we reach a common parent.
  */
    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(8);

        TreeNode LowestcommonAncestor = lca(root, root.right.right.left, root.right.right.left.left);
        System.out.println("  ");
    }
}
