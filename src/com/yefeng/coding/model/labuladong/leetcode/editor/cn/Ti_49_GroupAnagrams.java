package com.yefeng.coding.model.labuladong.leetcode.editor.cn;


import com.yefeng.coding.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * [49]字母异位词分组
 *
 * @author 夜枫
 * 2022-11-06 23:05:19
 */
public class Ti_49_GroupAnagrams {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return solutionBySort(strs);
        }

        public List<List<String>> solutionBySort(String[] strs) {
            HashMap<String,List<String>> map=new HashMap<>();
            for (String str : strs) {
//                对str进行排序
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                if(map.containsKey(key)){
                    map.get(key).add(str);
                }else{
                    ArrayList<String > list = new ArrayList<>();
                    list.add(str);
                    map.put(key,list);
                }
            }
            return new ArrayList<>(map.values());
        }
        public List<List<String>> solutionByCount(String[] strs) {

            HashMap<String,List<String>> map=new HashMap<>();
            for (String str : strs) {

//                对str进行排序
                byte[] sort=new byte[26];
                for(byte i=0;i<str.length();++i){
                    sort[str.charAt(i)-97]++;
                }
                StringBuilder builder=new StringBuilder();
                for (int i = 0; i < sort.length; i++) {
                    if(sort[i]!=0){
                        char c= (char) (i+97);
                        builder.append(c);
                        builder.append(sort[i]);
                    }
                }
                String key= builder.toString();
                if(map.containsKey(key)){
                    map.get(key).add(str);
                }else{
                    ArrayList<String > list = new ArrayList<>();
                    list.add(str);
                    map.put(key,list);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
//        String str="bca";
//        char[] charArray = str.toCharArray();
//        Arrays.sort(charArray);
//        String string = Arrays.toString(charArray);
//        System.out.printf("sort:"+string.toString());
        Solution solution = new Ti_49_GroupAnagrams().new Solution();
        List<List<String>> lists = solution.groupAnagrams(Arrays.asList("ddddddddddg","dgggggggggg").toArray(new String[0]));
        System.out.println(lists);

    }
}

/*

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics数组 | 哈希表 | 字符串 | 排序 
//
// 👍 1668, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


*/