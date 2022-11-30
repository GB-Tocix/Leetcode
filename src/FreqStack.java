import java.util.HashMap;
import java.util.PriorityQueue;

public class FreqStack {
    int order;
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> cnt;

    public FreqStack() {
        order = 0;
        pq = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : b[2] - a[2]));
        cnt = new HashMap<>();
    }

    public void push(int val) {
        int already = cnt.getOrDefault(val, 0);
        cnt.put(val, already + 1);
        pq.offer(new int[]{val, already + 1, order});
        order++;
    }

    public int pop() {
        assert (!pq.isEmpty());
        int res = pq.poll()[0];
        cnt.put(res, cnt.get(res) - 1);
        return res;
    }
}
