public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; i < Math.ceil(Math.sqrt(2 * n)); i += 2)
            if (n % i == 0)
                ans++;
        for (int i = 2; i < Math.ceil(Math.sqrt(2 * n)); i += 2) {
            if (n % i == i / 2)
                ans++;
        }
        return ans;
    }
}
