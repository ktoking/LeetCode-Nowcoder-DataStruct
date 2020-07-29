package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Mysour{
    static int num=0; //volatile不保证原子性，只保证可见性与有序性，只能保证当前线程获得值是最新的,但不能保证写回主内存的值最新
    public void incr(){
        num+=1; //由于操作不是原子性的，所以依然会线程不安全
    }

    //锁当前方法,锁的是当前对象
    public  synchronized void incrSync(){
        num+=1;
    }

    //Lock锁
    Lock lock=new ReentrantLock();
    public void incrLock(){
        lock.lock();//加锁
        try {
            num+=1;
        }finally {
            lock.unlock();
        }
    }
}
public class StaticVar {
    public static void main(String[] args) throws InterruptedException {
        Mysour m=new Mysour();
        for (int i = 0; i < 1000; i++) { //1000个线程自增,绝大部分都到不了1000
            new Thread(()->{
               m.incrSync();
            },""+i).start();
        }

        TimeUnit.SECONDS.sleep(3);

        System.out.println(m.num);
    }

}
