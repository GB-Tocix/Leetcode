import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ValidIPAddress test = new ValidIPAddress();
        int[] input_array_1D = {4,-2,2,-4};
        int[][] input_array_2D = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        char[][] char_array_2D = new char[][]{
                {'#','.','.','#','.','#'},
                {'.','#','.','#','#','.'},
                {'#','.','.','#','.','#'}
        };
        String string = "00.0.0.0";
        String[] string_array_1D = new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        List<List<Integer>> list_array_2D = new ArrayList<>();
        list_array_2D.add(Arrays.asList(8, 3, 2));
        list_array_2D.add(Arrays.asList(0, 0, 4));
        list_array_2D.add(Arrays.asList(7, 6, 5));
        System.out.println(test.validIPAddress(string));

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
