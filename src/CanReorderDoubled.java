import java.util.Arrays;
import java.util.HashMap;

public class CanReorderDoubled {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e: arr)
            map.put(e, map.getOrDefault(e, 0) + 1);
        for (int e: arr) {
            if (map.get(e) == 0)
                continue;
            if (map.getOrDefault(e * 2, 0) != 0)
                map.put(e * 2, map.get(e * 2) - 1);
            else if (e % 2 == 0 && map.getOrDefault(e / 2, 0) != 0)
                map.put(e / 2, map.get(e / 2) - 1);
            else
                return false;
            map.put(e, map.get(e) - 1);
        }
        return true;
    }
}