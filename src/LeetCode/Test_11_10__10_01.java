package LeetCode;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 */
public class Test_11_10__10_01 {
    /**
     * 三指针逆序排序,倒着插入数字
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i=m-1,j=n-1,index=m+n-1;
        while (j>=0){
            if(i<0||B[j]>=A[i]){
                A[index--]=B[j--];
            }else {
                A[index--]=A[i--];
            }
        }
    }
}
