import java.util.Stack;

public class AtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] les = new int[11];
        int[] leq = new int[11];
        for (int i = 0; i < digits.length; i++)
            leq[Integer.parseInt(digits[i])] = les[Integer.parseInt(digits[i]) + 1] = i + 1;
        for (int i = 1; i <= 9; i++) {
            leq[i] = Math.max(leq[i - 1], leq[i]);
            les[i] = Math.max(les[i - 1], les[i]);
        }
        int ans = 0;
        int cur = 1;
        Stack<Integer> partial_n = new Stack<>();
        while (n > 0) {
            ans += cur;
            partial_n.push(n % 10);
            cur *= digits.length;
            n /= 10;
        }
        boolean eq = true;
        while (!partial_n.isEmpty()) {
            int pn = partial_n.pop();
            cur /= digits.length;
            ans += les[pn] * cur;
            if (leq[pn] == les[pn]) {
                eq = false;
                break;
            }
        }
        return ans - 1 + (eq ? 1 : 0);
    }
}
