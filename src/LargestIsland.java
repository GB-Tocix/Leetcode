import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LargestIsland {
    int[] mx = new int[]{0, 1, 0, -1};
    int[] my = new int[]{1, 0, -1, 0};
    int cur, cur_square;
    int[][] grid;
    int n;
    int m;
    HashMap<Integer, Integer> square;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        cur = 2;
        square = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    cur_square = 1;
                    dfs(i, j);
                    square.put(cur, cur_square);
                    cur++;
                }
        int ans = 1;
        for (int x: square.values())
            ans = Math.max(ans, x);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0)
                    continue;
                int cur_s = 1;
                HashSet<Integer> islands = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nx = i + mx[k];
                    int ny = j + my[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 0) {
                        islands.add(grid[nx][ny]);
                    }
                }
                if (islands.size() == 0)
                    continue;
                int[] neighbor = new int[islands.size()];
                int p = 0;
                // System.out.println(islands);
                for (Iterator it = islands.iterator(); it.hasNext();) {
                    int cur_no = (int)it.next();
                    // System.out.println(cur_no);
                    neighbor[p] = square.get((int)cur_no);
                    p++;
                }
                Arrays.sort(neighbor);
                for (int k = 0; k < islands.size(); k++)
                    cur_s += neighbor[islands.size() - 1 - k];
                ans = Math.max(ans, cur_s);
            }
        return ans;
    }

    private void dfs(int x, int y) {
        grid[x][y] = cur;
        for (int k = 0; k < 4; k++) {
            int nx = x + mx[k];
            int ny = y + my[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                cur_square++;
                dfs(nx, ny);
            }
        }
    }
}