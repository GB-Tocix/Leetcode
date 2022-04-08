import java.util.ArrayList;
import java.util.List;

class LevelOrder {
    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Node> cur = new ArrayList<>();
        List<Node> nxt;
        List<Integer> level;
        cur.add(root);
        while (cur.size() != 0) {
            level = new ArrayList<>();
            nxt = new ArrayList<>();
            for (Node node: cur) {
                level.add(node.val);
                nxt.addAll(node.children);
            }
            ans.add(level);
            cur = nxt;
        }
        return ans;
    }
}