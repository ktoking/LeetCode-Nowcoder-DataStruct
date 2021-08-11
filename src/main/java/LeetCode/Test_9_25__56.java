package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_9_25__56 {


    /**
     * 合并区间,贪心算法,首先按照区间开头排序,然后判断第二个区间开头是否大于第一个区间的尾巴,小于就加入结果集,大于就合并结果集(可能出现 1,5  6,3  那就要取最大的 )
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0) return new int[][]{};
        Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = list.get(list.size() - 1);
            int[] cur=intervals[i];
            if(cur[0]>peek[1]){
                list.add(cur);
            }else {
                peek[1]=Math.max(peek[1],cur[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
