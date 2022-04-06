import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer>[] set = new HashSet[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            set[i] = new HashSet<>();
        for (int[] e: edges) {
            set[e[0]].add(e[1]);
            set[e[1]].add(e[0]);
        }
        List<Integer> nxt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (set[i].size() == 1)
                nxt.add(i);
        }
        while (nxt.size() != 0) {
            ans = nxt;
            nxt = new ArrayList<>();
            for (int cur: ans) {
                int neighbor = set[cur].iterator().next();
                set[neighbor].remove(cur);
                if (set[neighbor].size() == 1)
                    nxt.add(neighbor);
            }
        }
        return ans;
    }

}
