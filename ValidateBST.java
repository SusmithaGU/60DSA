import java.util.Stack;

public class ValidateBST {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isValid(TreeNode root) {
        return util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean util(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min)
            return false;

        return util(root.left, min, root.val) && util(root.right, root.val, max);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        long start = System.currentTimeMillis();
        System.out.println(isValid(root));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
// ------> optimised solution
// A In-Order traversal of a binary search tree always gives a sorted array,
// So if the popped value is not greater than the previously popped value then
// it is not a valid BST

/*
 * public boolean isValidBST(TreeNode root) {
 * if (root == null) return true;
 * Stack<TreeNode> stack = new Stack<>();
 * TreeNode pre = null;
 * while (root != null || !stack.isEmpty()) {
 * while (root != null) {
 * stack.push(root);
 * root = root.left;
 * }
 * root = stack.pop();
 * System.out.Println(root.val); ---> This is Inorder traversal of BST
 * if(pre != null && root.val <= pre.val) return false;
 * pre = root;
 * root = root.right;
 * }
 * return true;
 * }
 */