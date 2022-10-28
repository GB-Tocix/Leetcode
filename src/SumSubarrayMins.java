import java.util.Stack;

public class SumSubarrayMins {
    public int sumSubarrayMins(int[] arr) {
        Stack<int[]> s = new Stack<>();
        int[] pre = new int[arr.length];
        s.push(new int[]{arr[0], 0});
        pre[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && s.peek()[0] > arr[i]) {
                s.pop();
            }
            pre[i] = s.isEmpty() ? -1 : s.peek()[1];
            s.push(new int[]{arr[i], i});
        }
        int ans = 0;
        int M = (int)1e9 + 7;
        s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek()[0] >= arr[i]) {
                s.pop();
            }
            int nxt = s.isEmpty() ? arr.length : s.peek()[1];
            s.push(new int[]{arr[i], i});
            ans = (ans + (i - pre[i]) * (nxt - i) % M * arr[i] % M) % M;
        }
        return ans;
    }
}
