class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int[] take = new int[]{128, 224, 240, 248};
        int[] codes = new int[]{0, 192, 224, 240};
        int tn = 192;
        int cn = 128;
        int cur = 0;
        int n = data.length;
        while (cur < n) {
            int len = -1;
            for (int i = 0; i < 4; i++) {
                if ((data[cur] & take[i]) == codes[i]) {
                    len = i + 1;
                    break;
                }
            }
            if (len == -1 || cur + len - 1 >= n)
                return false;
            for (int i = 1; i < len; i++) {
                if ((data[cur + i] & tn) != cn)
                    return false;
            }
            cur = cur + len;
        }
        return true;
    }
}