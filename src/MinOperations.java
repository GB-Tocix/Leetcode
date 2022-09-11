public class MinOperations {
    public int minOperations(String[] logs) {
        int cur_depth = 0;
        for (String log: logs) {
            if (log.equals("../"))
                cur_depth = Math.max(0, cur_depth - 1);
            else if(!log.equals("./"))
                cur_depth++;
        }
        return cur_depth;
    }
}
