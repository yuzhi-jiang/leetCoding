<p>给定一个整数 <code>n</code> 和一个 <strong>无重复</strong> 黑名单整数数组&nbsp;<code>blacklist</code>&nbsp;。设计一种算法，从 <code>[0, n - 1]</code> 范围内的任意整数中选取一个&nbsp;<strong>未加入&nbsp;</strong>黑名单&nbsp;<code>blacklist</code>&nbsp;的整数。任何在上述范围内且不在黑名单&nbsp;<code>blacklist</code>&nbsp;中的整数都应该有 <strong>同等的可能性</strong> 被返回。</p>

<p>优化你的算法，使它最小化调用语言 <strong>内置</strong> 随机函数的次数。</p>

<p>实现&nbsp;<code>Solution</code>&nbsp;类:</p>

<ul>
	<li><code>Solution(int n, int[] blacklist)</code>&nbsp;初始化整数 <code>n</code> 和被加入黑名单&nbsp;<code>blacklist</code>&nbsp;的整数</li>
	<li><code>int pick()</code>&nbsp;返回一个范围为 <code>[0, n - 1]</code> 且不在黑名单&nbsp;<code>blacklist</code> 中的随机整数</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>
["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
[[7, [2, 3, 5]], [], [], [], [], [], [], []]
<strong>输出</strong>
[null, 0, 4, 1, 6, 1, 0, 4]

<b>解释
</b>Solution solution = new Solution(7, [2, 3, 5]);
solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
                 // 0、1、4和6的返回概率必须相等(即概率为1/4)。
solution.pick(); // 返回 4
solution.pick(); // 返回 1
solution.pick(); // 返回 6
solution.pick(); // 返回 1
solution.pick(); // 返回 0
solution.pick(); // 返回 4
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= blacklist.length &lt;= min(10<sup>5</sup>, n - 1)</code></li>
	<li><code>0 &lt;= blacklist[i] &lt; n</code></li>
	<li><code>blacklist</code>&nbsp;中所有值都 <strong>不同</strong></li>
	<li>&nbsp;<code>pick</code>&nbsp;最多被调用&nbsp;<code>2 * 10<sup>4</sup></code>&nbsp;次</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 二分查找 | 排序 | 随机化</details><br>

<div>👍 205, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.7](https://aep.h5.xeknow.com/s/1XJHEO)
持续更新中；第九期打卡挑战 [开始报名](https://aep.h5.xeknow.com/s/3SlWbp)；B
站可查看 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**



<p><strong><a href="https://labuladong.github.io/article?qno=710" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

本题考察如下两点：

1、如果想高效地，等概率地随机获取元素，就要使用数组作为底层容器。

2、如果既要保持数组元素的紧凑性，又想从数组中间删除元素，那么可以把待删除元素换到最后，然后 `pop` 掉末尾的元素，这样时间复杂度就是
O(1) 了。当然，这样做的代价是我们需要额外的哈希表记录值到索引的映射。

**详细题解：[常数时间删除/查找数组中的任意元素](https://labuladong.github.io/article/fname.html?fname=随机集合)**

**
标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)
，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)
，[随机算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```cpp
class Solution {
public:
    int sz;
    unordered_map<int, int> mapping;

    Solution(int N, vector<int>& blacklist) {
        sz = N - blacklist.size();
        for (int b : blacklist) {
            mapping[b] = 666;
        }

        int last = N - 1;
        for (int b : blacklist) {
            // 如果 b 已经在区间 [sz, N)
            // 可以直接忽略
            if (b >= sz) {
                continue;
            }
            while (mapping.count(last)) {
                last--;
            }
            mapping[b] = last;
            last--;
        }
    }

    int pick() {
        // 随机选取一个索引
        int index = rand() % sz;
        // 这个索引命中了黑名单，
        // 需要被映射到其他位置
        if (mapping.count(index)) {
            return mapping[index];
        }
        // 若没命中黑名单，则直接返回
        return index;
    }
};
```

**类似题目**：

- [380. O(1) 时间插入、删除和获取随机元素 🟠](/problems/insert-delete-getrandom-o1)
- [剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器 🟠](/problems/FortPu)

</details>
</div>



