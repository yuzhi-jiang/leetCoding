package com.yefeng.coding.model.dataStructure.数组;

import com.yefeng.coding.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName nSum.java
 * @Description TODO https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_62987931e4b0cedf38ba0684/1 https://leetcode.cn/problems/4sum/submissions/
 * @createTime 2022年06月25日 22:54:00
 */
public class nSum {
    private List<List<Integer>> twoSumTarget(
            int[] nums, int start, int target) {
        // 左指针改为从 start 开始，其他不变
        ArrayList<List<Integer>> res = new ArrayList<>();
        int lo, hi;
        lo = start;
        hi = nums.length - 1;
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            if (nums[lo] == target - nums[hi]) {
                ArrayList<Integer> tem = new ArrayList<>(2);

                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;

                tem.add(left);
                tem.add(right);
                res.add(tem);

            } else if (nums[lo] < target - nums[hi]) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (nums[lo] > target - nums[hi]) {
                while (lo < hi && nums[hi] == right) hi--;

            }
        }

        return res;
//        int lo = start;
//        int hi = nums.length - 1;
//        vector<vector<int>> res;
//        while (lo < hi) {
//        ...
//        }
//        return res;
    }


    public List<List<Integer>> solveNSum(int[] arr, int n, int start, int target) {
        Arrays.sort(arr);
        return nSumToTarget(arr, n, start, target);
    }

    private List<List<Integer>> nSumToTarget(int[] arr, int n, int start, int target) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = arr.length;
        if (n < 2 || len < n) return res;
        double min, max, count;
        if (n == 2) {
            return twoSumTarget(arr, start, target);
        }

//       todo 遍历第一个数
        for (int i = start; i <= len-n; i++) {

            // todo find the min or max if max < target 或者 min > target then continue
            min = max = 0;
            count = 0;
            for (int t = i; t < len && count < n; ++t, ++count) {
                min += arr[t];
            }
            if (min > target) {
                continue;
            }

            count = 0;
            for (int it=1;it<=n;it++){
                max+=arr[len-it];
            }
            if (max < target) {
                continue;
            }


            //todo
            List<List<Integer>> sub = nSumToTarget(arr, n - 1, i + 1, target - arr[i]);


//            for (int it = 0; it < sub.size(); it++) {
//                List<Integer> item=sub.get(it);
//                System.out.println(arr[i]);
//                sub.get(it).add(arr[i]);
//                res.add(item);
//            }
            for (List<Integer> item : sub) {
                // (n-1)Sum 加上 nums[i] 就是 nSum
                item.add(arr[i]);
                res.add(item);
            }
            while (i < len - n && arr[i] == arr[i + 1]) i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.createByArg(-1, 1, 0, 1000000000, 1000000000, 1000000000, 1000000000, 0);
        nSum nSum = new nSum();
        List<List<Integer>> lists = nSum.solveNSum(arr, 4, 0, 0);
        lists.forEach(System.out::println);

    }
}
