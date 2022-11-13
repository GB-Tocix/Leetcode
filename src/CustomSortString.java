import java.util.Arrays;

public class CustomSortString {
    public String customSortString(String order, String s) {
        char[] rank = new char[26];
        int[] times = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            rank[i] = c;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            times[c - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < order.length(); i++) {
            if (times[rank[i] - 'a'] > 0) {
                for (int j = 0; j < times[rank[i] - 'a']; j++) {
                    sb.append(rank[i]);
                }
                times[rank[i] - 'a'] = 0;
            }
        }
        for (int i = 0; i < 26; i++)
            if (times[i] > 0)
                for (int j = 0; j < times[i]; j++)
                    sb.append((char)('a' + i));
        return sb.toString();
    }
}
