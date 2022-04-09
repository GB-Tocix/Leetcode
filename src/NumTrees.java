class NumTrees {
    int[] record;

    public NumTrees() {
        record = new int[20];
        record[0] = record[1] = 1;
    }

    public int numTrees(int n) {
        if (record[n] != 0) return record[n];
        for (int i = 1; i <= n; i++) {
            record[n] += numTrees(i - 1) * numTrees(n - i);
        }
        return record[n];
    }
}