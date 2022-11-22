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
        NthMagicalNumber test = new NthMagicalNumber();
        int[] input_array_1D = {2,1,3};
        int[] input_array_1D_2 = {3,4,5,6};
        int[] input_array_1D_3 = {50,10,40,70};
        int[][] input_array_2D = new int[][]{{4,2}};
        char[][] char_array_2D = new char[][]{
                {'#','.','.','#','.','#'},
                {'.','#','.','#','#','.'},
                {'#','.','.','#','.','#'}
        };
        String string = "00.0.0.0";
        String[] string_array_1D = new String[]{
                "@...a",".###A","b.BCc"};
        List<List<Integer>> list_array_2D = new ArrayList<>();
        list_array_2D.add(Arrays.asList(8, 3, 2));
        list_array_2D.add(Arrays.asList(0, 0, 4));
        list_array_2D.add(Arrays.asList(7, 6, 5));
        System.out.println(test.nthMagicalNumber(3, 4, 555));

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
