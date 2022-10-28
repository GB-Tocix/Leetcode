import java.util.*;

// HJ16 on newcoder

public class Good {
    //父编码
    public int parentIndex = -1;
    //价格
    public int value;
    //权重（满意度）
    public int weight;
    //附件
    public List<Good> children = new ArrayList<>();

    public int vw() {
        return value * weight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        //可支配金额
        int mySumValue = Integer.valueOf(strs[0]);
        int size = Integer.valueOf(strs[1]);
        //主件Map
        Map<Integer, Good> mainGoodMap = new HashMap<>();
        //附件List
        List<Good> cGoods = new ArrayList<>();
//        List<Good> mainGoods = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < size; i++) {
            strs = in.nextLine().split(" ");
            Good good = new Good();
            good.value = Integer.valueOf(strs[0]);
            good.weight = Integer.valueOf(strs[1]);
            int chooseIndex = Integer.valueOf(strs[2]);
            if (chooseIndex == 0) {
                //主件
                mainGoodMap.put(index, good);
            } else {
                //附件
                good.parentIndex = chooseIndex;
                cGoods.add(good);
            }
            index++;
        }
        //组装出组合模式，将附件塞入主件
        for (Good child : cGoods) {
            mainGoodMap.get(child.parentIndex).children.add(child);
        }
        Good[] mainGoods = new Good[mainGoodMap.keySet().size()];
        index = 0;
        for (int key : mainGoodMap.keySet()) {
            mainGoods[index] = mainGoodMap.get(key);
            index++;
        }
        int[][] dp = new int[mySumValue][mainGoods.length];
        //初始化dp
        for (int i = 0; i < mySumValue; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < mainGoods.length; i++) {
            dp[0][i] = 0;
        }
        //用i元只允许买前j件主物品，最大收益为dp[i][j]
        for (int i = 1; i < mySumValue; i++) {
            for (int j = 1; j < mainGoods.length; j++) {
                Good good = mainGoods[j-1];
                dp[i][j] = dp[i][j - 1];
                if (good.children.size() == 0) {
                    //无附件【1.买主件；2.不买主件】
                    if (i - good.value >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value][j] + good.vw());
                    }
                } else if (good.children.size() == 1) {
                    //有一个附件【1.买主件与附件；2.只买主件；3.不买主件】
                    Good child = good.children.get(0);
                    if (i - good.value - child.value >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - child.value][j] + good.vw() + child.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value][j] + good.vw());
                    } else if (i - good.value > 0) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - good.value][j] + good.vw());
                    }
                } else {
                    //两个附件【1.买主件与附件1和2； 2.买主件与附件1； 3.买主件与附件2； 4.只买主件； 5.不买主件】
                    Good bigChild = good.children.get(0);
                    Good smallChild = good.children.get(1);
                    if (smallChild.value > bigChild.value) {
                        smallChild = good.children.get(0);
                        bigChild = good.children.get(1);
                    }
                    if (i - good.value - bigChild.value - smallChild.value > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - bigChild.value - smallChild.value][j] + good.vw() + bigChild.vw() + smallChild.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - bigChild.value][j] + good.vw() + bigChild.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - smallChild.value][j] + good.vw() + smallChild.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value][j] + good.vw());
                    } else if (i - good.value - bigChild.value > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - bigChild.value][j] + good.vw() + bigChild.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - smallChild.value][j] + good.vw() + smallChild.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value][j] + good.vw());
                    } else if (i - good.value - smallChild.value > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value - smallChild.value][j] + good.vw() + smallChild.vw());
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value][j] + good.vw());
                    } else if (i - good.value > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - good.value][j] + good.vw());
                    }
                }
            }
        }
        System.out.println("dp[mySumValue-1][mainGoods.length-1]===>" + dp[mySumValue - 1][mainGoods.length - 1]);
    }
}