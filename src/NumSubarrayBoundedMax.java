import java.util.Stack;

public class NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        Stack<int[]> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.isEmpty() || nums[i] < s.peek()[0]) {
                s.push(new int[]{nums[i], i});
            }
            else {
                while (!s.isEmpty() && s.peek()[0] <= nums[i]) {
                    int[] popped = s.pop();
                    if (popped[0] <= right && popped[0] >= left) {
                        int pre = (s.isEmpty() ? -1 : s.peek()[1]);
                        ans += (popped[1] - pre) * (i - popped[1]);
                    }
                }
                s.push(new int[]{nums[i], i});
            }
        }
        while (!s.isEmpty()) {
            int[] popped = s.pop();
            if (popped[0] <= right && popped[0] >= left) {
                int pre = (s.isEmpty() ? -1 : s.peek()[1]);
                ans += (popped[1] - pre) * (nums.length - popped[1]);
            }
        }
        return ans;
    }
}
