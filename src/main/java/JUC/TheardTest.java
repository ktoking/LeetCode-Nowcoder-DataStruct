package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TheardTest {


        private Integer num=0;
        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();

        public void increment(){
            lock.lock();
            try {
                while(num!=0){
                   condition.await();
                }
                num++;
                System.out.println(Thread.currentThread().getName()+"\t"+num);
                condition.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    public void decreament(){
        lock.lock();
        try {
            while(num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

            TheardTest theardTest=new TheardTest();

            new Thread(()->{
                for (int i = 0; i < 5; i++) {
                    theardTest.increment();
                }
            },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                theardTest.decreament();
            }
        },"BB").start();

    }



}
