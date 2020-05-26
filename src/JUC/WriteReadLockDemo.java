package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没 有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一-个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * 小总结:
 *
 *      读-读能共存
 *      读-写不能共存
 *      写写不能共存
 * /
 */

class Mysource{

    private volatile Map<String,Object> map=new HashMap();
    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();



    public void get(String key){
      readWriteLock.readLock().lock();
      try {
          System.out.println(Thread.currentThread().getName()+"开始读");
          try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
          System.out.println(Thread.currentThread().getName()+"读完成"+map.get(key));
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          readWriteLock.readLock().unlock();
      }
    }

    public void set(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始写"+key);
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }


    }
}
public class WriteReadLockDemo {


    public static void main(String[] args) {

        Mysource mysource=new Mysource();
        for (int i = 0; i < 10; i++) {
            final int temp=i;
            new Thread(()->{
                mysource.set(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            final int temp=i;
            new Thread(()->{
                mysource.get(temp+"");
            },String.valueOf(i)).start();
        }

    }
}
