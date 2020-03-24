package com.shengsiyuan.jvm.classloader;

import java.util.UUID;

/**
 * 此常量不是编译能确定的异常，会去初始化MyParents类
 *
 * 当常量的值并非编译期间可以确定的异常，那么其值就不会放到调用类的常量池中
 * 这是程序在运行时，会导致主动使用这个常量所在的类，显然就会导致这个类被初始化。
 * */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}
