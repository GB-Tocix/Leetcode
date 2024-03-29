# 刷题记录

[**编程笔记**](/notes/index)

<br>

### 11-26】[882. 细分图中的可到达节点](https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/)

**难度**：困难

**标签**：图，最短路，堆（优先队列）

**代码**：[ReachableNodes.java](src/ReachableNodes.java)

**笔记**：
- 模仿 dijkstra 思路
- 但是要记住该方法应与优先队列配合，贪心想法

<br>

### 11-25】[809. 情感丰富的文字](https://leetcode.cn/problems/expressive-words/)

**难度**：中等

**标签**：数组，字符串，双指针

**代码**：[ExpressiveWords.java](src/ExpressiveWords.java)

**笔记**：
- 写的有些冗长
- 应该使用双指针

<br>

### 11-24】[795. 区间子数组个数](https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/)

**难度**：中等

**标签**：数组，双指针，（单调栈）

**代码**：[NumSubarrayBoundedMax.java](src/NumSubarrayBoundedMax.java)

**笔记**：
- 个人使用了**单调栈**，但时间空间效果一般
- 官方题解：
  - 将 nums 中的元素分成 0，1，2 三类
  - 於是问题变成：如何计算的合法子区间不包含 2 且至少包含一个 1
  - 于是可以先求出只包含 0 或 1 的子区间数目，再减去只包括 0 的子区间数目
    - 设count(nums, lower) 是数组 nums 中 所有元素小于等于 lower 的子数组数目， 那么本问题最终答案为 count(nums, right) - count(nums, left)

<br>

### 11-22】[878. 第 N 个神奇数字](https://leetcode.cn/problems/nth-magical-number/)

**难度**：困难

**标签**：数学，二分查找，找规律

**代码**：[NthMagicalNumber.java](src/NthMagicalNumber.java)

<br>

### 11-20】[799. 香槟塔](https://leetcode.cn/problems/champagne-tower/)

**难度**：中等

**标签**：动态规划

**代码**：[ChampagneTower.java](src/ChampagneTower.java)

**笔记**：
- 先假设全部倒到了第一杯里，然后再递推

<br>

### 11-18】[891. 子序列宽度之和](https://leetcode.cn/problems/sum-of-subsequence-widths/)

**难度**：困难

**标签**：排序，数组，数学

**代码**：[SumSubseqWidths.java](src/SumSubseqWidths.java)

**笔记**：
- 要注意 long 的范围，只到2^64，大概到 2*10^19

<br>

### 11-16】[775. 全局倒置与局部倒置](https://leetcode.cn/problems/global-and-local-inversions/)

**难度**：中等

**标签**：后缀极值，数组，数学

**代码**：[IsIdealPermutation.java](src/IsIdealPermutation.java)

<br>

### 11-14】[805. 数组的均值分割](https://leetcode.cn/problems/split-array-with-same-average/)

**难度**：困难

**标签**：滑动窗口，数学，排序

**代码**：[SplitArraySameAverage.java](src/SplitArraySameAverage.java)

**笔记**
- 一开始觉得是滑动窗口，但是所取数字并不一定在大小排序顺序上连续；
- 所以子问题实际上应该是背包问题：
  - 容量为 i
  - 目标价值（也是容量，另一个维度）为 i * sum / n
- 判断除法结果是否为整数，可以先用取余来判断

<br>

### 11-13】[791. 自定义字符串排序](https://leetcode.cn/problems/custom-sort-string/)

**难度**：中等

**标签**：字符串，计数，排序

**代码**：[CustomSortString.java](src/CustomSortString.java)

<br>

### 11-12】[790. 多米诺和托米诺平铺](https://leetcode.cn/problems/domino-and-tromino-tiling/)

**难度**：中等

**标签**：动态规划

**代码**：[NumTilings.java](src/NumTilings.java)

<br>

### 11-10】[864. 获取所有钥匙的最短路径](https://leetcode.cn/problems/shortest-path-to-get-all-keys/)

**难度**：困难

**标签**：位运算，数组，广度优先搜素

**代码**：[ShortestPathAllKeys.java](src/ShortestPathAllKeys.java)

**笔记**：

- 要将状态加入到队列中，才能记录每一步的状态（钥匙数），不会重复

<br>

### 10-28】[907. 子数组的最小值之和](https://leetcode.cn/problems/sum-of-subarray-minimums/)

**难度**：中等

**标签**：栈，数组，动态规划，单调栈

**代码**：[SumSubarrayMins.java](src/SumSubarrayMins.java)

**笔记**：

- 注意两次过栈：一次要取严格不等式、一次不取——才能保证不重复

<br>

### 10-18】[902. 最大为 N 的数字组合](https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/)

**难度**：困难

**标签**：动态规划，数学

**代码**：[AtMostNGivenDigitSet.java](src/AtMostNGivenDigitSet.java)

**笔记**：

- 注意分类的完备，不要复杂化

<br>

### 09-21】[854. 相似度为 K 的字符串](https://leetcode.cn/problems/k-similar-strings/)

**难度**：困难

**标签**：深度优先搜索，字符串

**代码**：[KSimilarity.java](src/KSimilarity.java)

**笔记**：

- 还有动态规划解法

<br>

### 09-18】[827. 最大人工岛](https://leetcode.cn/problems/making-a-large-island/)

**难度**：困难

**标签**：深度优先搜索，哈希

**代码**：[LargestIsland.java](src/LargestIsland.java)

**笔记**：

- 为不同岛标上标号
- 枚举每个可以从 0 变成 1 的地方
- 记录最大的连接面积

<br>

### 09-16】[850. 矩形面积 II](https://leetcode.cn/problems/rectangle-area-ii/)

**难度**：困难

**标签**：哈希，枚举

**代码**：[Rectangles.java](src/Rectangles.java)

**笔记**：

- 哈希构建双向映射
- 然后使用基础方法求解

<br>

### 09-15】[672. 灯泡开关 Ⅱ](https://leetcode.cn/problems/bulb-switcher-ii/)

**难度**：中等

**标签**：数学

**代码**：[FlipLights.java](src/FlipLights.java)

**笔记**：

- 分析性质：
  - 在操作了 n 次开关之后，假设完整的操作过程是：P1,P2,……,Pn
  - 如果这些操作当中两次是对同一个开关进行按压，那么直接从操作序列中去掉这两次操作，最终得到的状态是相同的
  - 所以可见最终的状态数 小于等于 长度为 n 的操作序列中对不同开关进行按压的次数奇偶情况排列的数量
  - 最后经过分析，由于开关数较少且简单，所以可以简单解决

<br>

### 09-11】[857. 雇佣 K 名工人的最低成本](https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/)

**难度**：困难

**标签**：贪心，数组，优先队列，排序

**代码**：[MincostToHireWorkers.java](src/MincostToHireWorkers.java)

**笔记**：

- 首先要注意的是：在使用自定义排序的时候:
    - `Arrays.sort(wpq_q, (a, b) -> (int) (a[0] - b[0]))`
    - `Arrays.sort(wpq_q, (a, b) -> (a[0] - b[0] > 0 ? 1 : -1))`
    - 是不等价的，因为`(int)`是向下取整
- 对于问题的分析：
    - 选择工人时，会根据候选的 k 位工人中，单位费用最高的那位的单位费用，来进行计算成本
    - 因此优先考虑单位费用最低的 k 位工人
    - 但是有一种可能能够让这样的费用更低，那就是引入单位费用相对较高一点的工人，但是他的质量较低，可以使得最终费用降低
    - 所以不断引入新的单位费用更高的工人，并尝试更新成本
    - 与此同时，使用一个优先队列，保留在不同的单位费用限制下，最低质量的 k 个工人的记录
    - 不断维护与更新，最终得到答案

<br>

### 09-10】[669. 修剪二叉搜索树](https://leetcode.cn/problems/trim-a-binary-search-tree/)

**难度**：中等

**标签**：递归，树

**代码**：[TrimBST.java](src/TrimBST.java)

**笔记**：

- 递归求解
- 利用二叉搜索树的性质

<br>

### 09-08】[667. 优美的排列 II](https://leetcode.cn/problems/beautiful-arrangement-ii/)

**难度**：中等

**标签**：数学，数组

**代码**：[ConstructArray.java](src/ConstructArray.java)

**笔记**：

- 之字形走位
- 后续衔接差为一的数对

<br>

### 09-06】[828. 统计子串中的唯一字符](https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/)

**难度**：困难

**标签**：动态规划，字符串，哈希表

**代码**：[UniqueLetterString.java](src/UniqueLetterString.java)

**笔记**：

- 前后缀记录 + 一次统计

<br>

### 09-05】[652. 寻找重复的子树](https://leetcode.cn/problems/find-duplicate-subtrees/)

**难度**：中等

**标签**：树，哈希表，深度优先搜索

**代码**：[FindDuplicateSubtrees.java](src/FindDuplicateSubtrees.java)

**笔记**：

- 我的做法：使用哈希表对不同类型的子树进行标号
- 题解做法一：
    - 使用序列化将每一个子树都【序列化】成一个字符串
    - 并且要能保证：
        - 相同的子树会被序列化成相同的子串；
        - 不同的子树会被序列化成不同的子串；
    - 常见的两种【序列化】方法：
        - 层序遍历
        - 递归+括号表示，如：x(左子树序列化结果)(右子树序列化结果)
- 题解做法二：
    - 与“我的方法”相似
    - 不过在此基础上更高强度地使用哈希表，能够更加高效的判断每种子树是否出现过

<br>

### 09-03】[646. 最长数对链](https://leetcode.cn/problems/maximum-length-of-pair-chain/)

**难度**：中等

**标签**：贪心，动态规划，排序

**代码**：[FindLongestChain.java](src/FindLongestChain.java)

**笔记**：

- 与问题【无重叠区间】方法一致
- 使用排序 + 贪心算法

<br>

### 07-20】[735. 行星碰撞](https://leetcode.cn/problems/asteroid-collision/)

**难度**：中等

**标签**：栈，数组

**代码**：[AsteroidCollision.java](src/AsteroidCollision.java)

**笔记**：

- 使用栈来模拟

<br>

### 07-12】[1252. 奇数值单元格的数目](https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/)

**难度**：简单

**标签**：模拟，数组，数学

**代码**：[OddCells.java](src/OddCells.java)

**笔记**：

- 最简单的模拟是可以的
- 但更高效的方法是：
    - col_changed
    - row_changed
    - 然后统计，时间复杂度 O(n+m+indices.length)，空间复杂度 O(n+m)

<br>

### 07-11】[676. 实现一个魔法字典](https://leetcode.cn/problems/implement-magic-dictionary/submissions/)

**难度**：中等

**标签**：树，哈希表，字典树

**代码**：[MagicDictionary.java](src/MagicDictionary.java)

**笔记**：

- 简单暴力也足够高效
- 使用字典树 + 递归（dfs）可以进一步优化

<br>

### 06-18】[剑指 Offer II 029. 排序的循环链表](https://leetcode.cn/problems/4ueAj6/)

**难度**：中等

**标签**：链表

**代码**：[Insert.java](src/Insert.java)

**笔记**：

- 找到能被“夹住”的位置
- 不然，就在巡游一圈后，在最大最后的点的下一个位置插入

<br>

### 06-11】[926. 将字符串翻转到单调递增](https://leetcode.cn/problems/flip-string-to-monotone-increasing/)

**难度**：中等

**标签**：前缀和，动态规划，字符串

**代码**：[MinFlipsMonoIncr.java](src/MinFlipsMonoIncr.java)

**笔记**：

- 对于单调递增的字符串来说：
    - 0 的前面一定是 0
    - 1 的前面可以是 1 可以是 0
- 所以可以分析出使用**动态规划**的方法来求解
    - dp[i][x] 的含义是让在i处的字符是 x，使得前 i 个字符单调递增所需要的最小调换数
    - dp[i][0] = dp[i - 1][0] + (int)(s[i]!=0)
    - dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + (int)(s[i]!=1)

<br>

### 06-10】[730. 统计不同回文子序列](https://leetcode.cn/problems/count-different-palindromic-subsequences/)

**难度**：困难

**标签**：字符串，动态规划

**代码**：[CountPalindromicSubsequences.java](src/CountPalindromicSubsequences.java)

**笔记**：


<br>

### 06-09】[497. 非重叠矩形中的随机点](https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/)

**难度**：中等

**标签**：前缀和，二分查找

**代码**：[Pick.java](src/Pick.java)

**笔记**：

- 经典的二分查找问题

<br>

### 06-07】[875. 爱吃香蕉的珂珂](https://leetcode.cn/problems/koko-eating-bananas/)

**难度**：中等

**标签**：数组，二分查找

**代码**：[MinEatingSpeed.java](src/MinEatingSpeed.java)

**笔记**：

- 二分答案并检验
- 根据可能的h的最大最小值就可以推出二分答案的初始边界

<br>

### 06-05】[478. 在圆内随机生成点](https://leetcode.cn/problems/generate-random-point-in-a-circle/)

**难度**：中等

**标签**：拒绝采样，数学，几何，随机化

**代码**：[RandPoint.java](src/RandPoint.java)

**笔记**：

- 一个方法是拒绝采样
- 另一个方法是根据概率分布确定点离圆心的距离和连线的夹角
    - 但是要**注意**概率，离圆心的距离并不是均匀分布的，而是概率与距离的开平方成正比
    - 计算sin和cos时用的是弧度
        - 与半径等长的弧对应的弧度是1
        - 一周的范围是：2 * Math.PI

<br>

### 06-03】[829. 连续整数求和](https://leetcode.cn/problems/consecutive-numbers-sum/)

**难度**：困难

**标签**：数学，枚举

**代码**：[ConsecutiveNumbersSum.java](src/ConsecutiveNumbersSum.java)

**笔记**：

- 自己的做法：找规律，枚举
- 题解：当 k 是偶数时，「正整数 n 可以表示成 k 个连续正整数之和」等价于「正整数 n 不可以被 k 整除且正整数 2n 可以被 k 整除」
- 时间复杂度相同

<br>

### 06-02】[450. 删除二叉搜索树中的节点](https://leetcode.cn/problems/delete-node-in-a-bst/)

**难度**：中等

**标签**：二叉搜索树，二叉树，树

**代码**：[DeleteNode.java](src/DeleteNode.java)

**笔记**：

- 用来填充当前位置的点值应该是左边最大的值，或者是右边最小的值，其他都不对
- 应该利用递归性质，而遍历树找到目标点再针对操作是比较低效的
    - 递归调用函数对子树做删除
    - 递归调用函数把用来顶替当前位置的节点删除
- 将递归改写成迭代，还可以节约较多空间

<br>

### 06-01】[473. 火柴拼正方形](https://leetcode.cn/problems/matchsticks-to-square/)

**难度**：中等

**标签**：位运算，状态压缩，动态规划，回溯，数组

**代码**：[Makesquare.java](src/Makesquare.java)

**笔记**：

- 状态压缩动态规划，状态设计方法经典：
    - 状态为当前已经使用的火柴
    - 而 dp 值为当前正在拼的正方形方已经拼的长度
    - 如果无法拼凑，则 dp 值设置为 -1
    - 成功的状态转移需要前状态不为 -1，且新加入的火柴能够合适地填入
- 【值得反复学习】
- 如果是纯回溯，有两项剪枝的重要手段：
    - 一方面是考虑按顺序加入正方形的构造，如果此时放入火柴会导致边长超限，那么直接舍弃
    - 一方面是将火柴从大到小排序，这样会更容易找到使得边长超限并被舍弃的分支；
    - 第二个方面的直观的理解就是：让较长的火柴尽可能被分到正方形的各个边中；或者说因为短火柴更灵活，提前使用不能快速找出非法解

<br>

### 05-29】[468. 验证IP地址](https://leetcode.cn/problems/validate-ip-address/)

**难度**：中等

**标签**：字符串

**代码**：[ValidIPAddress.java](src/ValidIPAddress.java)

**笔记**：

- 注意检查“split”的结果，会不会因为最有一个空缺而自动抹除
- 注意有可能一开始，输入的字符串就太长而没有必要再进行判断
- 注意一方面，不是0的数，开头不会是0；另一方面，是0的话，开头是0但后面还有0也是不对的

<br>

### 05-26】[699. 掉落的方块](https://leetcode.cn/problems/falling-squares/)

**难度**：困难

**标签**：有序集合，线段树，数组

**代码**：[FallingSquares.java](src/FallingSquares.java)

**笔记**：

- 暴力方法：
    - 也可以通过
    - 判断两个方块是否相交：
        - 直观的想法是，找出不相交的条件：`left1 > right2 or right1 < left2`
        - 取反得到：`left1 <= right2 and right1 >= left2`
    - 时间复杂度：n 方
- 有序集合：
    - 可以将时间复杂度降低到 nlogn
    - 记录高度发生变化的点集，使用二分查找进行搜索
- 线段树：需要将点进行映射

<br>

### 05-25】[467. 环绕字符串中唯一的子字符串](https://leetcode.cn/problems/unique-substrings-in-wraparound-string/)

**难度**：中等

**标签**：动态规划

**代码**：[FindSubstringInWraproundString.java](src/FindSubstringInWraproundString.java)

**笔记**：

- 最初的想法是：双指针+类似单调队列的做法
    - 尝试加记录、拆解
- 最终，维护一个 26 大小的数组，其中的每个元素分别记录每个对应的字母，曾经参与构成的以自己结尾的最长的子串的长度
    - 答案就是这个数组内部元素的和

<br>

### 05-23】[675. 为高尔夫比赛砍树](https://leetcode.cn/problems/cut-off-trees-for-golf-event/)

**难度**：困难

**标签**：广度优先搜索

**代码**：[CutOffTree.java](src/CutOffTree.java)

**笔记**：

- 二维数组使用`Arrays.fill()`
  ```{java}
  for (boolean[] sub: visited)
     Arrays.fill(sub, false);

<br>

### 05-22】[464. 我能赢吗](https://leetcode.cn/problems/can-i-win/)

**难度**：中等

**标签**：记忆化搜索，状态压缩，位运算，数学，动态规划

**代码**：[CanIWin.java](src/CanIWin.java)

**笔记**：

- 不要想当然，当总和刚好等于目标值时，也有可能“稳赢”——并非后手一定拿到最后一个——谁拿最后一个只跟奇偶个数有关
- 经典按位状态压缩
- 博弈论思想：除了无人可赢的情况外
    - 如果己方不能稳赢，则在某种情况下对面必赢，即对方稳赢
    - 所以是一个非此即彼的关系
    - “最大最小博弈”转换思想

<br>

### 04-11】[357. 统计各位数字都不同的数字个数](https://leetcode-cn.com/problems/count-numbers-with-unique-digits/)

**难度**：中等

**标签**：数学

**代码**：[CountNumbersWithUniqueDigits.java](src/CountNumbersWithUniqueDigits.java)

**笔记**：

- 考虑 0 的个数分类讨论，对应情况可以通过排列获得

<br>

### 04-09】[780. 到达终点](https://leetcode-cn.com/problems/reaching-points/)

**难度**：困难

**标签**：数学，脑筋急转弯

**代码**：[ReachingPoints.java](src/ReachingPoints.java)

**笔记**：

- 尝试使用逆向思维
    - 对于`(tx,ty)`数对，其可能会源自
        - `(tx-ty,ty)`
        - `(tx,ty-tx)`
    - 但由于数的严格大于零性质，这两种中必只有一种符合可能
    - 所以求解过程并无需使用搜索

<br>

### 04-08】[96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)

**难度**：中等

**标签**：树，二叉搜索树，数学，动态规划

**代码**：[NumTrees.java](src/NumTrees.java)

<br>

### 04-08】[429. N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

**难度**：中等

**标签**：树，多叉树，层序遍历，广度优先搜索

**代码**：[LevelOrder.java](src/LevelOrder.java)

<br>

### 04-06】[310. 最小高度树](https://leetcode-cn.com/problems/minimum-height-trees/)

**难度**：中等

**标签**：深度优先搜索，广度优先搜索，拓扑排序

**代码**：[FindMinHeightTrees.java](src/FindMinHeightTrees.java)

**笔记**：

- 【搜索做法】知识点：如何找到图中最远两个节点与它们之间的路径
    - 从任意节点 p 出发，使用 dfs 或者 bfs 出发找到一条最长的路径终点 x
    - 从节点 x 出发，找到最长路径的终点 y
    - x 到 y 之间的路径即为图中的最长路径
    - 在本题中 xy 路径的中间节点即为根节点
- 【拓扑排序做法】
    - 将所有度为 1 的节点放入队列
    - 取出节点，并将相邻结点的度减少，并将新的度数为 1 的节点放入队列
    - 知道所剩的节点数目小于等于 2
    - 剩余的节点即为所求的根节点

<br>

### 04-05】[762. 二进制表示中质数个计算置位](https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/)

**难度**：简单

**标签**：数学，位运算

**代码**：[CountPrimeSetBits.java](src/CountPrimeSetBits.java)

**笔记**：

- 复习几项知识：
    - `x &= (x - 1)` 可以直接消除最后一个 x 二进制中的最后一个 1
    - 使用上一条可以高效统计出一个数的计算置位数
    - `((1 << Integer.bitCount(x)) & 665772) != 0` 可以在可能的质数情况有限时，快速判断是否满足条件，时间复杂度 O(1)

<br>

### 04-04】[307. 区域和检索 - 数组可修改](https://leetcode-cn.com/problems/range-sum-query-mutable/)

**难度**：中等

**标签**：树状数组，线段树，数组

**代码**：[NumArray.java](src/NumArray.java)

**笔记**：

- 复习**树状数组**：
    - `lowbit(x) = x & (-x)` 可以找到 x 二进制中最后一个 1 的位置
    - 更新和查询的时间复杂度都是 ![](https://latex.codecogs.com/svg.latex?O(logn))

<br>

### 04-02】[420. 强密码检验器](https://leetcode-cn.com/problems/strong-password-checker/)

**难度**：困难

**标签**：贪心，分类讨论，字符串

**代码**：[StrongPasswordChecker.java](src/StrongPasswordChecker.java)

**笔记**：

- 可以体现 **分类讨论** 的重要性
- 设 n 为输入字符串的长度，分三种情况
    - 小于 6
    - 在 6 和 20 的闭区间内
    - 大于 20
- 于是分别对应以下三种处理：
    1. `return Math.max(6 - n, 3 - types)`
    2. `Math.max(times_change, 3 - types)`
    3. `n - 20 + Math.max(times_change, 3 - types)`
- 包含了很多贪心思想，不同分类下在“增”、“删”、“替”中寻找占优操作

<br>

### 04-01】[954. 二倍数对数组](https://leetcode-cn.com/problems/array-of-doubled-pairs/)

**难度**：中等

**标签**：贪心，哈希表，排序，数组

**代码**：[CanReorderDoubled.java](src/CanReorderDoubled.java)

<br>

### 03-30】[1606. 找到处理最多请求的服务器](https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/)

**难度**：困难

**标签**：优先队列

**代码**：[BusiestServers.java](src/BusiestServers.java)

**笔记**：

- 使用双优先队列
    - 一个记录服务器恢复时间
    - 一个按顺序记录可用服务
    - 按时更新两个队列

<br>

### 03-29】[2024. 考试的最大困扰度](https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/)

**难度**：中等

**标签**：滑动窗口

**代码**：[MaxConsecutiveAnswers.java](src/MaxConsecutiveAnswers.java)

**笔记**：

- 没有必要预统计连续字符的个数，可以直接在原字符串上做遍历

<br>

### 03-28】[440. 字典序的第K小数字](https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/)

**难度**：困难

**标签**：字典树

**代码**：[FindKthNumber.java](src/FindKthNumber.java)

**笔记**：

- 由于数据规模较大，如果直接真实遍历会超时
- 利用字典树性质
    - first(i) = first(i - 1) * 10
    - last(i) = min(n, last(i - 1) * 10 + 9)
    - last(i) - first(i) 可以计算出一层点的数量
- 注意对关键变量采用 long 数据类型，防止比较或计算错误
- 时间复杂度 ![](https://latex.codecogs.com/svg.latex?O(log^2n))

<br>

### 03-26】[991. 坏了的计算器](https://leetcode-cn.com/problems/broken-calculator/)

**难度**：中等

**标签**：数学，脑筋急转弯，贪心

**代码**：[BrokenCalc.java](src/BrokenCalc.java)

**笔记**：

- 反向思维：
    - 对 x 乘 2 等价于对 y 除以 2
    - 对 x 减 1 等价于对 y 加上 1
- 贪心策略：
    - 总是对 y 优先进行除以 2 的操作
        - 如果 y 是偶数，如果不马上除以 2，先加若干个 1 再除以 2 的话，可以通过先除以 2 再加 1 的途径通过更少的步数实现
        - 如果 y 是奇数，尤其仅有加 1 的选择，加 1 后变成偶数回到第一种情况
    - 当 y 小于 x 时总是加 1，直接计算差值即可

<br>

### 03-25】[172. 阶乘后的零](https://leetcode-cn.com/problems/factorial-trailing-zeroes/)

**难度**：中等

**标签**：数学

**代码**：[TrailingZeroes.java](src/TrailingZeroes.java)

**笔记**：

- 只要统计最后结果中，因子里 2 和 5 的数量，取较小值即可
- 【优化】显然，5 的数量一定会小于 2 的，所以只计算 5 即可

<br>

### 03-23】[1349. 参加考试的最大学生数](https://leetcode-cn.com/problems/maximum-students-taking-exam/)

**难度**：困难

**标签**：网络流，图，最大流，链式前向星，深度优先搜索

**代码**：[MaxStudents.java](src/MaxStudents.java)

**笔记**：

- 链式前向星复习
    - head 数组一般默认初始为 -1
    - 对边的编号 p 进行运算：p^1 可以得到其反向边
- 最大独立集 = 点数 - 最小覆盖集
- 最小覆盖集 = 最大匹配
- 最大匹配对应最大流（除去添加的汇点与源点）
- 所以可以使用最大流算法求解
- 构造流网络时
    - 由于同一列不存在抄袭可能，可以构造
        - 源点连向所有奇数列上的点
        - 所有偶数列上的点连向汇点
    - 两个点之间存在一条边表示这个两个点存在可以抄袭的关系
    - 而且自动调整为由奇数列上的点指向偶数列上的点
- 细节注意
    - 回溯过程中 visited 数组的正确维护
    - 回溯过程中 边与其反向边上 True/False 的维护

<br>

### 03-22】[2038. 如果相邻两个颜色均相同则删除当前颜色](https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/)

**难度**：中等

**标签**：贪心

**代码**：[WinnerOfGame.java](src/WinnerOfGame.java)

<br>

### 03-21】[653. 两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)

**难度**：简单

**标签**：二叉搜索树，遍历，双指针

**代码**：[FindTarget.java](src/FindTarget.java)

**笔记**：

- 复习二叉搜索树，中序遍历可以得到递增序列

- 复习双指针判断两数之和是否满足目标

<br>

### 03-20】[2039. 网络空闲的时刻](https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/)

**难度**：中等

**标签**：广度优先搜索，树，图

**代码**：[NetworkBecomesIdle.java](src/NetworkBecomesIdle.java)

**笔记**：

- 练习了应用哨兵节点

- 要注意考虑时间的问题，每一秒也区分“这一秒的开始”和“这一秒的结束”，这两种说法差了一秒

<br>

### 03-17】[720. 词典中最长的单词](https://leetcode-cn.com/problems/longest-word-in-dictionary/)

**难度**：简单

**标签**：前缀树，字典树，哈希表，排序

**代码**：[LongestWord.java](src/LongestWord.java)

**笔记**：

- 利用前缀树的特性来进行高效求解

<br>

### 03-17】[208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

**难度**：中等

**标签**：前缀树，字典树

**代码**：[Trie.java](src/Trie.java)

**笔记**：

- 一个 Trie 对象就相当于一个 Node 节点

<br>

### 03-16】[432. 全 O(1) 的数据结构](https://leetcode-cn.com/problems/all-oone-data-structure/)

**难度**：困难

**标签**：集合，哈希表，链表，双向链表，设计

**代码**：[AllOne.java](src/AllOne.java)

**官方题解代码**：[AllOneSTD.java](src/AllOneSTD.java)

**笔记**：

1. 双向链表与哈希表的结合

2. `Node` 类可以规范抽象出 `Insert`、`Remove` 等方法，提高代码简洁性、复用率与可读性（参考官方题解代码）

3. 使用**哨兵节点**替代`null`，可以非常简洁地实现移除等操作

4. [**内部类**与**嵌套类**](notes/内部类与嵌套类)

<br>

### 03-15】[2044. 统计按位或能得到最大值的子集数目](https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/)

**难度**：中等

**标签**：位运算，深度优先搜索，剪枝

**代码**：[CountMaxOrSubsets.java](src/CountMaxOrSubsets.java)

**笔记**：

1. 位运算结果直接作为 target，用 `==` 判断边界即可

2. 已经满足 target 要求即可剪枝

<br>

### 03-13】[393. UTF-8 编码验证](https://leetcode-cn.com/problems/utf-8-validation/)

**难度**：中等

**标签**：位运算

**代码**：[ValidUtf8.java](src/ValidUtf8.java)

<br>

### 03-12】[剑指 Offer II 114. 外星文字典](https://leetcode-cn.com/problems/Jf1JuT/)

**难度**：困难

**标签**：拓扑排序，图

**代码**：[AlienOrder.java](src/AlienOrder.java)

**坑与启发**：

1. 输入只有一个元素，无法正确展开判断

2. 注意判断的中止，与终止之后判断方法的切换，做到不重不漏

3. 给出的输入既有可能引起第一条规则的违背，也有可能引起第二条，因此需要判断

<br>

### 03-11】[2049. 统计最高分的节点数目](https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/)

**难度**：中等

**标签**：树，深度优先搜索，二叉树

**代码**：[CountHighestScoreNodes.java](src/CountHighestScoreNodes.java)

<br>

### 03-09】[798. 得分最高的最小轮调](https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/)

**难度**：困难

**标签**：差分数组，滑动窗口，优先队列，数组

**代码**：[BestRotation.java](src/BestRotation.java)

**我使用的方法**：

1. 滑动窗口+优先队列 ![](https://latex.codecogs.com/svg.latex?\O(nlogn))

2. 滑动窗口+数组![](https://latex.codecogs.com/svg.latex?\O(n))

**官方题解**：差分数组 ![](https://latex.codecogs.com/svg.latex?\O(n)) **(*)**

<br>

### 03-08】[919. 完全二叉树插入器](https://leetcode-cn.com/problems/complete-binary-tree-inserter/)

**难度**：中等

**标签**：树，设计，广度优先搜索，层序遍历

**代码**：[CBTInserter.java](src/CBTInserter.java)

**笔记**：

- 在根结点编号为1的前提下
- 可以看出，对于将插入的整棵树的第x个节点，观察x的二进制表示
    - 从高位往低位遍历，忽略最高位的1
    - 从根节点出发，遇到0往左走，遇到1往右走
    - 这样下去就可以到达要被插入的位置

<br>

### 03-08】[2055. 蜡烛之间的盘子](https://leetcode-cn.com/problems/plates-between-candles/)

**难度**：中等

**标签**：数组，字符串，前缀和

**代码**：[PlateBetweenCandles.java](src/PlateBetweenCandles.java)

