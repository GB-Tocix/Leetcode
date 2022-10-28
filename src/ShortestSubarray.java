import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> rec = new LinkedList<>();
        long sum = 0;
        int i = 0;
        int n = nums.length;
        int ans = -1;
        while (i < n) {
            if (nums[i] < 0 && -nums[i] >= sum) {
                rec = new LinkedList<>();
                sum = 0;
            }
            else {
                if (nums[i] > 0) {
                    rec.addFirst(nums[i]);
                    sum += nums[i];
                }
                else {
                    int x = nums[i];
                    int count = 1;
                    while (x < 0) {
                        int first = rec.pollFirst();
                        if (first >= -x) {
                            first += x;
                            x = 0;
                            rec.addFirst(first);
                        }
                        else {
                            x += first;
                            count++;
                        }
                    }
                    for (int j = 0; j < count; j++)
                        rec.addFirst(0);
                    sum += nums[i];
                }
            }
            while (rec.size() > 0 && sum - rec.peekLast() >= k)
                sum -= rec.pollLast();
            if (sum >= k && (rec.size() < ans || ans == -1))
                ans = rec.size();
            i++;
        }
        return ans;
    }
}
