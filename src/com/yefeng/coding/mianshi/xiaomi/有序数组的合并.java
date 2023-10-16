package com.yefeng.coding.mianshi.xiaomi;

import java.util.Arrays;

/*
【两个有序数组合并】
问题描述:
给定两个有序整数数组 A 和 B，将B合并到A中，使得 A 成为一个有序数组。
说明:
1. 初始化 A 和 B 的元素数量分别为 m 和 n。
2. A有足够的空间（空间大小大于或等于 m + n）来保存 B 中的元素。
3. 默认升序。
 */
public class 有序数组的合并 {

    public static int[] fun(int[] m, int[] n) {
        int m_point, n_point;
        m_point = n_point = 0;
        int index = 0;
        int temp;

        while (n_point < n.length && m.length > m_point) {

            if (m_point < m.length - 1 && m[m_point] <= n[n_point]) {
                m_point++;
                index++;
            } else {
                temp = n[n_point];
                n_point++;
                for (int i = m.length - 1; i > index; --i) {
                    m[i] = m[i - 1];
                }
                m[index] = temp;

                m_point++;
                index++;
            }
        }
        return m;

    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        Arrays.fill(sorted, 0);
        int cur;
        int t = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
//            sorted[p1 + p2 - 1] = cur;
            sorted[t++] = cur;
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
        sorted = null;
    }

    static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


    public static void main(String[] args) {
        int i = 0;
        int a[] = {1, 2, 3, 0, 0, 0, 0};
        int b[] = {2, 5, 6};
        merge(a, 3, b, 3);
        for (int i1 : a) {
            System.out.println(i1);
        }

    }

}
