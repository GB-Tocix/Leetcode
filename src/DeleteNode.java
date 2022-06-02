public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || root.val == key && root.right == null && root.left == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            TreeNode pre = root, p;
            if (root.left != null) {
                p = root.left;
                if (p.right == null) {
                    root.val = p.val;
                    root.left = deleteNode(p, p.val);
                    return root;
                }
                while (p.right != null) {
                    pre = p;
                    p = p.right;
                }
                root.val = p.val;
                pre.right = deleteNode(p, p.val);
            } else {
                p = root.right;
                if (p.left == null) {
                    root.val = p.val;
                    root.right = deleteNode(p, p.val);
                    return root;
                }
                while (p.left != null) {
                    pre = p;
                    p = p.left;
                }
                root.val = p.val;
                pre.left = deleteNode(p, p.val);
            }
        }
        return root;
    }
}
