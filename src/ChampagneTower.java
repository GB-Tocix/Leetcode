public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int n = query_row + 1;
        double[] line = new double[n];
        line[0] = poured;
        for (int i = 1; i < n; i++) {
            double[] nxt = new double[n];
            nxt[0] = line[0] / 2;
            for (int j = 1; j <= i; j++) {
                nxt[j] = (Math.max(line[j] - 1, 0) + Math.max(0, line[j - 1] - 1)) / 2;
            }
            line = nxt;
        }
        return Math.min(1, line[query_glass]);
    }
}
