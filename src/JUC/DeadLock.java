package JUC;

import java.util.concurrent.TimeUnit;

class LockDemo implements Runnable{
    private String lockA;
    private String lockB;

    public LockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t"+"自己持有: "+lockA+"尝试获得:" +lockB);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t"+"自己持有: "+lockB+"尝试获得:" +lockA);
            }
        }
    }
}
public class DeadLock {
    public static void main(String[] args) {


        String lockA="lockA";
        String lockB="lockB";

        new Thread(new LockDemo(lockA,lockB),"aaa").start();
        new Thread(new LockDemo(lockB,lockA),"bbb").start();
    }
}
