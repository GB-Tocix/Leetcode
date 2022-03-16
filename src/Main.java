import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        CountMaxOrSubsets test = new CountMaxOrSubsets();
//        int[] input_array_1D = {3,1};
//        int[][] input_array_2D = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
//        String[] string_array_1D = new String[]{"ab","adc"};
//        System.out.println(test.countMaxOrSubsets(input_array_1D));

        AllOne obj = new AllOne();
        obj.inc("hello");
        obj.inc("hello");
        obj.inc("leet");
        obj.dec("hello");
        obj.dec("hello");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }

}
