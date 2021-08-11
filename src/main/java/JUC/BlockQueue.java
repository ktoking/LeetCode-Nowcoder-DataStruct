package JUC;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockQueue  {
    private volatile boolean FLAG=true;
    private AtomicInteger atomicInteger=new AtomicInteger();
    private BlockingQueue<String> blockQueue=null;



    public BlockQueue(BlockingQueue<String> blockQueue) {
        this.blockQueue = blockQueue;
        System.out.println(blockQueue.getClass().getName());
    }


    public void  myProd() throws InterruptedException {
        String data=null;
        boolean rtvalue;
        while(FLAG){
            data=atomicInteger.incrementAndGet()+"";
            rtvalue=blockQueue.offer(data,2L, TimeUnit.SECONDS);
            if(rtvalue){
                System.out.println(Thread.currentThread().getName()+"生产成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"生产失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("生产结束");
    }

    public void consumer() throws InterruptedException {
        String rtvalue=null;
        while(FLAG){
            rtvalue   = (String) blockQueue.poll(2L, TimeUnit.SECONDS);
            if(rtvalue==null||rtvalue.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"超过2s没有取到东西");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"消费成功");
        }
    }

    public void stop (){
        this.FLAG=false;
    }

    public static void main(String[] args) {
        BlockQueue blockQueue=new BlockQueue(new ArrayBlockingQueue<>(3));

        new Thread(()->{
            try {
                blockQueue.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            try {
                blockQueue.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        new Thread(()->{
            try {
                blockQueue.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod1").start();

        new Thread(()->{
            try {
                blockQueue.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer1").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        blockQueue.stop();

    }

}
