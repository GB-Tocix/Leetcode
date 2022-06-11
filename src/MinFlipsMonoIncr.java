public class MinFlipsMonoIncr {
    int[] count_r0;
    int[] count_l1;

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        count_l1 = new int[n];
        count_r0 = new int[n];
        count_r0[n - 1] = count_l1[0] = 0;
        for (int i = 1; i < n; i++) {
            count_l1[i] = count_l1[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
            count_r0[n - i - 1] = count_r0[n - i] + (s.charAt(n - i) == '0' ? 1 : 0);
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, count_l1[i] + count_r0[i]);
        }
        return ans;
    }
}
