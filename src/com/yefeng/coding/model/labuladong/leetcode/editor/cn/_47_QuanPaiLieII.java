import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 全排列 II _47_全排列 II.java
 * @createTime 2022-07-11 21:39:40
 */
//全排列 II -- permutations-ii
public class _47_QuanPaiLieII {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        private void backtrack(int[] nums) {
            if (nums.length == track.size()) {
                res.add(new ArrayList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                if (used[i]) {
                    continue;
                }
                // !used[i - 1] = true 2 ,2` 要用2`首先需用2  2,2`,2``同理 2``要用需先用2`
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                //选择
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums);

                used[i] = false;
                track.remove(track.size() - 1);

            }
        }
//leetcode submit region end(Prohibit modification and deletion)


    }

    public static void main(String[] args) {
        Solution solution = new _47_QuanPaiLieII().new Solution();
        List<List<Integer>> lists = solution.permuteUnique(ArrayUtil.createByArg(1, 1, 2));

        lists.forEach(System.out::println);

    }
}

/*
  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
  
  
  
  示例 1：
  
  
  输入：nums = [1,1,2]
  输出：
  [[1,1,2],
  [1,2,1],
  [2,1,1]]
  
  
  示例 2：
  
  
  输入：nums = [1,2,3]
  输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  
  
  
  
  提示：
  
  
  1 <= nums.length <= 8
  -10 <= nums[i] <= 10
  
  Related Topics数组 | 回溯
  
  👍 1118, 👎 0
 */
