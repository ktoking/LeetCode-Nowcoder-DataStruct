package BUFFcode.WrittenTest.LaoHu;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        int arr[][]={{0,1},{1,2},{1,3}};
        System.out.println(maxLevel(2,1,arr));
    }

    /**
     * int，返回做完x个任务后能达到的最高等级
     * @param x int整型 需要完成的任务数量
     * @param level int整型 初始等级
     * @param tasks int整型二维数组 表示可供选择的任务，tasks[i][0]表示第i个任务所需的最低等级，task[i][1]表示第i个任务完成后能提升的等级
     * @return int整型
     */
    public static int maxLevel (int x, int level, int[][] tasks) {
        Map<Integer,Integer> map=new TreeMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if(map.containsKey(tasks[i][0])){
                if(map.get(tasks[i][0])<tasks[i][1]){
                    map.put(tasks[i][0],tasks[i][1]);
                }
            }else {
                map.put(tasks[i][0],tasks[i][1]);
            }
        }
        List<Integer> list=new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(integer);
        }
        Collections.sort(list);
        for (int i = 0; i < x; i++) {
            for (int j = list.size()-1; j >=0 ; j--) {
                if(list.get(j)<=level){
                    level+=map.get(list.get(j));
                    break;
                } else if(j==list.size()){
                    level+=map.get(list.get(list.size()-1));
                }
            }
        }
        return level;
    }
}
