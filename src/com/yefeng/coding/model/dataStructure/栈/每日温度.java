package com.yefeng.coding.model.dataStructure.栈;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * This class is for
 *
 * @author 夜枫
 * @version 2022-11-06 15:01
 */
public class 每日温度 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {

            int size = temperatures.length;
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

            int[] res = new int[size];
            for (int i = size - 1; i >= 0; i--) {

                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
                stack.push(i);
            }


            return res;


        }
    }

    public static void main(String[] args) {
        int[] ints = new 每日温度().new Solution().dailyTemperatures(ArrayUtil.createByArg(73, 74, 75, 71, 69, 72, 76, 73));

        Arrays.stream(ints).forEach(System.out::println);

    }
}
