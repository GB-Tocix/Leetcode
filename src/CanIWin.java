import java.util.HashMap;

public class CanIWin {
    HashMap<Integer, Boolean> map;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal)
            return false;
        map = new HashMap<>();
        return solve((int)Math.pow(2, maxChoosableInteger) - 1, desiredTotal);
    }

    public boolean solve(int code, int desiredTotal) {
        if (code == 0)
            return false;
        if (map.containsKey(code))
            return map.get(code);
        int p = code;
        int i = 0;
        while (p > 0) {
            i++;
            p = p >> 1;
        }
        if (i >= desiredTotal) {
            map.put(code, true);
            return true;
        }
        i = 1;
        int b = 1;
        p = code;
        while (p > 0) {
            if ((p & 1) == 1) {
                boolean res = solve(code ^ b, desiredTotal - i);
                if (!res) {
                    map.put(code, true);
                    return true;
                }
            }
            b = b << 1;
            p = p >> 1;
            i++;
        }
        map.put(code, false);
        return false;
    }
}
