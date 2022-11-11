import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathAllKeys {
    int m;
    int n;
    int target = 0;
    int cnt = 0;
    int[] mx = new int[]{1, 0, -1, 0};
    int[] my = new int[]{0, 1, 0, -1};
    int[][] status;
    String keys = "abcdef";
    String locks = "ABCDEF";
    String[] grid;
    Queue<int[]> queue;

    public int shortestPathAllKeys(String[] grid) {
        initialize(grid);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_sta = cur[3];
            System.out.println(Arrays.toString(cur));
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + mx[i];
                int y = cur[1] + my[i];
                if (!(x >= 0 && x < m && y >= 0 && y < n) || grid[x].charAt(y) == '#')
                    continue;
                char c = grid[x].charAt(y);
                if (c == '#' || isLock(c) && !haveThisKey(getIndexOfLock(c), cur_sta))
                    continue;
                if (status[x][y] == -1 || (status[x][y] | cur_sta) != status[x][y]) {
                    status[x][y] = cur_sta;
                    if (isKey(c))
                        status[x][y] = updateSta(getIndexOfKey(c), status[x][y]);
                    if (status[x][y] == target)
                        return cur[2] + 1;
                    queue.offer(new int[]{x, y, cur[2] + 1, status[x][y]});
                }
            }
        }
        return -1;
    }

    void initialize(String[] grid) {
        this.grid = grid;
        queue = new LinkedList<>();
        m = grid.length;
        n = grid[0].length();
        status = new int[m][];
        for (int i = 0; i < m; i++) {
            status[i] = new int[n];
            Arrays.fill(status[i], -1);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    status[i][j] = 0;
                    queue.add(new int[]{i, j, 0, 0});
                }
                if (isKey(grid[i].charAt(j))) {
                    cnt++;
                    target = (target << 1) + 1;
                }
            }
    }

    int getIndexOfLock(char lock) {
        return lock - 'A';
    }

    int getIndexOfKey(char key) {
        return key - 'a';
    }

    boolean isLock(char c) {
        return locks.indexOf(c) != -1;
    }

    boolean isKey(char c) {
        return keys.indexOf(c)!= -1;
    }

    boolean haveThisKey(int t, int cur) {
        return (((1 << t) & cur) != 0);
    }

    int updateSta(int t, int sta) {
        return (1 << t) | sta;
    }
}
