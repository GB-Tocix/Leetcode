import java.util.ArrayList;
import java.util.List;

public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(positions[0][1]);
        int curl;
        int curr;
        int coml;
        int comr;
        for (int i = 1; i < positions.length; i++) {
            curl = positions[i][0];
            curr = positions[i][1] + curl;
            ans.add(positions[i][1]);
            int base = positions[i][1];
            for (int j = 0; j < i; j++) {
                coml = positions[j][0];
                comr = positions[j][1] + coml;
                if (curl < comr && curr > coml)
                    ans.set(i, Math.max(ans.get(i), ans.get(j) + base));
            }
        }
        for (int i = 1; i < positions.length; i++)
            ans.set(i, Math.max(ans.get(i), ans.get(i - 1)));
        return ans;
    }
}
