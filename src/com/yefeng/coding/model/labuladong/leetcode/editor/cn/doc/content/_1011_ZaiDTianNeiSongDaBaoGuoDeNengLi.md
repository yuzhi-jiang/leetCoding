<p>传送带上的包裹必须在 <code>days</code> 天内从一个港口运送到另一个港口。</p>

<p>传送带上的第 <code>i</code>&nbsp;个包裹的重量为&nbsp;<code>weights[i]</code>。每一天，我们都会按给出重量（<code>weights</code>）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。</p>

<p>返回能在 <code>days</code> 天内将传送带上的所有包裹送达的船的最低运载能力。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>weights = [1,2,3,4,5,6,7,8,9,10], days = 5
<strong>输出：</strong>15
<strong>解释：</strong>
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10

请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>weights = [3,2,2,4,1,4], days = 3
<strong>输出：</strong>6
<strong>解释：</strong>
船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
第 1 天：3, 2
第 2 天：2, 4
第 3 天：1, 4
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>weights = [1,2,3,1,1], days = 4
<strong>输出：</strong>3
<strong>解释：</strong>
第 1 天：1
第 2 天：2
第 3 天：3
第 4 天：1, 1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= weights[i] &lt;= 500</code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 481, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.7](https://aep.h5.xeknow.com/s/1XJHEO)
持续更新中；第九期打卡挑战 [开始报名](https://aep.h5.xeknow.com/s/3SlWbp)；B
站可查看 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**



<p><strong><a href="https://labuladong.github.io/article?qno=1011" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 360 页。

二分搜索的套路比较固定，如果遇到一个算法问题，能够确定 `x, f(x), target` 分别是什么，并写出单调函数 `f` 的代码。

船的运载能力就是自变量 `x`，运输天数和运载能力成反比，所以可以定义 `f(x)` 表示 `x` 的运载能力下需要的运输天数，`target`
显然就是运输天数 `D`，我们要在 `f(x) == D` 的约束下，算出船的最小载重。

![](https://labuladong.github.io/algo/images/二分运用/5.jpeg)

关于本题二分搜索的具体思路见详细题解。

**详细题解：[二分搜索怎么用？我又总结了套路](https://labuladong.github.io/article/fname.html?fname=二分运用)**

**
标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
```

**类似题目**：

- [410. 分割数组的最大值 🔴](/problems/split-array-largest-sum)
- [875. 爱吃香蕉的珂珂 🟠](/problems/koko-eating-bananas)
- [剑指 Offer II 073. 狒狒吃香蕉 🟠](/problems/nZZqjQ)

</details>
</div>



