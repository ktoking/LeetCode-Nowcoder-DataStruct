package JUC.ComuserAndProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CandP{

    private int num=0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();


    public void increament() throws InterruptedException {
        lock.lock();
        try{

            while(num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+" 线程生产了,还剩下: "+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void decreament() throws InterruptedException {
        lock.lock();
        try{
            while(num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+" 线程消费了,还剩下: "+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

public class ComsumerAndProducer {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue blockingQueue=new SynchronousQueue();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+" put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+" put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {

                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"\t"+ blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"\t"+ blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"\t"+ blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

//        CandP candP=new CandP();
//
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                try {
//                    candP.increament();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"A").start();
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                try {
//                    candP.decreament();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"B").start();
    }
}
