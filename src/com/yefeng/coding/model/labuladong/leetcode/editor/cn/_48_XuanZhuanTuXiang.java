package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 旋转图像 _48_旋转图像.java
 * @createTime 2022-07-22 21:21:56
 */
//旋转图像 -- rotate-image
public class _48_XuanZhuanTuXiang {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for (int[] ints : matrix) {
                reverse(ints);
            }
        }

        void reverse(int[] arr) {
            int l, r;
            l = 0;
            r = arr.length - 1;
            while (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new _48_XuanZhuanTuXiang().new Solution();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(arr));
        solution.rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * <p>
 * <p>
 * <p>
 * Related Topics数组 | 数学 | 矩阵
 * <p>
 * 👍 1368, 👎 0
 */
