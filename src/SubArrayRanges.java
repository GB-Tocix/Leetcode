import java.util.Stack;

class SubArrayRanges {
    public long subArrayRanges(int[] nums) {
        Stack<int[]> maxStack = new Stack<>();
        Stack<int[]> minStack = new Stack<>();
        long ansA = 0, ansB = 0;
        int[] cur;

        for (int i = 0; i < nums.length; i++) {
            // 递减栈
            while (!maxStack.empty() && maxStack.peek()[0] <= nums[i]) {
                cur = maxStack.pop();
                int pre = maxStack.empty() ? -1 : maxStack.peek()[1];
                ansA = ansA + (long) (i - cur[1]) * (cur[1] - pre) * cur[0];
            }
            // 递增栈
            while (!minStack.empty() && minStack.peek()[0] > nums[i]) {
                cur = minStack.pop();
                int pre = minStack.empty() ? -1 : minStack.peek()[1];
                ansB = ansB + (long) (i - cur[1]) * (cur[1] - pre) * cur[0];
            }
            maxStack.push(new int[]{nums[i], i});
            minStack.push(new int[]{nums[i], i});
        }

        // 统计
        while (!maxStack.empty()) {
            cur = maxStack.pop();
            int pre = maxStack.empty() ? -1 : maxStack.peek()[1];
            ansA = ansA + (long) (nums.length - cur[1]) * (cur[1] - pre) * cur[0];
        }

        while (!minStack.empty()) {
            cur = minStack.pop();
            int pre = minStack.empty() ? -1 : minStack.peek()[1];
            ansB = ansB + (long) (nums.length - cur[1]) * (cur[1] - pre) * cur[0];
        }

        return ansA - ansB;
    }
}