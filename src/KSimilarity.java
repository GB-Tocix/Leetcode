import java.util.LinkedList;
import java.util.Queue;

class KSimilarity {
    public int kSimilarity(String s1, String s2) {
        Queue<String> s_queue = new LinkedList<>();
        Queue<Integer> i_queue = new LinkedList<>();
        int used_steps = 0;
        s_queue.add(s1);
        i_queue.add(used_steps);
        while (!s_queue.isEmpty() && !i_queue.isEmpty()) {
            String s_tmp = s_queue.poll();
            int i_tmp = i_queue.poll();
            if (s_tmp.equals(s2)) {
                return i_tmp;
            }
            int first_diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s_tmp.charAt(i) != s2.charAt(i)) {
                    first_diff = i;
                    break;
                }
            }
            for (int i = first_diff + 1; i < s1.length(); i++) {
                if (s_tmp.charAt(i) != s2.charAt(i) && s_tmp.charAt(i) == s2.charAt(first_diff)) {
                    StringBuilder s_generated = new StringBuilder(s_tmp);
                    char p = s_tmp.charAt(first_diff);
                    s_generated.setCharAt(first_diff, s_tmp.charAt(i));
                    s_generated.setCharAt(i, p);
                    s_queue.add(s_generated.toString());
                    i_queue.add(i_tmp + 1);
                }
            }
        }
        return -1;
    }
}