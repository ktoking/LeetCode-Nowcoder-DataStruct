package JUC;

import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadLocal
 */
class Mysou{
    ThreadLocal threadLocal=new ThreadLocal();
    public void getIncr() throws InterruptedException {
        threadLocal.set(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName()+": "+threadLocal.get());
    }
}
public class ThreadLocalDemo {

    public static void main(String[] args) {
        Mysou mysou=new Mysou();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                try {
                    mysou.getIncr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },""+i).start();
        }
    }
}
