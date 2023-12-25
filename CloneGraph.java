import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return util(node, map);
    }

    public Node util(Node root, HashMap<Integer, Node> map) {
        if (root == null)
            return null;
        ArrayList<Node> children = new ArrayList<Node>();
        Node ans = new Node(root.val, children);
        map.put(root.val, ans);

        for (Node node : root.neighbors) {
            if (!map.containsKey(node.val)) {
                Node returned = util(node, map);
                children.add(returned);
            } else {
                Node alt = map.get(node.val);
                children.add(alt);
            }
        }
        return ans;
    }
}


//https://leetcode.com/problems/clone-graph/