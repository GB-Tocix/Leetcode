import java.util.*;

public class ReachableNodes {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[] steps_left = new int[n];
        Arrays.fill(steps_left, -1);
        steps_left[0] = maxMoves;
        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        HashMap<String, Integer> cnt = new HashMap<>();
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
            cnt.put(edge[0] + "," + edge[1], edge[2]);
            cnt.put(edge[1] + "," + edge[0], edge[2]);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] to_update = new boolean[n];
        to_update[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!to_update[cur])
                continue;
            for (int nxt : map[cur]) {
                int c = cnt.get(cur + "," + nxt);
                if (steps_left[cur] - c - 1 > steps_left[nxt]) {
                    steps_left[nxt] = steps_left[cur] - c - 1;
                    queue.offer(nxt);
                    to_update[nxt] = true;
                }
            }
            to_update[cur] = false;
        }
        int res = 0;
        for (int sl : steps_left) {
            res += sl >= 0 ? 1 : 0;
        }
        for (int[] edge : edges) {
            int sl0 = Math.max(0, steps_left[edge[0]]);
            int sl1 = Math.max(0, steps_left[edge[1]]);
            res += Math.min(sl0 + sl1, cnt.get(edge[0] + "," + edge[1]));
        }
        return res;
    }
}
