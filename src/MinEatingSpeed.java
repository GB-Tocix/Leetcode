public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int e: piles)
            r = Math.max(e, r);
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            boolean available = true;
            int usedTime = 0;
            for (int e: piles) {
                usedTime += e / mid;
                usedTime += (e % mid == 0) ? 0 : 1;
                if (usedTime > h) {
                    available = false;
                    break;
                }
            }
            if (available)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
