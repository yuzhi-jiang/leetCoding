package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

/**
 * @author 夜枫
 * 2023-10-14 11:14:28
 * 岛屿数量
 */
public class Ti_200_NumberOfIslands {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            return func2(grid);
        }

        public int func1(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }

        private int[] p;
        private int[] size;

        public int func2(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            p = new int[n * m];
            size = new int[n * m];
            for (int i = 0; i < n * m; ++i) {
                p[i] = i;
                size[i] = 1;
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == '1') {
                        for (int[] d : dirs) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
                                int a = find(i * m + j);
                                int b = find(x * m + y);
                                if (a != b) {
                                    if (size[a] > size[b]) {
                                        p[b] = a;
                                        size[a] += size[b];
                                    } else {
                                        p[a] = b;
                                        size[b] += size[a];
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n * m; ++i) {
                if (grid[i / m][i % m] == '1' && find(i) == i) {
                    ++ans;
                }
            }
            return ans;
        }

        private int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Ti_200_NumberOfIslands().new Solution();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = solution.numIslands(grid);
        System.out.printf("i=" + i);
    }
}

/**
 * //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * //
 * // 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * //
 * // 此外，你可以假设该网格的四条边均被水包围。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：grid = [
 * //  ["1","1","1","1","0"],
 * //  ["1","1","0","1","0"],
 * //  ["1","1","0","0","0"],
 * //  ["0","0","0","0","0"]
 * //]
 * //输出：1
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：grid = [
 * //  ["1","1","0","0","0"],
 * //  ["1","1","0","0","0"],
 * //  ["0","0","1","0","0"],
 * //  ["0","0","0","1","1"]
 * //]
 * //输出：3
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // m == grid.length
 * // n == grid[i].length
 * // 1 <= m, n <= 300
 * // grid[i][j] 的值为 '0' 或 '1'
 * //
 * //
 * // Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵
 * //
 * // 👍 2324, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 * //
 * //
 * //
 * //
 * <p>
 * <p>
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 */