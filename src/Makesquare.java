import java.util.ArrayList;
import java.util.Arrays;


public class Makesquare {

    int n;
    int N;
    long target;
    long[] count;
    boolean[] size2;
    int[] matchsticks;

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        n = matchsticks.length;
        N = 1 << n;
        target = Arrays.stream(matchsticks).sum();
        if (target % 4 != 0)
            return false;
        target /= 4;
        Arrays.sort(matchsticks);
        if (matchsticks[n - 1] > target)
            return false;
        count = new long[N];
        dfs(N - 1);
        ArrayList<Integer> available = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (count[i] == target)
                available.add(i);
        }
        size2 = new boolean[N];
        for (int i = 1; i < available.size(); i++)
            for (int j = 0; j < i; j++) {
                int x = available.get(i);
                int y = available.get(j);
                if ((x & y) == 0)
                    size2[x | y] = true;
            }
        for (int i = 1; i < N - 1; i++) {
            if (size2[i] && size2[(N - 1) ^ i])
                return true;
        }
        return false;
    }

    void dfs(int cur) {
        if (cur == 0 || count[cur] != 0)
            return;
        ArrayList<Integer> subList;
        for (int sub: (subList = getSub(cur)))
            dfs(sub);
        int p = cur & (-cur);
        count[cur] = count[cur ^ p] + matchsticks[(int)Math.round((Math.log(p) / Math.log(2)))];
    }

    ArrayList<Integer> getSub(int cur) {
        ArrayList<Integer> res = new ArrayList<>();
        if (cur == 0)
            return res;
        int p = 1;
        int backup = cur;
        while (cur > 0) {
            if ((cur & p) == p) {
                cur = cur ^ p;
                res.add(backup ^ p);
            }
            p = p << 1;
        }
        return res;
    }
}
