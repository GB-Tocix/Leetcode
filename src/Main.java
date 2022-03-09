import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BestRotation test = new BestRotation();
        int[] input_array_1D = {1,3,0,2,4};
        int[][] input_array_2D = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(test.bestRotation(input_array_1D));
    }

}
