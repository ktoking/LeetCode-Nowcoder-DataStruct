package JUC.ComuserAndProducer;

import java.sql.Time;
import java.util.Collections;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean Flag=true; //默认开启进行生产消费
    private AtomicInteger atomicInteger=new AtomicInteger(); //原子整形
    BlockingQueue blockingQueue=null;//我们传接口,不传具体实现类,具体实现类由我们自己决定,口子放的足够宽

    public MyResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());  //检查进来的是什么对象
    }

    public void MyProducer1() throws InterruptedException {
        String data=null;
        while(Flag){
            data = atomicInteger.getAndIncrement()+"";
            boolean offer = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(offer){
                System.out.println(Thread.currentThread().getName()+"\t"+data+"插入成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t"+data+"插入失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"生产停止");
    }

    public void MyConsumer1() throws InterruptedException {
        String data=null;
        while(Flag){
           data = (String) blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(data==null||data.equalsIgnoreCase("")){
                Flag=false;
                System.out.println(Thread.currentThread().getName()+"\t"+data+" 2s没取到消费失败");
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t"+data+"消费成功");
        }
    }

    public void StopAll(){
        Flag=false;
    }

}
public class ComsumerAndProducerBlockingQueue {


    private static int a=0;

    public static void main(String[] args) throws InterruptedException {
        MyResource myResource=new MyResource(new SynchronousQueue());
        
        ExecutorService executorService=Executors.newCachedThreadPool();
        Thread thread = new Thread(() -> {
            try {
                myResource.MyProducer1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者A1");
        executorService.execute(thread);


        new Thread(()->{
            try {
                myResource.MyConsumer1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者B1").start();


        TimeUnit.SECONDS.sleep(6);

        myResource.StopAll();
        executorService.shutdown();

    }
}
