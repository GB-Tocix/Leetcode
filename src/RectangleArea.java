import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RectangleArea {
    HashMap<Integer, Integer> ori_to_pro;
    HashMap<Integer, Integer> pro_to_ori;

    int[] count(int[][] rectangles) {
        HashSet<Integer> index = new HashSet<>();
        for (int[] rectangle: rectangles)
            for (int ind: rectangle)
                index.add(ind);
        int[] res = new int[index.size()];
        int i = 0;
        for (int e: index) {
            res[i] = e;
            i++;
        }
        Arrays.sort(res);
        return res;
    }

    public int rectangleArea(int[][] rectangles) {
        ori_to_pro = new HashMap<>();
        pro_to_ori = new HashMap<>();
        int[] index = count(rectangles);
        int n = index.length;
        for (int i = 0; i < n; i++) {
            ori_to_pro.put(index[i], i);
            pro_to_ori.put(i, index[i]);
        }
        boolean[][] covered = new boolean[n - 1][n - 1];
        for (int[] rectangle: rectangles) {
            int x1 = ori_to_pro.get(rectangle[0]);
            int y1 = ori_to_pro.get(rectangle[1]);
            int x2 = ori_to_pro.get(rectangle[2]);
            int y2 = ori_to_pro.get(rectangle[3]);
            for (int i = x1; i < x2; i++)
                for (int j = y1; j < y2; j++)
                    covered[i][j] = true;
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1; j++) {
                if (covered[i][j]) {
                    long x1 = pro_to_ori.get(i);
                    long y1 = pro_to_ori.get(j);
                    long x2 = pro_to_ori.get(i + 1);
                    long y2 = pro_to_ori.get(j + 1);
                    ans += (y2 - y1) * (x2 - x1);
                }
            }
        return (int) (ans % 1000000007);
    }
}
