package com.yefeng.coding.model.labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName O(1) 时间插入、删除和获取随机元素 _380_O(1) 时间插入、删除和获取随机元素.java
 * @createTime 2022-07-25 16:37:03
 */
//O(1) 时间插入、删除和获取随机元素 -- insert-delete-getrandom-o1
public class _380_ShiJianChaRu_ShanChuHeHuoQuSuiJiYuanSu {
    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        List<Integer> list;
        HashMap<Integer, Integer> map;
        Random random = new Random();

        public RandomizedSet() {
            list = new ArrayList<>(200001);
            map = new HashMap<>(200001);
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;


            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                //删除元素
                int index = map.get(val);
                int lastVal = list.get(list.size() - 1);
                map.put(lastVal, index);


                //交互index 和 最后一个元素,然后删除最后一个元素，，也可以先用最后一个数覆盖index的值再直接删除index
                list.set(index, lastVal);
                //删除最后一个元素
                list.remove(list.size() - 1);

                //删除map中的key
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        RandomizedSet solution = new _380_ShiJianChaRu_ShanChuHeHuoQuSuiJiYuanSu().new RandomizedSet();

    }
}

/**
 * 实现RandomizedSet 类：
 * <p>
 * <p>
 * <p>
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * <p>
 * <p>
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert",
 * "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -2³¹ <= val <= 2³¹ - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 * <p>
 * <p>
 * <p>
 * Related Topics设计 | 数组 | 哈希表 | 数学 | 随机化
 * <p>
 * 👍 577, 👎 0
 */
