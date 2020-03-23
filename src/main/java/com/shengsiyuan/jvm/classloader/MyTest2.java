package com.shengsiyuan.jvm.classloader;

/**
 * 常量的本质含义与反编译及助记符详解
 *
 * 在编译阶段，这个常量就会被存入到调用这个常量的那个方法所在的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 *
 * 注意，这里指的是将常量存放到了MyTest2 的常量池中，之后MyTest2就与MyParent2没有关系了
 * 甚至，我们可以将MyParent2的class文件删除。
 *
 * 反编译class 文件
 *  cd 到 .class文件目录
 *   执行 javap -c  MyTest2（.class文件）
 *
 *
 * 助记符：
 *  ldc表示将int,float或是string类型的常量值从从常量池中推至栈顶
 *  bipush表示将单字节（-128 - 127）的常量值从从常量池中推至栈顶
 *  sipush表示将一个短整型常量值（-32768 - 32767） 推至栈顶
 *  iconst_1表示将int 类型1推送至栈顶（iconst_1 - iconst_5）
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.j);
    }
}

class MyParent2{

    public static final String str = "hello world";

    public static final short s = 127;

    public static final int i = 128;

    public static final int j = 5;

    static {
        System.out.println("myparent2 static block");
    }

}
