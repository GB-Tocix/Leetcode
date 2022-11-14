import java.util.Arrays;

public class SplitArraySameAverage {
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1)
            return false;
        int n = nums.length;
        for (int i = 1; i <= n / 2; i++) {
            if (i * Arrays.stream(nums).sum() % n != 0)
                continue;
            int t = i * Arrays.stream(nums).sum() / n;
            boolean[][] dp = new boolean[i + 1][t + 1];
            dp[0][0] = true;
            for (int k = 0; k < n; k++) {
                for (int p = Math.min(k + 1, i); p >= 1; p--)
                    for (int j = t; j >= nums[k]; j--) {
                        dp[p][j] = (dp[p][j] || dp[p - 1][j - nums[k]]);
                    }
            }
            if (dp[i][t])
                return true;
        }
        return false;
    }
}
