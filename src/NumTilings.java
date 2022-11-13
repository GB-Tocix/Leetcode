public class NumTilings {
    public int numTilings(int n) {
        if (n == 1)
            return 1;
        int M = 1000000007;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][1] = 0;
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % M;
            dp[i][0] = (dp[i - 2][0] + (dp[i - 1][0] + 2 * dp[i - 1][1] % M) % M) % M;
        }
        return dp[n][0];
    }
}
