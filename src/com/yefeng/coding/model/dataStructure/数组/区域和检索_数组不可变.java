package com.yefeng.coding.model.dataStructure.数组;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 区域和检索_数组不可变.java
 * @Description TODO
 * @createTime 2022年06月29日 08:52:00
 */

/*
     给定一个整数数组  nums，处理以下类型的多个查询:

     计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
     实现 NumArray 类：

     NumArray(int[] nums) 使用数组 nums 初始化对象
     int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的
     总和 ，包含 left 和 right 两点（
     也就是 nums[left] + nums[left + 1] + ... + nums[right] )
     来源：力扣（LeetCode）
     链接：https://leetcode.cn/problems/range-sum-query-immutable
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class 区域和检索_数组不可变 {
    class NumArray {
        private int[] preSum;
        public NumArray(int[] nums) {
            int len=nums.length;
            preSum=new int[len+1];

            for(int i=1;i<len+1;++i){
                preSum[i]=preSum[i-1]+nums[i-1];
            }

        }



        public int sumRange(int left, int right) {
            return preSum[right+1]-preSum[left];
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        NumArray numArray = new 区域和检索_数组不可变().new NumArray(nums);
        System.out.println(numArray.sumRange(1, 3));

    }
}
