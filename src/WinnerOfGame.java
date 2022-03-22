public class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        int[] AB = new int[2];
        char[] c = new char[]{'A', 'B'};
        int cur = colors.charAt(0) == 'A' ? 0 : 1;
        int cnt = 1;
        int i = 1;
        while (i < colors.length()) {
            if (colors.charAt(i) == c[cur])
                cnt++;
            else {
                AB[cur] += Math.max(cnt - 2, 0);
                cur = 1 - cur;
                cnt = 1;
            }
            i++;
        }
        AB[cur] += Math.max(cnt - 2, 0);
        return AB[0] >= AB[1] + 1;
    }
}
