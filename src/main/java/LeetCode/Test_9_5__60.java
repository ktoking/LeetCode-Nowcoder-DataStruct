package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * *60. 第k个
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Test_9_5__60 {
    /**
     * 常规回溯会超时
     * 不超时就找到正确的下标https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-ji-ci-shu-by-deanwinchester/
     * 例如 3,5
     * 123 132  :1
     * 213 231  :2
     * 312 321  :3
     * 找到第5个,那么每组是 n-1!的阶乘个数 找到正确的个数到第三组3*2>5  3*2/2(每组的个数)=3 (从第三组开始找)再从第三组找就优化了很多
     */
    List<List<Integer>> lists=new ArrayList<>() ;
    int size;
    int dik;
    String rtval;
    public String getPermutation(int n, int k) {
        size=n;
        dik=k;
        get(new ArrayList<>());
        return rtval.substring(4);
    }
    public void  get(List<Integer> list){
        if(list.size()==size){
            if(lists.size()+1==dik){
                list.stream().forEach(e->rtval+=e );
            }else if(lists.size()+1>dik) return;
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= size; i++) {
            if(list.contains(i))continue;
            list.add(i);
            get(list);
            list.remove(list.size()-1);
        }
    }
}
