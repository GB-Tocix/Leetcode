class CountMaxOrSubsets {
    int target;
    int[] nums;
    public int countMaxOrSubsets(int[] _nums) {
        target = 0;
        nums = _nums;
        for (int num: nums)
            target = (target | num);
        return dfs(0, 0);
    }

    public int dfs(int index, int cur) {
        if (index >= nums.length)
            return 0;
        int skip = dfs(index + 1, cur);
        cur = cur | nums[index];
        if (cur == target)
            return (1 << (nums.length - index - 1)) + skip;
        else
            return skip + dfs(index + 1, cur);
    }
}