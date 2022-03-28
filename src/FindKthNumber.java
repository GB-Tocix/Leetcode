class FindKthNumber {
    long n;
    int k;
    int cur;
    int res;

    public int findKthNumber(int _n, int _k) {
        cur = 1;
        n = _n;
        k = _k;
        cur = 0;
        return search(0, 1);
    }

    public int search(int base, int begin) {
        int i = begin;
        for (; i < 10; i++) {
            if (cur + 1 == k)
                return base * 10 + i;
            int num = count(base * 10L + i, base * 10L + i);
            if (cur + num < k)
                cur += num;
            else {
                cur += 1;
                return search(base * 10 + i, 0);
            }
        }
        return -1;
    }

    public int count(long first, long last) {
        if (first > n)
            return 0;
        return (int)(Math.min(last, n) - first + 1 + count(first * 10, last * 10 + 9));
    }
}