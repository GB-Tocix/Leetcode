public class ConstructArray {
    public int[] constructArray(int n, int k) {
        int cur_r = k + 1;
        int cur_l = 1;
        int cur_i = k;
        boolean now_is_r = true;
        int[] ans = new int[n];
        while (cur_i >= 0) {
            if (now_is_r) {
                ans[cur_i] = cur_r;
                cur_r--;
            }
            else {
                ans[cur_i] = cur_l;
                cur_l++;
            }
            cur_i--;
            now_is_r = !now_is_r;
        }
        for (int i = k + 1; i < n; i++)
            ans[i] = i + 1;
        return ans;
    }
}
