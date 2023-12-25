public class MaximumDepthOfTree {

    static class TreeNode {
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

    static int getDepth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(getDepth(root.left), getDepth(root.right));
    }

    public static void main(String[] args) {
        getDepth(null);
    }
}
