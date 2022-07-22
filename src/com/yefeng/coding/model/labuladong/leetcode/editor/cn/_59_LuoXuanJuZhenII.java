package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 螺旋矩阵 II _59_螺旋矩阵 II.java
 * @createTime 2022-07-22 22:47:54
 */
//螺旋矩阵 II -- spiral-matrix-ii
public class _59_LuoXuanJuZhenII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            return solve1(n);
        }

        private int[][] solve1(int n) {
            int[][] matrix = new int[n][n];

            //四个边界
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = n - 1;

            int nums = 1;

            while (nums <= n * n) {
                if (top <= bottom) {//存上边的行
                    for (int i = left; i <= right; i++) {
//                        res.add(matrix[top][i]);
                        matrix[top][i] = nums++;
                    }
                    top++;
                }
                if (right >= left) {//存右边的列
                    for (int i = top; i <= bottom; i++) {
                        matrix[i][right] = nums++;
                    }
                    right--;
                }
                if (bottom >= top) {//存下边的行
                    for (int i = right; i >= left; i--) {
//                        res.add(matrix[bottom][i]);
                        matrix[bottom][i] = nums++;
                    }
                    bottom--;
                }
                if (left <= right) {//读取左边的列
                    for (int i = bottom; i >= top; i--) {
//                        res.add(matrix[i][left]);
                        matrix[i][left] = nums++;
                    }
                    left++;
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _59_LuoXuanJuZhenII().new Solution();
        int[][] ints = solution.generateMatrix(1);
        System.out.println(Arrays.deepToString(ints));
    }
}

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * <p>
 * Related Topics数组 | 矩阵 | 模拟
 * <p>
 * 👍 767, 👎 0
 */
