import java.util.Arrays;
import java.util.Comparator;

class LongestWord {

    static private class Trie {

        boolean flag;
        String longest;
        Trie[] children;

        public Trie() {
            longest = "";
            flag = false;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie p = this;
            int i = 0;
            while (i < word.length()) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null)
                    p.children[pos] = new Trie();
                p = p.children[pos];
                i++;
            }
            p.flag = true;
        }

        public boolean search(String word) {
            Trie p = this;
            int i = 0;
            while (i < word.length()) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null)
                    return false;
                p = p.children[pos];
                i++;
            }
            return p.flag;
        }

        public String getLongest() {
            StringBuilder sb = new StringBuilder();
            Trie p = this;
            dfs(p, sb);
            return longest;
        }

        public void dfs(Trie p, StringBuilder sb) {
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                Trie child = p.children[i];
                if (child != null) {
                    flag = true;
                    sb.append((char)('a' + i));
                    dfs(child, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            if (!flag && p.flag) {
                String cur = sb.toString();
                if (cur.length() > longest.length())
                    longest = cur;
                else if (cur.length() == longest.length()) {
                    for (int i = 0; i < cur.length(); i++) {
                        if (cur.charAt(i) == longest.charAt(i)) continue;
                        if (cur.charAt(i) < longest.charAt(i))
                            longest = cur;
                        return;
                    }
                }
            }
        }
    }

    public String longestWord(String[] word) {
        Arrays.sort(word, Comparator.comparingInt(String::length));
        Trie root = new Trie();
        for (String w: word) {
            String sub = w.substring(0, w.length() - 1);
            if (sub.length() == 0 || root.search(sub))
                root.insert(w);
        }
        return root.getLongest();
    }
}