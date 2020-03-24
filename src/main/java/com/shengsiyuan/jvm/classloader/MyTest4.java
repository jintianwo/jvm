package com.shengsiyuan.jvm.classloader;

/**
 * 编译期常量与运行期常量的区别及数组创建本质分析
 *
 * 对于数据实例来说，其类型是由jvm在运行期间动态生成的，表示为 [Lcom.shengsiyuan.jvm.classloader.MyParent4
 *这种形式，动态生成的类型，其父类就是object
 *
 * 对于数组来说。javaDoc经常将构成数组的元素为component,实际上就是将数组降低一个维度后的类型。
 *
 * 助记符
 *  anewarray：表示创建一个引用类型的（如类，接口，数组）数组，并将其引用值压入栈顶
 *  newarray：表示创建一个指定的原始类型的（如int,float,char等）数组，并将其引用值压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        MyParent4 myParent4 = new MyParent4(); //会初始化MyParent4类
        //System.out.println(myParent4.getClass());class com.shengsiyuan.jvm.classloader.MyParent4
        MyParent4[] myParent4s = new MyParent4[1];//运行不会初始化
        System.out.println(myParent4s.getClass());//class [Lcom.shengsiyuan.jvm.classloader.MyParent4（数据类型）;这个类型是jvm 在运行期创建出来的

        MyParent4[][] myParent4ss = new MyParent4[1][1];//运行不会初始化
        System.out.println(myParent4ss.getClass()); //class [[Lcom.shengsiyuan.jvm.classloader.MyParent4;

        System.out.println("=======");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
