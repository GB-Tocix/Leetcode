import java.util.PriorityQueue;


class BestRotation {
    public int bestRotation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int cur = 0;
        while (cur < n) {
            if (cur - nums[cur] >= 0)
                pq.add(n + cur - nums[cur]);
            cur++;
        }
        int ans = 0;
        int maximum = pq.size();
        cur = 0;
        while (cur < n - 1) {
            pq.add(n + cur + 1 + (n - 1 - nums[cur]));
            while (!pq.isEmpty() && pq.peek() <= cur + n)
                pq.poll();
            if (pq.size() > maximum) {
                maximum = pq.size();
                ans = cur + 1;
            }
            cur++;
        }
        return ans;
    }

    // with no priority queue, improve complexity from O(nlogn) to O(n)
    public int bestRotation_v2(int[] nums) {
        int n = nums.length;
        int[] sup = new int[2 * n - 1];
        int cur = 0;
        int ans = 0;
        int maximum = 0;
        while (cur < n) {
            if (cur - nums[cur] >= 0) {
                sup[cur - nums[cur]]++;
                maximum++;
            }
            cur++;
        }
        cur = 0;
        int sum = maximum;
        while (cur < n - 1) {
            sup[cur + n - nums[cur]]++;
            sum -= (sup[cur] - 1);
            if (sum > maximum) {
                maximum = sum;
                ans = cur + 1;
            }
            cur++;
        }
        return ans;
    }
}