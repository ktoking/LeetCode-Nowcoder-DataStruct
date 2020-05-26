package JUC;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {
//        ThreadPoolExecutor底层

//        ExecutorService threadPool= Executors.newFixedThreadPool(5); //1池处理5个线程
//        ExecutorService threadPool= Executors.newSingleThreadExecutor(); //1池处理1个线程
//        ExecutorService threadPool= Executors.newCachedThreadPool(); //可扩张的线程池
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        System.out.println(Runtime.getRuntime());
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
