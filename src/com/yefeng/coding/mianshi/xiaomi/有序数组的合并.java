package com.yefeng.coding.mianshi.xiaomi;

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


    public static void main(String[] args) {
        int i = 0;
        int a[] = {3, 6, 4, 8, 5, 6};
        do {
            a[i] -= 3;
        } while (a[i++] < 4);
        for (i = 0; i < 6; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
