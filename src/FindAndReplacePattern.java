import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word: words) {
            if (match(word, pattern))
                ans.add(word);
        }
        return ans;
    }

    boolean match(String word, String pattern) {
        if (word.length() != pattern.length())
            return false;
        int[] map = new int[26];
        boolean[] occupied = new boolean[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';
            if (map[p] == w)
                continue;
            if (map[p] == -1 && !occupied[w]) {
                map[p] = w;
                occupied[w] = true;
            }
            else
                return false;
        }
        return true;
    }
}
