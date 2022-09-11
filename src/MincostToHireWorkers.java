import java.util.Arrays;
import java.util.PriorityQueue;

public class MincostToHireWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] wpq_q = new double[n][2];
        for (int i = 0; i < n; i++) {
            wpq_q[i][0] = wage[i] * 1.0 / quality[i];
            wpq_q[i][1] = quality[i];
        }
        Arrays.sort(wpq_q, (a, b) -> (a[0] - b[0] > 0 ? 1 : -1));
        PriorityQueue<double[]> candidate_k = new PriorityQueue<>((a, b) -> (int)(b[1] - a[1]));
        int cur_r = k - 1;
        double cur_wpq = wpq_q[k - 1][0];
        int q_sum = 0;
        for (int i = 0; i < k; i++) {
            candidate_k.add(wpq_q[i]);
            q_sum += wpq_q[i][1];
        }
        double ans = q_sum * cur_wpq;
        while (cur_r < n - 1) {
            cur_r++;
            cur_wpq = wpq_q[cur_r][0];
            candidate_k.add(wpq_q[cur_r]);
            double[] dropped = candidate_k.poll();
            System.out.println(dropped[1]);
            q_sum = (int) (q_sum + wpq_q[cur_r][1] - dropped[1]);
            ans = Math.min(ans, q_sum * cur_wpq);
        }
        return ans;
    }
}
