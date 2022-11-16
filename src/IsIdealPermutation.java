public class IsIdealPermutation {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int last_min = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            last_min = Math.min(last_min, nums[i + 2]);
            if (last_min > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
