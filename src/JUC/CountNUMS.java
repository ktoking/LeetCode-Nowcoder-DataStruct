package JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子整形根CountDownLatch
 */
public class CountNUMS {
    static AtomicInteger nums=new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(()->{
            while (nums.getAndDecrement()>3){
                System.out.println(Thread.currentThread().getName()+": 还剩下"+nums.get());
            };
            countDownLatch.countDown();
        },"Thread1").start();
        new Thread(()->{
            while (nums.getAndDecrement()>3){
                System.out.println(Thread.currentThread().getName()+": 还剩下"+nums.get());
            };
            countDownLatch.countDown();
        },"Thread2").start();
        new Thread(()->{
            while (nums.getAndDecrement()>3){
                System.out.println(Thread.currentThread().getName()+": 还剩下"+nums.get());
            };
            countDownLatch.countDown();
        },"Thread3").start();

        countDownLatch.await();
        System.out.println("都扣减完了剩余: "+nums.get());
    }
}
