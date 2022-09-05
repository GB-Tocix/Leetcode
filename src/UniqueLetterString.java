import java.util.Arrays;

public class UniqueLetterString {
    public int uniqueLetterString(String s) {
        int[] index_last_time_showing = new int[26];
        int len = s.length();
        int[] index_pre = new int[len];
        int[] index_nxt = new int[len];
        Arrays.fill(index_last_time_showing, -1);
        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i) - 'A';
            int last_cur = index_last_time_showing[cur];
            index_pre[i] = last_cur;
            index_last_time_showing[cur] = i;
        }
        Arrays.fill(index_last_time_showing, len);
        for (int i = len - 1; i >= 0; i--) {
            int cur = s.charAt(i) - 'A';
            int last_cur = index_last_time_showing[cur];
            index_nxt[i] = last_cur;
            index_last_time_showing[cur] = i;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += (i - index_pre[i]) * (index_nxt[i] - i);
        }
        return ans;
    }
}
