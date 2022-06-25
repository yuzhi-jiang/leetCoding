package com.yefeng.coding.util;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName CharUtil.java
 * @Description TODO
 * @createTime 2022年06月25日 16:32:00
 */
public class CharUtil {
    public static void reverseString(char[] s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 交换 s[left] 和 s[right]
//            char temp = s[left];
//            s[left] = s[right];
//            s[right] = temp;

            s[left]= (char) (s[left]^s[right]);
            s[right]= (char) (s[left]^s[right]);
            s[left]= (char) (s[left]^s[right]);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b','c'};
        reverseString(chars);
        for (char aChar : chars) {
            System.out.print(aChar+" ");
        }
    }
}
