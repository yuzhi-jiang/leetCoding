package com.yefeng.coding.util;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName ArryUtil.java
 * @Description TODO
 * @createTime 2022年06月25日 16:14:00
 */
public class ArrayUtil {
    public static int[] createByArg(int ... arg){
        int length = arg.length;
        int[] resArr = new int[length];
        System.arraycopy(arg, 0, resArr, 0, length);
        return resArr;
    }


    /**
     * @param arr 数组
     * @title traverseArray
     * @author yefeng
     * @description TODO 顺序遍历数组
     * @updateTime 2022/06/25
     */
    public static void traverseArray(int[] arr){
        if (arr.length==0){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println(arr[arr.length-1]);
    }
    public static void checkArrayIndexOut(int[] arr){
        if (arr.length==0)
            throw new IndexOutOfBoundsException("数组长度为0");
        System.out.println("sadf");
    }
    public static void reverseArray(int[] s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 交换 s[left] 和 s[right]
//            int temp = s[left];
//            s[left] = s[right];
//            s[right] = temp;

            s[left]=s[left]^s[right];
            s[right]= s[left]^s[right];
            s[left]= s[left]^s[right];
            left++;
            right--;
        }
    }

    public static void niXuTraverseArray(int[] arr){
        checkArrayIndexOut(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[0]);
    }



    public static void main(String[] args) {
        int[] byArg = ArrayUtil.createByArg(1, 2, 3, 4);
        ArrayUtil.traverseArray(byArg);
        ArrayUtil.niXuTraverseArray(byArg);

        ArrayUtil.reverseArray(byArg);

        ArrayUtil.traverseArray(byArg);
        ArrayUtil.niXuTraverseArray(byArg);

    }
}
