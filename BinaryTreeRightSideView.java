import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ans.add(root.val);
        while (!q.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr.left != null)
                    temp.add(curr.left);
                if (curr.right != null)
                    temp.add(curr.right);
            }
            if (temp.size() != 0) {
                ans.add(temp.get(temp.size() - 1).val);
            }
            q.addAll(new ArrayList<>(temp));
        }

        return ans;
    }

    public static void main(String[] args) {

        BinaryTreeRightSideView b = new BinaryTreeRightSideView();
        TreeNode t = b.new TreeNode(1);
        TreeNode l1 = b.new TreeNode(2);
        TreeNode r1 = b.new TreeNode(3);
        TreeNode l2 = b.new TreeNode(4);

        t.left = l1;
        t.right = r1;
        l1.left = l2;
        List<Integer> ans = b.rightSideView(t);
        System.out.println();
    }
}

//O(n*n)
/*
 * 
 *      1
 *     / \
 *    2   3
 *   /
 *  4
 */

 //optimised solution-DFS approach

 /*
  * class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list, 0);
        return list;
    }
    
    private void helper(TreeNode node, List<Integer> list, int depth) {
        if (node != null) {
            if (depth == list.size())  //means that for each level there should be only element 
                list.add(node.val);   //that appears to right so the list size should match depth and 
                                      //an element is added only which is rightmost,in case where it is
                                      //not there the left gets added
               
            helper(node.right, list, depth + 1);
            helper(node.left, list, depth + 1);
        }
    }
}
  */