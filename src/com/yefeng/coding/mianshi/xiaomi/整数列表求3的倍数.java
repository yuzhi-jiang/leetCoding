package com.yefeng.coding.mianshi.xiaomi;

public class 整数列表求3的倍数 {


    public static int fun(int n) {
        int num = n;
        int temp = 0;
        int res = -1;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        do {


            temp++;

            //找到下一个没有访问的

            while (vis[++res]) {
//                res++;
                if (res == n - 1) {
                    res = -1;
                }
            }


            if (num == 1) return res + 1;

            //   System.out.println("没有访问的:"+(res+1));

            if (temp == 3) {
                vis[res] = true;
                num--;
                //      System.out.println("去掉的是："+(res+1));
                temp = 0;
            }

            if (res == n - 1) {
                res = -1;
            }

        } while (true);


    }

    public static void main(String[] args) {
        int fun = fun(4);
        System.out.println(fun);
    }


}
