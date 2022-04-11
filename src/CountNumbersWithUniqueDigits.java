public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int ans = p(10, n);
        n--;
        while (n > 0) {
            ans += n * p(9, n - 1);
            n--;
        }
        return ans;
    }

    public int p(int n, int k) {
        int res = 1;
        while (k > 0) {
            res *= n;
            k--;
            n--;
        }
        return res;
    }
}
