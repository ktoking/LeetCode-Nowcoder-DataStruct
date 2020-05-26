package JUC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

class Mysource1{
    public void get(){
        System.out.println(Thread.currentThread().getName()+"进来了");
    }
}
public class CasTest {

//     AtomicInteger atomicInteger=new AtomicInteger(0);

//    public void lock(){
//
//    }

    public static void main(String[] args) throws InterruptedException {

        Mysource1 mysource1=new Mysource1();

        Thread thread = new Thread(() -> {
            mysource1.get();
        }, "aaa");
        Thread thread1 = new Thread(() -> {
            mysource1.get();
        }, "bbb");

        thread.start();
        thread.join();
        thread1.start();
        System.out.println("main线程结束");



    }

}
