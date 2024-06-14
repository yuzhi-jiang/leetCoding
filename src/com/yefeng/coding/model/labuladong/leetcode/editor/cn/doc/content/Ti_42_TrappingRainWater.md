<p>给定&nbsp;<code>n</code> 个非负整数表示每个宽度为 <code>1</code> 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>

<pre>
<strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>输出：</strong>6
<strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [4,2,0,3,2,5]
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == height.length</code></li> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 双指针 | 动态规划 | 单调栈</details><br>

<div>👍 5189, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 限时优惠；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=trapping-rain-water" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 364 页。

对于任意一个位置 `i`，能够装的水为：

```python
water[i] = min(
           # 左边最高的柱子
           max(height[0..i]),
           # 右边最高的柱子
           max(height[i..end])
        ) - height[i]
```

![](https://labuladong.github.io/pictures/接雨水/1.jpg)

**关键在于，如何能够快速计算出某一个位置左侧所有柱子的最大高度和右侧所有柱子的最大高度**。

这道题的解法比较多样，可以预计算数组，可以用 [双指技巧](https://labuladong.online/algo/fname.html?fname=双指针技巧)，可以用[单调栈技巧](https://labuladong.online/algo/fname.html?fname=单调栈)，这里就说一个最简单的解法，用预计算的方式求解，优化暴力解法的时间复杂度，更多解法请看详细题解。

**详细题解：[如何高效解决接雨水问题](https://labuladong.online/algo/fname.html?fname=接雨水)**

**标签：[数组双指针](https://labuladong.online/algo/)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int trap(vector<int>& height) {
        if (height.empty()) {
            return 0;
        }
        int n = height.size();
        int res = 0;
        // 数组充当备忘录
        vector<int> l_max(n);
        vector<int> r_max(n);
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++) {
            l_max[i] = max(height[i], l_max[i - 1]);
        }
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = max(height[i], r_max[i + 1]);
        }
        // 计算答案
        for (int i = 1; i < n - 1; i++) {
            res += min(l_max[i], r_max[i]) - height[i];
        }/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        n = len(height)
        res = 0
        # 数组充当备忘录
        l_max = [0] * n
        r_max = [0] * n
        # 初始化 base case
        l_max[0] = height[0]
        r_max[n - 1] = height[n - 1]
        # 从左向右计算 l_max
        for i in range(1, n):
            l_max[i] = max(height[i], l_max[i - 1])
        # 从右向左计算 r_max
        for i in range(n - 2, -1, -1):
            r_max[i] = max(height[i], r_max[i + 1])
        # 计算答案
        for i in range(1, n - 1):
            res += min(l_max[i], r_max[i]) - height[i]
            """
            extend up -300
            ![](https://labuladong.github.io/pictures/接雨水/1.jpg)
            """
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func trap(height []int) int {
    if len(height) == 0 {
        return 0
    }
    n := len(height)
    res := 0
    // 数组充当备忘录
    l_max := make([]int, n)
    r_max := make([]int, n)
    // 初始化 base case
    l_max[0] = height[0]
    r_max[n - 1] = height[n - 1]
    // 从左向右计算 l_max
    for i := 1; i < n; i++ {
        l_max[i] = max(height[i], l_max[i - 1])
    }
    // 从右向左计算 r_max
    for i := n - 2; i >= 0; i-- {
        r_max[i] = max(height[i], r_max[i + 1])
    }
    // 计算答案
    for i := 1; i < n - 1; i++ {
        res += min(l_max[i], r_max[i]) - height[i]/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
    } 
    return res;
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b 
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b 
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var trap = function(height) {
  if (height.length == 0) {
    return 0;
  }
  var n = height.length;
  var res = 0;
  // 数组充当备忘录
  var l_max = new Array(n);
  var r_max = new Array(n);
  // 初始化 base case
  l_max[0] = height[0];
  r_max[n - 1] = height[n - 1];
  // 从左向右计算 l_max
  for (var i = 1; i < n; i++) {
    l_max[i] = Math.max(height[i], l_max[i - 1]);
  }
  // 从右向左计算 r_max
  for (var i = n - 2; i >= 0; i--) {
    r_max[i] = Math.max(height[i], r_max[i + 1]);
  }
  // 计算答案
  for (var i = 1; i < n - 1; i++) {
    res += Math.min(l_max[i], r_max[i]) - height[i];
  }/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
  return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_trapping-rain-water" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_trapping-rain-water"></div></div>
</details><hr /><br />

**类似题目**：
  - [11. 盛最多水的容器 🟠](/problems/container-with-most-water)

</details>
</div>

