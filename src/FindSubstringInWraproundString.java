import java.util.Arrays;

public class FindSubstringInWraproundString {
    int[] longest_trace;

    public int findSubstringInWraproundString(String p) {
        longest_trace = new int[26];
        char pre = p.charAt(0);
        char cur;
        longest_trace[pre - 'a'] = 1;
        int combo = 1;
        for (int i = 1; i < p.length(); i++) {
            cur = p.charAt(i);
            if (cur - pre == 1 || cur - pre == -25)
                combo++;
            else
                combo = 1;
            longest_trace[cur - 'a'] = Math.max(longest_trace[cur - 'a'], combo);
            pre = cur;
        }
        return Arrays.stream(longest_trace).sum();
    }
}
