import java.util.*;

public class CutOffTree {
    int n, m, c1;
    boolean[][] visited;
    ArrayList<int[]> trees;
    List<List<Integer>> forest;
    int[] mx = {0, 1, 0, -1};
    int[] my = {1, 0, -1, 0};

    public int cutOffTree(List<List<Integer>> _forest) {
        forest = _forest;
        n = forest.size();
        m = forest.get(0).size();
        c1 = 0;
        visited = new boolean[n][m];
        trees = new ArrayList<>();
        int h;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                h = forest.get(i).get(j);
                if (h == 0)
                    continue;
                if (h == 1)
                    c1++;
                else
                    trees.add(new int[]{i, j, h});
            }
        if (dfs(0, 0) != c1 + trees.size())
            return -1;
        int ans = 0;
        trees.sort(Comparator.comparingInt(x -> x[2]));
        int[] cur = {0, 0};
        for (int[] pos : trees) {
            for (boolean[] sub: visited)
                Arrays.fill(sub, false);
            ans += count(cur, pos);
            cur = pos;
        }
        return ans;
    }

    int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >=n || y >= m || visited[x][y] || forest.get(x).get(y) == 0)
            return 0;
        visited[x][y] = true;
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + mx[k];
            int ny = y + my[k];
            sum += dfs(nx, ny);
        }
        return 1 + sum;
    }

    int count(int[] cur, int[] nxt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{cur[0], cur[1], 0});
        visited[cur[0]][cur[1]] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (tmp[0] == nxt[0] && tmp[1] == nxt[1])
                return tmp[2];
            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + mx[k];
                int ny = tmp[1] + my[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && forest.get(nx).get(ny) != 0) {
                    queue.offer(new int[]{nx, ny, tmp[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
