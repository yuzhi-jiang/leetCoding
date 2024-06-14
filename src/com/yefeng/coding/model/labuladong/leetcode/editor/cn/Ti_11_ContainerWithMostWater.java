package com.yefeng.coding.model.labuladong.leetcode.editor.cn;


/**
 * [11]盛最多水的容器
 * @author 夜枫
 * 2022-11-06 23:05:19
 */
public class Ti_11_ContainerWithMostWater {

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int maxArea(int[] height) {
//
//    }
//}


    class Solution {
        int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int l_max = 0, r_max = 0;

            int res = 0;
            while (left < right) {
                l_max = Math.max(l_max, height[left]);
                r_max = Math.max(r_max, height[right]);
                System.out.println("h:"+height[left]+"-- :"+height[right]);
                System.out.println("max:"+l_max+" -- :"+r_max);
                System.out.println("index :"+left+" -- :"+right);
                // res += min(l_max, r_max) - height[i]
                if (l_max < r_max) {
                    System.out.println("left add:"+(l_max - height[left]));
                    res += l_max - height[left];
                    left++;
                } else {
                    System.out.println("right add:"+(r_max - height[right]));
                    res += r_max - height[right];
                    right--;
                }
                System.out.println(          );
            }
            return res;
        }

        public int maxArea(int[] height) {
            int left=0,right=height.length-1;
            int res=0;

            while (left<right){

                res=Math.max(res,Math.min(height[left],height[right])*(right-left));
                //移动小的那边的柱子,可以使得面积变化,如果移动大的柱子,则会导致结果不会变化,并且有的结无法匹配
                if (height[left]<height[right]){
                    left++;
                }else {
                    right--;
                }
            }


            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)




    public static void main(String[] args) {
        Solution solution = new Ti_11_ContainerWithMostWater().new Solution();

    }
}

/*

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics贪心 | 数组 | 双指针 
//
// 👍 5002, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


*/