import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateSubtrees {
    HashSet<TreeNode> res;
    HashMap<TreeNode, Integer> node_int_map;
    HashMap<Integer, Integer> node_left_map;
    HashMap<Integer, Integer> node_right_map;
    HashMap<Integer, Boolean> node_added_map;
    int cur;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new HashSet<>();
        node_int_map = new HashMap<>();
        node_left_map = new HashMap<>();
        node_right_map = new HashMap<>();
        node_added_map = new HashMap<>();
        cur = 201;
        dfs(root);
        return new ArrayList<>(res);
    }

    void dfs(TreeNode root) {
        if (root.left != null)
            dfs(root.left);
        if (root.right != null)
            dfs(root.right);
        int cur_left = node_int_map.getOrDefault(root.left, -1000);
        int cur_right = node_int_map.getOrDefault(root.right, -1000);
        for (TreeNode node: node_int_map.keySet()) {
            int o = node_int_map.get(node);
            int o_left = node_left_map.get(o);
            int o_right = node_right_map.get(o);
            if (root.val == node.val && o_left == cur_left && o_right == cur_right) {
                node_int_map.put(root, o);
                if (!node_added_map.getOrDefault(o, false)) {
                    res.add(root);
                    node_added_map.put(o, true);
                }
                return;
            }
        }
        node_int_map.put(root, cur);
        node_left_map.put(cur, cur_left);
        node_right_map.put(cur, cur_right);
        cur++;
    }
}
