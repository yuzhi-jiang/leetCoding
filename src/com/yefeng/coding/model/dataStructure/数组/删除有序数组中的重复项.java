package com.yefeng.coding.model.dataStructure.数组;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 删除有序数组中的重复项.java
 * @Description TODO
 * @createTime 2022年06月24日 17:55:00
 */

/**
 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。

 将最终结果插入 nums 的前 k 个位置后返回 k 。

 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除有序数组中的重复项 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int len=nums.length;
            if(len==0)return 0;
            int fast,slow;
            fast=0;
            slow=0;

            while(fast<len){//todo 快慢指针 当快指针!=慢指针 慢指针后移且等于快指针的值
                if(nums[fast]!=nums[slow]){
                    nums[++slow]=nums[fast];
                }
                fast++;
            }

            return slow+1; //todo 数组长度为索引 + 1
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        Solution solution = new 删除有序数组中的重复项().new Solution();

        int end = solution.removeDuplicates(arr);
        int maxSize=arr.length;
        System.out.println("end:"+end);
        for (int i = 0; i < end; i++) {
            System.out.print(String.valueOf(arr[i])+" ");
        }
    }
}
