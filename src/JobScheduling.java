import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] coll = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            coll[i][0] = startTime[i];
            coll[i][1] = endTime[i];
            coll[i][2] = profit[i];
        }
        coll[n][0] = coll[n][1] = coll[n][2] = 0;
        Arrays.sort(coll, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n + 1];
        int[] c_time = new int[n + 1];
        dp[0] = coll[0][2];
        c_time[0] = coll[0][1];
        for (int k = 1; k <= n; k++) {
            int index_k = getIndex(0, k - 1, c_time, coll[k][0]);
            if (dp[index_k] + coll[k][2] > dp[k - 1]) {
                dp[k] = dp[index_k] + coll[k][2];
                c_time[k] = coll[k][1];
            }
            else {
                dp[k] = dp[k - 1];
                c_time[k] = c_time[k - 1];
            }
        }
        return dp[n];
    }

    public int getIndex(int left, int right, int[] arr, int target) {
        while (left < right) {
            int mid = ((right + left) >> 1) + 1;
            System.out.println(left + ", " + right + ", " + mid);
            if (arr[mid] <= target)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}
