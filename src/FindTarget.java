import java.util.ArrayList;
import java.util.List;

public class FindTarget {

    List<Integer> list;

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        explore(root);
        int l = 0;
        int r = list.size() - 1;
        int sum;
        while (l < r) {
            sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }

    public void explore(TreeNode root) {
        if (root == null)
            return;
        explore(root.left);
        list.add(root.val);
        explore(root.right);
    }
}
