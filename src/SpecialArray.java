import java.util.Arrays;

public class SpecialArray {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int cur = nums.length;
        int i = nums.length - 1;
        while (cur >= 0) {
            while (i >= 0 && nums[i] >= cur)
                i--;
            if (nums.length - i - 1 == cur)
                return cur;
            cur--;
        }
        return -1;
    }
}
