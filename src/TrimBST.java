public class TrimBST {
    int low;
    int high;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return resOfTrim(root);
    }

    TreeNode resOfTrim(TreeNode root) {
        if (root == null)
            return root;
        if (root.val < low)
            return resOfTrim(root.right);
        if (root.val > high)
            return resOfTrim(root.left);
        root.left = resOfTrim(root.left);
        root.right = resOfTrim(root.right);
        return root;
    }
}
