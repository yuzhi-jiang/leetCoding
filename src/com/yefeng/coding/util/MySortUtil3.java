package com.yefeng.coding.util;

/**
 * This class is for
 *
 * @author 夜枫
 * @version 2022-11-07 14:18
 */
public class MySortUtil3 {
    public static void main(String[] args) {
        int[] a = {2, 5, 35, 7, 23, 56};
        int i;
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        quickSort(a);
        //bubbleSort2(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

    }

    /**
     * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，每次遍历时，
     * 它都会从前往后依次的比较相邻两个数的大小；如果前者比后者大，则交换它们的位置。
     * 这样，一次遍历之后，最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，
     * 第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
     *
     * @param nums 待排序数组
     */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j + 1] ^ nums[j];
                    nums[j + 1] = nums[j + 1] ^ nums[j];
                    nums[j] = nums[j + 1] ^ nums[j];
                }
            }
        }
    }

    /**
     * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小元素，
     * 然后放到第二个元素位置。以此类推，直到所有元素均排序完毕
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                nums[i] = nums[min] ^ nums[i];
                nums[min] = nums[min] ^ nums[i];
                nums[i] = nums[min] ^ nums[i];
            }
        }
    }

    /**
     * 基本思想是: 把n个待排序的元素看成为一个有序表和一个无序表。
     * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素
     * ，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，
     * 使之成为新的有序表，重复n-1次可完成排序过程
     *
     * @param nums the array
     */
    public static void insertSort(int[] nums) {
        int n = nums.length;
        int j;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];

            for (j = i - 1; j >= 0; j--) {
                if (cur > nums[j]) {
                    break;
                }
            }


            //找到了合适的位置 在j+1的后面插入
            if (j != i - 1) {
                for (int k = i - 1; k > j; k--) {
                    nums[k + 1] = nums[k];
                }
                nums[j + 1] = cur;
            }
        }
    }

    /**
     * 假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。在桶排序时，
     * 创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
     * 在排序时，逐个遍历数组a，将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。
     * 例如，读取到数组a[3]=5，则将r[5]的值+1
     *
     * @param a
     * @param max
     */
    public static void bucketSort(int[] a, int max) {
        if (a == null || a.length < 2 || max < 2) {
            return;
        }
        int[] bucket = new int[max];
        for (int i : a) {
            bucket[i]++;
        }
        //sort
        for (int i = 0, j = 0; i < max; i++) {
            while (bucket[i]-- > 0) {
                a[j++] = i;
            }
        }
        bucket = null;//empty bucket
    }


    /**
     * 链接：<a href="https://pdai.tech/md/algorithm/alg-sort-x-fast.html">快速排序</a>
     * <br>
     * 它的基本思想是: 选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
     * 其中一部分的所有数据都比另外一部分的所有数据都要小。然后，
     * 再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int cur = arr[l];

            //i>=j break
            while (l < r) {
                while (l < r && arr[r] > cur) {//找到左边大于基数值
                    r--;
                }
                if (l < r) {//如果合法下标
                    arr[l++] = arr[r];
                }
                while (l < r && arr[l] < cur) {
                    l++;
                }
                if (l < r) {
                    arr[r--] = arr[l];
                }
            }
            //l==r
            arr[l] = cur;
            quickSort(arr, left, r - 1);
            quickSort(arr, r + 1, right);

        }
    }
}
