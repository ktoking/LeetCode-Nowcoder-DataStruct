package DataStructure.Future;

import java.util.concurrent.CompletableFuture;

public class SerialCompletableFuture {

        // 串行执行异步任务 1.首先异步获取商品编码 2.然后异步获取商品价格
        public static void main(String[] args) throws Exception {
            // 第一个任务:
            CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
                return queryCode("商品1");
            });
            // cfQuery成功后继续执行下一个任务:
            CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
                return fetchPrice(code);
            });
            // cfFetch成功后打印结果:
            cfFetch.thenAccept((result) -> {
                System.out.println("price: " + result);
            });
            // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
            Thread.sleep(2000);
        }

        static String queryCode(String name) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            return "123456";
        }

        static Double fetchPrice(String code) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            return Math.random() * 100;
        }
}
