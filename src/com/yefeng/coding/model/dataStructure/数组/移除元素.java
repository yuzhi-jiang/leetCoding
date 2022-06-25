package com.yefeng.coding.model.dataStructure.数组;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 移除元素.java
 * @Description TODO
 * @createTime 2022年06月25日 15:38:00
 */
/**
 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 来源：力扣（LeetCode）
 todo 链接：https://leetcode.cn/problems/remove-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 移除元素 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int len=nums.length;
            if(len==0)return 0;
            int fast=0;
            int slow=0;

            while(fast<len){
                if(nums[fast]!=val){
                    nums[slow++]=nums[fast];
                }
                fast++;
            }
            return slow;//先用后加，最后一个已经加了
        }
    }

    public static void main(String[] args) {
        Solution solution = new 移除元素().new Solution();
        int[] arr = {0,1,2,2,3,0,4,2};
        int index = solution.removeElement(arr, 2);
        for (int i = 0; i < index; i++) {
            System.out.print( arr[i]+" ");
        }
    }
}
