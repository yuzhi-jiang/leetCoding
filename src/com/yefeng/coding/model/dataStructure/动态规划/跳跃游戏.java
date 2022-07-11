package com.yefeng.coding.model.dataStructure.动态规划;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 跳跃游戏.java
 * @Description TODO
 * @createTime 2022年07月09日 18:59:00
 */
public class 跳跃游戏 {
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int max = 0;//最远点
            for (int i = 0; i < len - 1; ++i) {  //len-1 是最后一个必定能到它自己
                max = Math.max(max, i + nums[i]);
                // System.out.println("Hello World");
                //   System.out.println("max="+max+" i="+i);

                if (max <= i) {//最远点小于等于当前点（等于意外着当前节点遇到0这个老六过不去）
                    return false;
                }
            }
            // 判断一下最远点是否到n-1（最后这个节点下标） >=  大于即超过
            return (max >= len - 1);
        }
    }
}
