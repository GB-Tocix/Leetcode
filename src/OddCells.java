public class OddCells {
    boolean[] row_changed;
    boolean[] col_changed;

    public int oddCells(int m, int n, int[][] indices) {
        row_changed = new boolean[m];
        col_changed = new boolean[n];
        for (int[] ind: indices) {
            row_changed[ind[0]] ^= true;
            col_changed[ind[1]] ^= true;
        }
        int col_count = 0;
        for (boolean b : row_changed)
            col_count += (b ? 1 : 0);
        int ans = 0;
        for (boolean b : col_changed)
            ans += (b ? m - col_count : col_count);
        return ans;
    }
}
