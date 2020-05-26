package BUFFcode.NewCodeTest3;

/**
 * 1、关于私有成员变量
 * 无论父类中的成员变量是私有的、共有的、还是其它类型的，子类都会拥有父类中的这些成员变量。但是父类中的私有成员变量，无法在子类中直接访问，必须通过从父类中继承得到的protected、public方法（如getter、setter方法）来访问。
 * 2、关于静态成员变量
 * 无论父类中的成员变量是静态的、还是非静态的，子类都会拥有父类中的这些成员变量。
 * 3、关于被子类覆盖的成员变量
 *
 * 无论父类中的成员变量是否被子类覆盖，子类都会拥有父类中的这些成员变量。
 *
 * 若父类没有默认空参构造方法,则子类构造方法将在编译期间报错
 *
 * 线程的run()方法是由java虚拟机直接调用的，如果我们没有启动线程（没有调用线程的start()方法）而是在应用代码中直接调用run()方法，那么这个线程的run()方法其实运行在当前线程（即run()方法的调用方所在的线程）之中，而不是运行在其自身的线程中，从而违背了创建线程的初衷；
 * ————————————————

 */
public class Child extends Father {

    public Child(String s) {
        getanset();
        System.out.println(s);
    }
    public static void getanset(){
        System.out.println("getanset");
    }

    public String name="佳佳";
    public static void main(String[] args) {


        Father father=new Child("s");
        Child child=(Child) father;//子类引用可以指向子类对象,子类引用不能指向父类对象

        new Child("s");
        System.out.println(father.name);
        System.out.println(child.name);

        System.out.println("=================================");


        String str3 = "ABC";
        String str4 = "ABC";
        String str5 = "AB"+"C";
        String str6 = "ABCD";
        String str7 = str3+"D";
        System.out.println(str3 == str4); //true 在string池中都是一个内存地址被分配给str3,str4,str5
        System.out.println(str3 == str5); //true
        System.out.println(str6==str7);  //false

    }
}
