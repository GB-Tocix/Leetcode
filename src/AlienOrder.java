class AlienOrder {

    public String alienOrder(String[] words) {
        if (words.length == 1)
            return words[0];
        int numHasRelation = 0;
        int[] income = new int[26];
        boolean[] shown = new boolean[26];
        boolean[] hasRelation = new boolean[26];
        boolean[][] smaller = new boolean[26][26];

        for (int i = 0; i < words.length - 1; i++) {
            String A = words[i];
            String B = words[i + 1];
            int j = 0;
            int index = Math.min(A.length(), B.length());
            boolean flag = true;
            while (j < index) {
                int indexA = A.charAt(j) - 'a';
                int indexB = B.charAt(j) - 'a';
                if (flag && A.charAt(j) != B.charAt(j)) {
                    if (!smaller[indexA][indexB]) {
                        smaller[indexA][indexB] = true;
                        income[indexB] += 1;
                    }
                    hasRelation[indexA] = true;
                    hasRelation[indexB] = true;
                    flag = false;
                }
                shown[indexA] = true;
                shown[indexB] = true;
                j++;
            }
            if (flag && A.length() > B.length()) {
                    return "";
            }
            while (j < A.length()) {
                shown[A.charAt(j) - 'a'] = true;
                j++;
            }
            while (j < B.length()) {
                shown[B.charAt(j) - 'a'] = true;
                j++;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (shown[i] && !hasRelation[i])
                ans.insert(0, (char)(i + 'a'));
            if (hasRelation[i])
                numHasRelation++;
        }

        while (numHasRelation > 0) {
            int originLen = ans.length();
            for (int i = 0; i < 26; i++) {
                if (hasRelation[i] && income[i] == 0) {
                    ans.append((char) (i + 'a'));
                    hasRelation[i] = false;
                    for (int j = 0; j < 26; j++) {
                        if (smaller[i][j])
                            income[j]--;
                    }
                    break;
                }
            }
            if (ans.length() == originLen)
                return "";
            numHasRelation--;
        }

        return ans.toString();
    }
}