class NumArray {

    int MAXN;
    int[] tree;
    int[] nums;

    public NumArray(int[] nums) {
        MAXN = nums.length + 5;
        tree = new int[MAXN];
        this.nums = nums;
        for (int i = 1; i <= nums.length; i++) {
            updateTree(i, nums[i - 1]);
        }
    }

    public void update(int index, int val) {
        updateTree(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public void updateTree(int index, int val) {
        for (int pos = index; pos < MAXN; pos += lowbit(pos))
            tree[pos] += val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    public int query(int n) {
        int ans = 0;
        for (int pos = n; pos > 0; pos -= lowbit(pos))
            ans += tree[pos];
        return ans;
    }

    public int lowbit(int x) {
        return x & (-x);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */