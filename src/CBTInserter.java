import java.util.ArrayList;
import java.util.List;

class CBTInserter {
    List<TreeNode> parents;
    List<TreeNode> sons;
    int curNum;
    int curParent;
    int isLeft;
    TreeNode root;

    public CBTInserter(TreeNode _root) {
        root = _root;
        parents = new ArrayList<>();
        sons = new ArrayList<>();
        parents.add(root);
        boolean flag = true;
        curNum = 1;
        curParent = 0;
        isLeft = 1;
        while (flag) {
            if (curParent >= curNum) {
                parents = sons;
                curParent = 0;
                curNum *= 2;
                sons = new ArrayList<>();
            }
            else {
                TreeNode target;
                if (isLeft == 1)
                    target = parents.get(curParent).left;
                else {
                    target = parents.get(curParent).right;
                }
                if (target == null)
                    flag = false;
                else {
                    if (isLeft == 0)
                        curParent++;
                    sons.add(target);
                    isLeft = 1 - isLeft;
                }
            }
        }
    }

    public int insert(int v) {
        if (curParent >= curNum) {
            parents = sons;
            curParent = 0;
            curNum *= 2;
            sons = new ArrayList<>();
        }
        TreeNode target;
        if (isLeft == 1)
            target = parents.get(curParent).left = new TreeNode(v);
        else {
            target = parents.get(curParent).right = new TreeNode(v);
        }
        int res = parents.get(curParent).val;
        if (isLeft == 0)
            curParent++;
        sons.add(target);
        isLeft = 1 - isLeft;
        return res;
    }

    public TreeNode get_root() {
        return root;
    }
}