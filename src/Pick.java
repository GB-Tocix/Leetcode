import java.util.Random;

public class Pick {
    int n;
    int sum;
    int[] count;
    int[][] rects;
    Random rand;

    public Pick(int[][] _rects) {
        rects = _rects;
        n = rects.length;
        count = new int[n];
        int i = 0;
        for (int[] r: rects) {
            count[i] = (r[3] - r[1] + 1) * (r[2] - r[0] + 1);
            if (i != 0)
                count[i] += count[i - 1];
            i++;
        }
        sum = count[n - 1];
        rand = new Random();
    }

    public int[] pick() {
        int r = rand.nextInt(sum);
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + ((j - i) >> 1);
            if (r < count[mid])
                j = mid;
            else
                i = mid + 1;
        }
        if (j != 0)
            r -= count[j - 1];
        int col = rects[j][3] - rects[j][1] + 1;
        return new int[]{r / col, r % col};
    }
}
