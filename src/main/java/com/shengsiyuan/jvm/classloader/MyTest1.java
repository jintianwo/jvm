package com.shengsiyuan.jvm.classloader;

/**
 * 主动使用被动使用的实例讲解
 * 1。对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 2。当一个类在初始化时，要求其全部父类都已经初始化完成了
 * 3。 -XX:+TraceClassLoading ,用于追踪类的加载信息并打印出来
 *
 * jvm参数格式
 *  -XX:+<option>,表示开启option选项
 *  -XX:-<option>,表示关闭option选项
 *  -XX:<option>=<value>,表示给option赋值
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }
}

class MyParent1{
    public static String str = "ddd";

    static {
        System.out.println("myparent1");
    }
}

class MyChild1 extends MyParent1{
    public static String str2 = "ddd2222";

    static {
        System.out.println("mychild1");
    }
}
