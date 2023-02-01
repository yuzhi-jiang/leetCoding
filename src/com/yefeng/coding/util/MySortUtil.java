package com.yefeng.coding.util;

/**
 * This class is for
 *
 * @author 夜枫
 * @version 2022-11-06 21:07
 */
public class MySortUtil {


    public static void main(String[] args) {
        int[] a = {2, 5, 35, 7, 23, 56};
        int i;
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        bucketSort(a, 61);
        //bubbleSort2(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

    }


    /**
     * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小元素，
     * 然后放到第二个元素位置。以此类推，直到所有元素均排序完毕
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        int size = nums.length;
        int min;
        for (int i = 0; i < size; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
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
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
        }
    }


//    插入排序

    /**
     * 基本思想是: 把n个待排序的元素看成为一个有序表和一个无序表。
     * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素
     * ，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，
     * 使之成为新的有序表，重复n-1次可完成排序过程
     *
     * @param arrs the array
     */
    public static void insertSort(int[] arrs) {
        int n = arrs.length;
        int j;
        for (int i = 1; i < n; i++) {
            //在有序中，看看合适的位置插入
            for (j = i - 1; j >= 0; j--) {
                if (arrs[i] > arrs[j]) {
                    break;
                }
            }
            if (j != i - 1) {
                //交换 j为目标位置
                int temp = arrs[i];
                for (int t = i - 1; t > j; t--) {
                    arrs[t + 1] = arrs[t];
                }
                arrs[j + 1] = temp;
            }
        }


    }

    public static void insertSort(int[] a, int n) {
        int i, j, k;
        for (i = 1; i < n; i++) {
            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    break;
                }
            }
            //如找到了一个合适的位置
            if (j != i - 1) {
                //将比a[i]大的数据向后移
                int temp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                //将a[i]放到正确位置上
                a[k + 1] = temp;
            }
        }
    }


    /**
     * 链接：https://pdai.tech/md/algorithm/alg-sort-x-bucket.html
     * <p>
     * 假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。在桶排序时，
     * 创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
     * 在排序时，逐个遍历数组a，将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。
     * 例如，读取到数组a[3]=5，则将r[5]的值+1
     *
     * @param a
     * @param max
     */
    public static void bucketSort(int[] a, int max) {
        int[] bucket;
        if (a == null || a.length == 0 || max < 1) {
            return;
        }
        bucket = new int[max];
        //计数
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
        //排序
        //0.....max
        for (int i = 0, j = 0; i < max; i++) {
            while (bucket[i]-- > 0) {
                a[j++] = i;
            }
        }
        bucket = null;
    }
}
