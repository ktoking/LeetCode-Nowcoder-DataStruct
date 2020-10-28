package LeetCode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 */
public class Test_10_28__1207 {

    /**
     * 普通算法,先用lamda统计出次数,再用set判断去重
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = IntStream.of(arr).boxed().collect(Collectors.toMap(e -> e, e -> 1, (n1, n2) -> {
            return n1 + n2;
        }));
        Set<Integer> set=new HashSet<>();
        for (Integer value : map.values()) {
            if(set.contains(value)) return false;
            else set.add(value);
        }
        return true;
    }

    /**
     * 直接加进去判断size大小也行
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> map = IntStream.of(arr).boxed().collect(Collectors.toMap(e -> e, e -> 1, (n1, n2) -> {
                return n1 + n2;
    }));
        return map.size()==new HashSet<>(map.values()).size();
    }
}
