package DataStructure.Future;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;

@Data
@AllArgsConstructor
public class RealData implements Callable<String> {

    private String result;

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(result);
        //模拟耗时的构造数据过程
        Thread.sleep(5000);
        return sb.toString();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new RealData("Hello"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(futureTask);

        System.out.println("请求完毕！");

        try {
            Thread.sleep(2000);
            System.out.println("这里经过了一个2秒的操作！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("真实数据：" + futureTask.get());
        executorService.shutdown();
    }
}
