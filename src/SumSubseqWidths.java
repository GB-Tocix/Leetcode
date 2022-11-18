import java.util.Arrays;

public class SumSubseqWidths {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        long M = 1000000007;
        long res = 0;
        long times = 1;
        Arrays.sort(nums);
        // 只考虑该数本身的请况，算在其作为最大值时
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            res = (res + (nums[i] - nums[j]) % M * times % M) % M;
            times = (times * 2) % M;
        }
        return (int)res;
    }
}
