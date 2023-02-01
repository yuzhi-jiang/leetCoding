package com.yefeng.coding.test;


public class Main {

    int globalInt = 10;

    public static void main(String[] args) {
        People people = new People();
        people.setAge(18);
        people.setName("hello");

        Main main = new Main();
        System.out.println(Main.getType(people));
        System.out.println(people);
        People people1 = main.changePeople(people);
        System.out.println(people1);
        System.out.println(Main.getType(people1));


    }

    public static String getType(Object o) { //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }


    public void test() {

        add(globalInt);

        System.out.println(globalInt);

    }

    private void add(int t) {
        t = 20;
    }

    private void change(int a) {
        a = a + 1;
    }

    private void change(String a) {
        a = "word";
    }

    public People changePeople(People people) {
        people.setName("word");
        people.setAge(10);
        return people;
    }
}
