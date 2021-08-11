package JUC.ComuserAndProducer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SoureceDemo   {
    volatile int num=1; //1A  2B  3C
    private Lock lock=new ReentrantLock();
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();
    private Condition conditionC=lock.newCondition();

    public  void prt5() throws InterruptedException {
      lock.lock();
      try {
          //判断
          while(num!=1){
               conditionA.await();
          }
          //干活

          for (int i = 0; i < 5; i++) {
              System.out.println(Thread.currentThread().getName()+"\t"+i);
          }
          //通知
          num=2;
          conditionB.signal();
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          lock.unlock();
      }
    }

    public  void prt10() throws InterruptedException {
        lock.lock();
        try {
            //判断
            while(num!=2){
                conditionB.await();
            }
            //干活

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            num=3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void prt15() throws InterruptedException {
        lock.lock();
        try {
            //判断
            while(num!=3){
                conditionC.await();
            }
            //干活

            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            num=1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class JUCDemo {

    public static void main(String[] args) {
        SoureceDemo soureceDemo=new SoureceDemo();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    soureceDemo.prt5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    soureceDemo.prt10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    soureceDemo.prt15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


    }
}
