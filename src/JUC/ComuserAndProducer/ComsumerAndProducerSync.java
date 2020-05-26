package JUC.ComuserAndProducer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CandP1 {

    private int num = 0;

    public synchronized void increament() throws InterruptedException {

        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + " 线程生产了,还剩下: " + num);
        this.notifyAll();


    }

    public synchronized void decreament() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + " 线程消费了,还剩下: " + num);
        this.notifyAll();
    }
}
public class ComsumerAndProducerSync {


    public static void main(String[] args) {
        CandP1 candP1=new CandP1();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    candP1.increament();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    candP1.decreament();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
