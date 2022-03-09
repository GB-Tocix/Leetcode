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
}