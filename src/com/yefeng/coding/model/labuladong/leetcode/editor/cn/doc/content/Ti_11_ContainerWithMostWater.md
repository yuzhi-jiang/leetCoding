<p>给定一个长度为 <code>n</code> 的整数数组&nbsp;<code>height</code>&nbsp;。有&nbsp;<code>n</code>&nbsp;条垂线，第 <code>i</code> 条线的两个端点是&nbsp;<code>(i, 0)</code>&nbsp;和&nbsp;<code>(i, height[i])</code>&nbsp;。</p>

<p>找出其中的两条线，使得它们与&nbsp;<code>x</code>&nbsp;轴共同构成的容器可以容纳最多的水。</p>

<p>返回容器可以储存的最大水量。</p>

<p><strong>说明：</strong>你不能倾斜容器。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg" /></p>

<pre>
<strong>输入：</strong>[1,8,6,2,5,4,8,3,7]
<strong>输出：</strong>49 
<strong>解释：</strong>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为&nbsp;49。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [1,1]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == height.length</code></li> 
 <li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 双指针</details><br>

<div>👍 5002, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 限时优惠；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=container-with-most-water" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题前文 [接雨水问题详解](https://labuladong.online/algo/fname.html?fname=接雨水) 讲过的 [42. 接雨水](/problems/trapping-rain-water) 几乎一模一样。

区别在于：接雨水问题给出的类似一幅直方图，每个横坐标都有宽度，而本题给出的每个坐标是一条竖线，没有宽度。

接雨水问题更难一些，每个坐标对应的矩形通过左右的最大高度的最小值推算自己能装多少水：

![](https://labuladong.github.io/pictures/接雨水/5.jpg)

本题可完全套用接雨水问题的思路，相对还更简单：

**用 `left` 和 `right` 两个指针从两端向中心收缩，一边收缩一边计算 `[left, right]` 之间的矩形面积，取最大的面积值即是答案**。

不过肯定有读者会问，下面这段 if 语句为什么要移动较低的一边：

```java
// 双指针技巧，移动较低的一边
if (height[left] < height[right]) {
    left++;
} else {
    right--;
}
```

**其实也好理解，因为矩形的高度是由 `min(height[left], height[right])` 即较低的一边决定的**：

你如果移动较低的那一边，那条边可能会变高，使得矩形的高度变大，进而就「有可能」使得矩形的面积变大；相反，如果你去移动较高的那一边，矩形的高度是无论如何都不会变大的，所以不可能使矩形的面积变得更大。

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
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int cur_area = min(height[left], height[right]) * (right - left);
            res = max(res, cur_area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
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
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height)-1
        res = 0
        while left < right:
            # [left, right] 之间的矩形面积
            cur_area = min(height[left], height[right]) * (right - left)
            res = max(res, cur_area)
            # 双指针技巧，移动较低的一边
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxArea(height []int) int {
    left, right := 0, len(height)-1
    res := 0
    for left < right {
        // [left, right] 之间的矩形面积
        curArea := func() int {
            if height[left] < height[right] {
                return height[left] * (right - left)
            }
            return height[right] * (right - left)
        }()
        res = func() int {
            if curArea > res {
                return curArea
            }
            return res
        }()
        // 双指针技巧，移动较低的一边
        if height[left] < height[right] {
            left++
        } else {
            right--
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let left = 0, right = height.length - 1;
    let res = 0;
    while (left < right) {
        // [left, right] 之间的矩形面积
        const cur_area = Math.min(height[left], height[right]) * (right - left);
        res = Math.max(res, cur_area);
        // 双指针技巧，移动较低的一边
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_container-with-most-water" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_container-with-most-water"></div></div>
</details><hr /><br />

**类似题目**：
  - [42. 接雨水 🔴](/problems/trapping-rain-water)

</details>
</div>



