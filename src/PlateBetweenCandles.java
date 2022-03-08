class PlateBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] leftFind = new int[len];
        int[] rightFind = new int[len];
        leftFind[0] = s.charAt(0) == '|' ? 0 : -1;
        rightFind[len - 1] = s.charAt(len - 1) == '|' ? len - 1 : -1;
        for (int i = 1; i < len; i++) {
            leftFind[i] = s.charAt(i) == '|' ? i : leftFind[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightFind[i] = s.charAt(i) == '|' ? i : rightFind[i + 1];
        }
        int[] ans = new int[queries.length];
        int[] prefix = new int[s.length() + 1];
        prefix[0] = 0;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) == '*')
                prefix[i] = prefix[i - 1] + 1;
            else
                prefix[i] = prefix[i - 1];
        }

        int i = 0;
        for (int[] query: queries) {
            int l = query[0];
            int r = query[1];
            int rightTarget = rightFind[l];
            int leftTarget = leftFind[r];
            if (rightTarget == -1 || leftTarget == -1 || leftTarget <= rightTarget) {
                ans[i] = 0;
            }
            else {
                ans[i] = prefix[leftTarget] - prefix[rightTarget];
            }
            i++;
        }

        return ans;
    }
}
