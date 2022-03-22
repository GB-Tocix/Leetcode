import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        WinnerOfGame test = new WinnerOfGame();
        int[] input_array_1D = {3,1};
        int[][] input_array_2D = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        String string = "BBBAAAABB";
        String[] string_array_1D = new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(test.winnerOfGame(string));

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
