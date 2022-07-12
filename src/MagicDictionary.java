class MagicDictionary {
    String[] dictionary;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word: dictionary) {
            if (word.length() != searchWord.length())
                continue;
            int diff = 0;
            for (int i = 0; i < searchWord.length(); i++)
                if (searchWord.charAt(i) != word.charAt(i)) {
                    diff++;
                    if (diff > 1)
                        break;
                }
            if (diff == 1)
                return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */