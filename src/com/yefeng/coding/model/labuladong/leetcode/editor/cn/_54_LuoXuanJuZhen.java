package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 螺旋矩阵 _54_螺旋矩阵.java
 * @createTime 2022-07-22 21:20:33
 */
//螺旋矩阵 -- spiral-matrix
public class _54_LuoXuanJuZhen {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            return solve1(matrix);
        }

        private List<Integer> solve1(int[][] matrix) {
            int rows = matrix.length;//行数
            int lows = matrix[0].length;//列数

            //四个边界
            int left = 0;
            int right = lows - 1;
            int top = 0;
            int bottom = rows - 1;

            List<Integer> res = new ArrayList<>();

            while (res.size() < rows * lows) {
                if (top <= bottom) {//读取上边的行
                    for (int i = left; i <= right; i++) {
                        res.add(matrix[top][i]);
                    }
                    top++;
                }
                if (right >= left) {//读取右边的列
                    for (int i = top; i <= bottom; i++) {
                        res.add(matrix[i][right]);
                    }
                    right--;
                }
                if (bottom >= top) {//读取下边的行
                    for (int i = right; i >= left; i--) {
                        res.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
                if (left <= right) {//读取左边的列
                    for (int i = bottom; i >= top; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _54_LuoXuanJuZhen().new Solution();
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = solution.spiralOrder(arr);

        System.out.println(list);
    }
}

/**
 * /**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * Related Topics数组 | 矩阵 | 模拟
 * <p>
 * 👍 1150, 👎 0
 */

