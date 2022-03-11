import java.util.Arrays;

public class CountHighestScoreNodes {
    int n;
    int[] left;
    int[] right;
    int[] lSum;
    int[] rSum;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        right = new int[n];
        left = new int[n];
        for (int i = 1; i < n; i++) {
            int root = parents[i];
            if (left[root] == 0)
                left[root] = i;
            else
                right[root] = i;
        }

        lSum = new int[n];
        rSum = new int[n];
        Arrays.fill(lSum, -1);
        Arrays.fill(rSum, -1);
        lCount(0);
        rCount(0);

        int ans = 0;
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            int grades = p(lSum[i]) * p(rSum[i]) * p(n - 1 - rSum[i] - lSum[i]);
            if (grades > maximum) {
                maximum = grades;
                ans = 1;
            }
            else if (grades == maximum)
                ans++;
        }

        return ans;
    }

    public int lCount(int root) {
        if (lSum[root] != -1)
            return lSum[root];
        if (left[root] == 0)
            lSum[root] = 0;
        else
            lSum[root] = lCount(left[root]) + rCount(left[root]) + 1;
        return lSum[root];
    }

    public int rCount(int root) {
        if (rSum[root] != -1)
            return lSum[root];
        if (right[root] == 0)
            rSum[root] = 0;
        else
            rSum[root] = rCount(right[root]) + lCount(right[root])+ 1;
        return rSum[root];
    }

    public int p(int i) {
        if (i == 0)
            return 1;
        else
            return i;
    }
}
