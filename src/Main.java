import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FindKthNumber test = new FindKthNumber();
        int[] input_array_1D = {3,1};
        int[][] input_array_2D = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        char[][] char_array_2D = new char[][]{
                {'#','.','.','#','.','#'},
                {'.','#','.','#','#','.'},
                {'#','.','.','#','.','#'}
        };
        String string = "BBBAAAABB";
        String[] string_array_1D = new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(test.findKthNumber(100, 10));

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
