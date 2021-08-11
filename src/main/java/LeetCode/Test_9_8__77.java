package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Test_9_8__77 {
    List<List<Integer>> lists=new ArrayList<>();
    int n;
    int k;

    /**
     * 例如：n = 6 ，k = 4。
     *
     * path.size() == 1 的时候，接下来要选择 33 个数，搜索起点最大是 44，最后一个被选的组合是 [4, 5, 6]；
     * path.size() == 2 的时候，接下来要选择 22 个数，搜索起点最大是 55，最后一个被选的组合是 [5, 6]；
     * path.size() == 3 的时候，接下来要选择 11 个数，搜索起点最大是 66，最后一个被选的组合是 [6]；
     *
     * 再如：n = 15 ，k = 4。
     * path.size() == 1 的时候，接下来要选择 33 个数，搜索起点最大是 1313，最后一个被选的是 [13, 14, 15]；
     * path.size() == 2 的时候，接下来要选择 22 个数，搜索起点最大是 1414，最后一个被选的是 [14, 15]；
     * path.size() == 3 的时候，接下来要选择 11 个数，搜索起点最大是 1515，最后一个被选的是 [15]；
     *
     * 可以归纳出：
     *
     *
     * 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
     * 其中，接下来要选择的元素个数 = k - path.size()，整理得到：
     *
     *
     * 搜索起点的上界 = n - (k - path.size()) + 1
     * 所以，我们的剪枝过程就是：把 i <= n 改成 i <= n - (k - path.size()) + 1 ：
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        huisu(new ArrayList<>(),1);
        return lists;
    }
    public void huisu(List<Integer> list,int index){
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        //i <= n - (k - list.size()) + 1  剪枝版本 效率更高
        for (int i = index; i <= n; i++) {
            list.add(i);
            huisu(list,i+1);
            list.remove(list.size()-1);
        }
    }


}
