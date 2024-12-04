package LeetCode;

import java.io.InputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class Test_9_7__347 {
    public static void main(String[] args) {
        int[] ints = topKFrequent1(new int[]{4,1,-1,2,-1,2,3 },2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 构建优先级队列,lambda大神写的,太膜拜了,全局stream流
     * 首先,map记录key及出现次数
     * 优先级队列负责排队,插入的时候,将次数出现多的排在前面
     * 然后遍历map,维持k个优先级队列,不满足k的时候就插入,当元素大于等于k个,判断出现次数大于不大于队列顶部最小次数,大于就弹出队列头最小出现次数,然后再将当前key加进去
     * 完成topk
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= IntStream.of(nums).boxed().collect(Collectors.toMap(e->e,e->1, Integer::sum));
        Queue<Integer> queue=new PriorityQueue<>(Comparator.comparingInt(map::get));
        map.forEach((key,val)->{
            if(queue.size()<k){
                queue.offer(key);
            }else {
                if(map.get(queue.peek())<val){
                    queue.poll();
                    queue.offer(key);
                }
            }
        });
        int[] arr=new int[k];
        int i=0;
        for (Integer integer : queue) {
            arr[i++]=integer;
        }
        return arr;
    }


    /**
     * 再写一遍前K高频
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> collect = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, (n1, n2) -> {
            return n1 + n2;
        }));
        Queue<Map.Entry> queue=new PriorityQueue<>(k,((o1, o2) -> {return (int)o1.getValue()-(int)o2.getValue();}));
        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            if(queue.size()==k){
               if((int)queue.peek().getValue()<entry.getValue()){
                   queue.poll();
                   queue.offer(entry);
               }
            }else {
                queue.offer(entry);
            }
        }
        int[] arr=new int[k];
        for (int i = 0; i < k; i++) {
            arr[i]=(int)queue.poll().getKey();
        }
        return arr;
    }
}
