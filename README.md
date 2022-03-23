# 刷题记录

[**编程笔记**](/notes/index)

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

