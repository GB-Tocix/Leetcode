import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PlateBetweenCandles test = new PlateBetweenCandles();
        String input = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(Arrays.toString(test.platesBetweenCandles(input, queries)));
    }

}
