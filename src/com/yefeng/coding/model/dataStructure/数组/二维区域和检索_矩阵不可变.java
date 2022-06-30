package com.yefeng.coding.model.dataStructure.数组;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName 二维区域和检索_矩阵不可变.java
 * @Description TODO
 * @createTime 2022年06月29日 09:10:00
 */
/*
 304. 二维区域和检索 - 矩阵不可变
 给定一个二维矩阵 matrix，以下类型的多个请求：

 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 实现 NumMatrix 类：

 NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。

 */


public class 二维区域和检索_矩阵不可变 {

    class NumMatrix {
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int rowLen=matrix.length;
            int collLen=matrix[0].length;
            preSum=new int[rowLen+1][collLen+1];
            for (int i = 1; i < rowLen+1; i++) {
                for (int j = 1; j < collLen+1; j++) {
//
//                    matrix[i-1][j-1]=preSum[i][j]-preSum[i-1][j]-preSum[i][j-1]+preSum[i-1][j-1];
                    preSum[i][j]=matrix[i-1][j-1]+preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1];



                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1]-preSum[row1][col2+1]-preSum[row2+1][col1]+preSum[row1][col1];
        }
    }

}
