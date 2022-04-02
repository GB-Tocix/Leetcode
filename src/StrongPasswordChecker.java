public class StrongPasswordChecker {

    public int strongPasswordChecker(String password) {
        int[] countTypes = new int[4];
        int types = 0;
        int n = password.length();
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = getType(password.charAt(i));
            if (tmp >= 0 && countTypes[tmp] == 0) {
                types++;
                countTypes[tmp] = 1;
            }
        }
        // 小于 6
        if (n < 6)
            return Math.max(6 - n, 3 - types);
        // 统计相同字符连续长度超过3的片段
        char cur;
        int count;
        int i = 0;
        int times_change = 0;
        countTypes = new int[3];
        while (i < n) {
            cur = password.charAt(i);
            count = 1;
            while (i + 1 < n && password.charAt(i + 1) == cur) {
                i++;
                count++;
            }
            if (count >= 3) {
                tmp = count / 3;
                times_change += tmp;
                countTypes[count % 3]++;
                countTypes[2] += tmp - 1;
            }
            i++;
        }
        // 在 6 到 20 之间的闭区间内
        if (n <= 20)
            return Math.max(times_change, 3 - types);
        i = 0;
        tmp = n;
        while (n > 20 && i < 3) {
            if (countTypes[i] == 0)
                i++;
            else {
                if (n - (i + 1) < 20) break;
                n -= (i + 1);
                times_change--;
                countTypes[i]--;
            }
        }
        return tmp - 20 + Math.max(times_change, 3 - types);
    }

    public int getType(char c) {
        if (Character.isDigit(c)) return 0;
        if (Character.isUpperCase(c)) return 1;
        if (Character.isLowerCase(c)) return 2;
        return -1;
    }
}
