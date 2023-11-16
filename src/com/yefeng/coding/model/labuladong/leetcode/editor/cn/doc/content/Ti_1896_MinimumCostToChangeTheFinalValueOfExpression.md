<p>给你一个 <strong>有效的</strong>&nbsp;布尔表达式，用字符串&nbsp;<code>expression</code>&nbsp;表示。这个字符串包含字符&nbsp;<code>'1'</code>，<code>'0'</code>，<code>'&amp;'</code>（按位 <strong>与</strong>&nbsp;运算），<code>'|'</code>（按位 <strong>或</strong>&nbsp;运算），<code>'('</code>&nbsp;和&nbsp;<code>')'</code>&nbsp;。</p>

<ul> 
 <li>比方说，<code>"()1|1"</code> 和&nbsp;<code>"(1)&amp;()"</code>&nbsp;<strong>不是有效</strong>&nbsp;布尔表达式。而&nbsp;<code>"1"</code>，&nbsp;<code>"(((1))|(0))"</code>&nbsp;和&nbsp;<code>"1|(0&amp;(1))"</code>&nbsp;是 <strong>有效</strong>&nbsp;布尔表达式。</li> 
</ul>

<p>你的目标是将布尔表达式的 <strong>值</strong>&nbsp;<strong>反转 </strong>（也就是将 <code>0</code>&nbsp;变为 <code>1</code>&nbsp;，或者将 <code>1</code>&nbsp;变为 <code>0</code>），请你返回达成目标需要的 <strong>最少操作</strong>&nbsp;次数。</p>

<ul> 
 <li>比方说，如果表达式&nbsp;<code>expression = "1|1|(0&amp;0)&amp;1"</code>&nbsp;，它的&nbsp;<strong>值</strong>&nbsp;为&nbsp;<code>1|1|(0&amp;0)&amp;1 = 1|1|0&amp;1 = 1|0&amp;1 = 1&amp;1 = 1</code>&nbsp;。我们想要执行操作将&nbsp;<strong>新的</strong>&nbsp;表达式的值变成&nbsp;<code>0</code>&nbsp;。</li> 
</ul>

<p>可执行的 <strong>操作</strong>&nbsp;如下：</p>

<ul> 
 <li>将一个&nbsp;<code>'1'</code>&nbsp;变成一个&nbsp;<code>'0'</code>&nbsp;。</li> 
 <li>将一个&nbsp;<code>'0'</code>&nbsp;变成一个&nbsp;<code>'1'</code>&nbsp;。</li> 
 <li>将一个&nbsp;<code>'&amp;'</code> 变成一个&nbsp;<code>'|'</code>&nbsp;。</li> 
 <li>将一个&nbsp;<code>'|'</code>&nbsp;变成一个&nbsp;<code>'&amp;'</code>&nbsp;。</li> 
</ul>

<p><strong>注意：</strong><code>'&amp;'</code>&nbsp;的 <strong>运算优先级</strong>&nbsp;与&nbsp;<code>'|'</code> <strong>相同</strong>&nbsp;。计算表达式时，括号优先级 <strong>最高</strong>&nbsp;，然后按照 <strong>从左到右</strong> 的顺序运算。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>expression = "1&amp;(0|1)"
<b>输出：</b>1
<b>解释：</b>我们可以将 "1&amp;(0<strong>|</strong>1)" 变成 "1&amp;(0<strong>&amp;</strong>1)" ，执行的操作为将一个 '|' 变成一个 '&amp;' ，执行了 1 次操作。
新表达式的值为 0 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>expression = "(0&amp;0)&amp;(0&amp;0&amp;0)"
<b>输出：</b>3
<b>解释：</b>我们可以将 "(0<strong>&amp;0</strong>)<strong>&amp;</strong>(0&amp;0&amp;0)" 变成 "(0<strong>|1</strong>)<strong>|</strong>(0&amp;0&amp;0)" ，执行了 3 次操作。
新表达式的值为 1 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>expression = "(0|(1|0&amp;1))"
<b>输出：</b>1
<b>解释：</b>我们可以将 "(0|(<strong>1</strong>|0&amp;1))" 变成 "(0|(<strong>0</strong>|0&amp;1))" ，执行了 1 次操作。
新表达式的值为 0 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= expression.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>expression</code>&nbsp;只包含&nbsp;<code>'1'</code>，<code>'0'</code>，<code>'&amp;'</code>，<code>'|'</code>，<code>'('</code>&nbsp;和&nbsp;<code>')'</code></li> 
 <li>所有括号都有与之匹配的对应括号。</li> 
 <li>不会有空的括号（也就是说&nbsp;<code>"()"</code>&nbsp;不是&nbsp;<code>expression</code> 的子字符串）。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数学 | 字符串 | 动态规划</details><br>

<div>👍 29, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

</div>

