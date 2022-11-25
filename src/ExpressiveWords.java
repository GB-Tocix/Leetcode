import java.util.ArrayList;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        ArrayList<int[]> rec = new ArrayList<>();
        int pre = s.charAt(0) - 'a';
        int cnt = 1;
        for (int i = 1; i <= s.length(); i++) {
            int cur = (i == s.length() ? -1 : s.charAt(i) - 'a');
            if (i != s.length() && cur == pre)
                cnt++;
            else {
                rec.add(new int[]{pre, cnt});
                pre = cur;
                cnt = 1;
            }
        }
        int ans = 0;
        for (String word : words) {
            int pos = 0;
            int count = 0;
            boolean flag = true;
            int i = 0;
            while (i < word.length()) {
                if (word.charAt(i) - 'a' == rec.get(pos)[0]) {
                    count++;
                    i++;
                }
                else {
                    if (count == 0 || rec.get(pos)[1] <= 2 && count != rec.get(pos)[1] || count > rec.get(pos)[1]) {
                        flag = false;
                        break;
                    }
                    pos++;
                    if (pos >= rec.size()) {
                        flag = false;
                        break;
                    }
                    count = 0;
                }
            }
            if (pos >= rec.size() || count == 0 || rec.get(pos)[1] <= 2 && count != rec.get(pos)[1] || count > rec.get(pos)[1] || pos != rec.size() - 1)
                flag = false;
            ans += flag ? 1 : 0;
        }
        return ans;
    }
}
