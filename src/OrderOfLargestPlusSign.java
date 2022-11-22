import java.util.HashSet;

public class OrderOfLargestPlusSign {
    int[][] prefix_r;
    int[][] prefix_c;

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        prefix_r = new int[n][n];
        prefix_c = new int[n][n];
        HashSet<Integer> zeros = new HashSet<Integer>();
        for (int[] zero : mines) {
            zeros.add(zero[0] * n + zero[1]);
        }
        for (int i = 0; i < n; i++) {
            prefix_r[i][0] = prefix_c[i][0] = 0;
            if (!zeros.contains(i * n))
                prefix_r[i][0]++;
            if (!zeros.contains(i))
                prefix_c[i][0]++;
            for (int j = 1; j < n; j++) {
                prefix_r[i][j] = prefix_r[i][j - 1];
                prefix_c[i][j] = prefix_c[i][j - 1];
                if (!zeros.contains(i * n + j))
                    prefix_r[i][j]++;
                if (!zeros.contains(j * n + i))
                    prefix_c[i][j]++;
            }
        }
        int ans = (n + 1) / 2;
        while (ans >= 1) {
            for (int x = ans - 1; x < n - ans + 1; x++) {
                for (int y = ans - 1; y < n - ans + 1; y++) {
                    if (!zeros.contains(x * n + y) && check(x, y, ans))
                        return ans;
                }
            }
            ans--;
        }
        return 0;
    }

    boolean check(int x, int y, int level) {
        int p;
        p = (y - level < 0 ? 0 : prefix_r[x][y - level]);
        int row_s = prefix_r[x][y + level - 1] - p;
        if (row_s != 2 * level - 1)
            return false;
        p = (x - level < 0 ? 0 : prefix_c[y][x - level]);
        int col_s = prefix_c[y][x + level - 1] - p;
        return (col_s == 2 * level - 1);
    }
}
