import java.util.Arrays;
import java.util.Comparator;

class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[1]));
        int ans = 1;
        int cur = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] <= cur)
                continue;
            ans++;
            cur = pairs[i][1];
        }
        return ans;
    }
}