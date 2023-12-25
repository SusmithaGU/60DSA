import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);

        ans.add(List.of(root.val));
        boolean leftToRight = false;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> stack = new LinkedList<>();
            while (!pq.isEmpty()) {
                TreeNode curr = pq.poll();
                if (curr.left != null) {
                    temp.add(curr.left.val);
                    stack.add(curr.left);
                }
                if (curr.right != null) {
                    temp.add(curr.right.val);
                    stack.add(curr.right);
                }
            }
            pq.addAll(stack);
            if (!leftToRight) {
                Collections.reverse(temp);
            }
            if (!temp.isEmpty()) {
                ans.add(new ArrayList<>(temp));
            }
            leftToRight = !(leftToRight);
        }

        return ans;
    }

   


}


 //optimised solution

 /*
  *  public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        travel(res,0,root);
        return res;
    }
    
    private void travel( List<List<Integer>> res, int level,TreeNode cur)
    {
       if (cur == null) return;
       if (res.size() <= level) {
        res.add(new ArrayList<Integer>());
    }
    if (level % 2 == 0) {
        res.get(level).add(cur.val);
    }   else {
        res.get(level).add(0, cur.val);
    }
    travel(res, level + 1, cur.left);
    travel(res, level + 1, cur.right);
    }
  */