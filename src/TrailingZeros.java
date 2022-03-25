class TrailingZeroes {
    public int trailingZeroes(int n) {
        int cnt2 = 0;
        int cnt5 = 0;
        int base2 = 2;
        int base5 = 5;
        while (base2 <= n) {
            cnt2 += n / base2;
            base2 *= 2;
        }
        while (base5 <= n) {
            cnt5 += n / base5;
            base5 *= 5;
        }
        return Math.min(cnt2, cnt5);
    }
}