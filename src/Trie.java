class Trie {

    boolean flag;
    Trie[] children;

    public Trie() {
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

    public boolean startsWith(String prefix) {
        Trie p = this;
        int i = 0;
        while (i < prefix.length()) {
            int pos = prefix.charAt(i) - 'a';
            if (p.children[pos] == null)
                return false;
            p = p.children[pos];
            i++;
        }
        if (p.flag)
            return true;
        for (Trie child: p.children)
            if (child != null)
                return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */