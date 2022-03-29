import java.util.ArrayList;

class MaxConsecutiveAnswers {
    ArrayList<Integer> answerKeyCount;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        answerKeyCount = new ArrayList<>();
        answerKeyCount.add(0);
        answerKeyCount.add(0);
        char cur = answerKey.charAt(0);
        int count = 1;
        int i = 1;
        while (i < answerKey.length()) {
            if (answerKey.charAt(i) == cur)
                count++;
            else {
                cur = answerKey.charAt(i);
                answerKeyCount.add(count);
                count = 1;
            }
            i++;
        }
        answerKeyCount.add(count);

        int ans = 0;
        for (int iter = 2; iter <= 3; iter++) {
            if (iter >= answerKeyCount.size())
                break;
            int curSum = answerKeyCount.get(iter);
            int usedChance = 0;
            int l = iter;
            int r = iter;
            if (answerKeyCount.get(iter - 1) <= k) {
                l = iter - 2;
                curSum += answerKeyCount.get(iter - 1);
                usedChance = answerKeyCount.get(iter - 1);
            }
            ans = Math.max(ans, curSum + (k - usedChance));
            while (r + 1 < answerKeyCount.size()) {
                if (answerKeyCount.get(r + 1) + usedChance > k) {
                    if (l == r) {
                        if (l + 2 >= answerKeyCount.size())
                            break;
                        curSum = answerKeyCount.get(l + 2);
                        usedChance = 0;
                        ans = Math.max(ans, curSum + (k - usedChance));
                        l += 2;
                        r += 2;
                    } else {
                        curSum -= answerKeyCount.get(l);
                        curSum -= answerKeyCount.get(l + 1);
                        usedChance -= answerKeyCount.get(l + 1);
                        l += 2;
                    }
                } else {
                    curSum += answerKeyCount.get(r + 1);
                    if (r + 2 < answerKeyCount.size())
                        curSum += answerKeyCount.get(r + 2);
                    usedChance += answerKeyCount.get(r + 1);
                    r += 2;
                    ans = Math.max(ans, curSum + (k - usedChance));
                }
            }
        }
        return Math.min(ans, answerKey.length());
    }
}