import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static TreeNode buildTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        AtMostNGivenDigitSet test = new AtMostNGivenDigitSet();
        int[] input_array_1D = {5,-10,-5};
        int[][] input_array_2D = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        char[][] char_array_2D = new char[][]{
                {'#','.','.','#','.','#'},
                {'.','#','.','#','#','.'},
                {'#','.','.','#','.','#'}
        };
        String string = "00.0.0.0";
        String[] string_array_1D = new String[]{"1","7"};
        List<List<Integer>> list_array_2D = new ArrayList<>();
        list_array_2D.add(Arrays.asList(8, 3, 2));
        list_array_2D.add(Arrays.asList(0, 0, 4));
        list_array_2D.add(Arrays.asList(7, 6, 5));
        System.out.println(test.atMostNGivenDigitSet(string_array_1D, 231));

//        AllOne obj = new AllOne();
//        obj.inc("hello");
//        obj.inc("hello");
//        obj.inc("leet");
//        obj.dec("hello");
//        obj.dec("hello");
//        System.out.println(obj.getMaxKey());
//        System.out.println(obj.getMinKey());
    }

}
