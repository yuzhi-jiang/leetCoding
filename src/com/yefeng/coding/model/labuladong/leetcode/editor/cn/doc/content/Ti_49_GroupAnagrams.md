<p>给你一个字符串数组，请你将 <strong>字母异位词</strong> 组合在一起。可以按任意顺序返回结果列表。</p>

<p><strong>字母异位词</strong> 是由重新排列源单词的所有字母得到的一个新单词。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> strs = <span><code>["eat", "tea", "tan", "ate", "nat", "bat"]</code></span>
<strong>输出: </strong>[["bat"],["nat","tan"],["ate","eat","tea"]]</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> strs = <span><code>[""]</code></span>
<strong>输出: </strong>[[""]]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> strs = <span><code>["a"]</code></span>
<strong>输出: </strong>[["a"]]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= strs[i].length &lt;= 100</code></li> 
 <li><code>strs[i]</code>&nbsp;仅包含小写字母</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 字符串 | 排序</details><br>

<div>👍 1668, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

异位词这类问题的关键在于，你如何迅速判断两个字符串是异位词，主要考察数据编码和 [哈希表](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_6265484ae4b01a4851f65633/6) 的使用：

你是否可以找到一种编码方法，使得字母异位词的编码都相同？找到这种编码方式之后，就可以用一个哈希表存储编码相同的所有异位词，得到最终的答案。

[242. 有效的字母异位词](/problems/valid-anagram) 考察了异位词的编码问题，对字符串排序可以是一种编码方案，如果是异位词，排序后就变成一样的了，但是这样时间复杂度略高，且会修改原始数据。更好的编码方案是利用每个字符的出现次数进行编码，也就是下面的解法代码。

**标签：哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // 编码到分组的映射
        unordered_map<string, vector<string>> codeToGroup;
        for (string s : strs) {
            // 对字符串进行编码
            string code = encode(s);
            // 把编码相同的字符串放在一起
            codeToGroup[code].push_back(s);
        }

        // 获取结果
        vector<vector<string>> res;
        for (auto group : codeToGroup) {
            res.push_back(group.second);
        }

        return res;
    }

    // 利用每个字符的出现次数进行编码
    string encode(string s) {
        vector<char> count(26, 0);
        for (char c : s) {
            int delta = c - 'a';
            count[delta]++;
        }
        string code(count.begin(), count.end());
        return code;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 编码到分组的映射
        codeToGroup = {}
        for s in strs:
            # 对字符串进行编码
            code = self.encode(s)
            # 把编码相同的字符串放在一起
            if code not in codeToGroup:
                codeToGroup[code] = []
            codeToGroup[code].append(s)

        # 获取结果
        res = []
        for group in codeToGroup.values():
            res.append(group)

        return res

    # 利用每个字符的出现次数进行编码
    def encode(self, s: str) -> str:
        count = [0] * 26
        for c in s:
            delta = ord(c) - ord('a')
            count[delta] += 1
        return str(count)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 编码到分组的映射
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            // 对字符串进行编码
            String code = encode(s);
            // 把编码相同的字符串放在一起
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        // 获取结果
        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    // 利用每个字符的出现次数进行编码
    String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func groupAnagrams(strs []string) [][]string {
    // 编码到分组的映射
    codeToGroup := make(map[string][]string)
    for _, s := range strs {
        // 对字符串进行编码
        code := encode(s)
        // 把编码相同的字符串放在一起
        codeToGroup[code] = append(codeToGroup[code], s)
    }

    // 获取结果
    res := make([][]string, 0, len(codeToGroup))
    for _, group := range codeToGroup {
        res = append(res, group)
    }

    return res
}

// 利用每个字符的出现次数进行编码
func encode(s string) string {
    count := make([]byte, 26)
    for i := 0; i < len(s); i++ {
        delta := s[i] - 'a'
        count[delta]++
    }
    return string(count)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var groupAnagrams = function(strs) {
    // 编码到分组的映射
    let codeToGroup = new Map();
    for (let s of strs) {
        // 对字符串进行编码
        let code = encode(s);
        // 把编码相同的字符串放在一起
        if (!codeToGroup.has(code)) {
            codeToGroup.set(code, []);
        }
        codeToGroup.get(code).push(s);
    }

    // 获取结果
    let res = [];
    for (let group of codeToGroup.values()) {
        res.push(group);
    }

    return res;
};

// 利用每个字符的出现次数进行编码
function encode(s) {
    let count = new Array(26).fill(0);
    for (let c of s) {
        let delta = c.charCodeAt() - 'a'.charCodeAt();
        count[delta]++;
    }
    return count.toString();
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_group-anagrams" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_group-anagrams"></div></div>
</details><hr /><br />

</details>
</div>

