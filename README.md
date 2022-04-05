# 刷题记录

[**编程笔记**](/notes/index)

<br>

### 04-04】[762. 二进制表示中质数个计算置位](https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/)

**难度**：简单

**标签**：数学，位运算

**代码**：[CountPrimeSetBits.java](src/CountPrimeSetBits.java)

**笔记**：
- 复习几项知识：
  - `x &= (x - 1)` 可以直接消除最后一个 x 二进制中的最后一个 1
  - 使用上一条可以高效统计出一个数的计算置位数
  - `((1 << Integer.bitCount(x)) & 665772) != 0` 可以在可能的质数情况有限时，快速判断是否满足条件，时间复杂度 O(1)

<br>

### 04-03】[307. 区域和检索 - 数组可修改](https://leetcode-cn.com/problems/range-sum-query-mutable/)

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

-  利用前缀树的特性来进行高效求解

<br>

### 03-17】[208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)

**难度**：中等

**标签**：前缀树，字典树

**代码**：[Trie.java](src/Trie.java)

**笔记**：

-  一个 Trie 对象就相当于一个 Node 节点

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

<br>

### 03-08】[2055. 蜡烛之间的盘子](https://leetcode-cn.com/problems/plates-between-candles/)

**难度**：中等

**标签**：数组，字符串，前缀和

**代码**：[PlateBetweenCandles.java](src/PlateBetweenCandles.java)

