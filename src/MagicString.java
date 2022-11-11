import java.util.LinkedList;
import java.util.Queue;

class MagicalString {
    public int magicalString(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(2);
        int i = 3;
        int ans = 1;
        int nxt_s = 1;
        int nxt_i;
        while (i < n) {
            nxt_i = q.poll();
            System.out.println();
            System.out.println("i: " + nxt_i);
            for (int j = 0; j < nxt_i; j++) {
                q.offer(nxt_s);
                System.out.print("s: " + nxt_s);
                if (nxt_s == 1)
                    ans++;
                i++;
                if (i >= n)
                    return ans;
            }
            nxt_s = 3 - nxt_s;
        }
        return ans;
    }
}