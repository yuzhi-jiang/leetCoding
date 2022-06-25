package com.yefeng.coding.model.dataStructure.数组;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 移除0.java
 * @Description TODO 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *               todo 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 https://leetcode.cn/problems/move-zeroes/
 * @createTime 2022年06月25日 15:49:00
 */
public class 移除零 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int len=nums.length;
            if(len==0||len==1)return;

            int fast=0;
            int slow=0;
            while(fast<len){
                if(nums[fast]!=0){
                    nums[slow]=nums[fast];
                    slow++;
                }
                fast++;
            }
            for(int i=slow;i<len;++i){
                nums[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,3,12};
        Solution solution = new 移除零().new Solution();
        solution.moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i+ " ");
        }
    }
}
