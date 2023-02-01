package com.yefeng.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class testAA {
    static int f(int a, int b) {
        int c;
        do {
            c = a ^ b;
            b = a & b << 1;
            a = c;
        } while (b != 0);
        return c;
    }

    public static void main(String[] args) {
        System.out.println(f(47, -42));
    }

    public static void main1(String[] args) throws InterruptedException {
        MyDate myDate = new MyDate();


        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override

                public void run() {
                    myDate.add();
                }
            });

            threads.add(thread);

            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    myDate.sub();
                }
            });

            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();//线程等待
        }


        System.out.println(myDate.get());

    }
}

class MyDate {
    volatile private int j = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void add() {

        for (int i = 0; i < 100; i++) {
            atomicInteger.incrementAndGet();
        }

        System.out.println(Thread.currentThread().getName() + " add:" + atomicInteger.get());

    }

    public void sub() {
        // j--;
        for (int i = 0; i < 50; i++) {
            atomicInteger.decrementAndGet();
        }
        System.out.println(Thread.currentThread().getName() + "---- sub:" + atomicInteger.get());

    }

    public int get() {

        return atomicInteger.get();
    }
}