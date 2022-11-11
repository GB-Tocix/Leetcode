import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class BestCoordinate {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] map = new int[51][51];
        int[] range = new int[radius + 1];
        int c2 = radius * radius;
        int ans[] = new int[2];
        int best = 0;
        for (int i = 0; i <= radius; i++) {
            range[i] = (int)Math.floor(Math.sqrt(c2 - i * i));
        }
        for (int[] tower: towers) {
            int x = tower[0];
            int y = tower[1];
            int p = tower[2];
            for (int i = -radius; i <= radius; i++) {
                if (x + i < 0)
                    continue;
                if (x + i > 50)
                    break;
                for (int j = -range[Math.abs(i)]; j <= range[Math.abs(i)]; j++) {
                    map[x + i][y + j] += Math.floor(p / Math.sqrt(i * i + j * j));
                }
            }
        }
        for (int i = 0; i <= 50; i++)
            for (int j = 0; j <= 50; j++)
                if (map[i][j] > best) {
                    best = map[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
        return ans;
    }
}
