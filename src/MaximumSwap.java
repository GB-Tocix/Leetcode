import java.util.ArrayList;


class MaximumSwap {
    public int maximumSwap(int num) {
        if (num == 0 || 100000000 == num)
            return num;
        ArrayList<Integer> l = new ArrayList<>();
        int num_b = num;
        while (num > 0) {
            l.add(num % 10);
            num /= 10;
        }
        int len = l.size();
        int i = len - 1;
        while (i >= 1) {
            int m = 0;
            for (int j = 1; j < i; j++)
                if (l.get(m) < l.get(j))
                    m = j;
            if (l.get(m) > l.get(i)) {
                int p = l.get(m);
                l.set(m, l.get(i));
                l.set(i, p);
                p = 1;
                int ans = 0;
                for (int x: l) {
                    ans += x * p;
                    p *= 10;
                }
                return ans;
            }
            i--;
        }
        return num_b;
    }
}