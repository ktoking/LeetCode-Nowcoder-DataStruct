package LeetCode;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 通过次数23,768提交次数45,182
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_7_1__718 {
    public static void main(String[] args) {
        int arr1[]={1,2,3,2,1};
        int arr2[]={3,2,1,4,7};
        System.out.println(findLength(arr1,arr2));
    }

    /***
     * 暴力法只能过42/54,这个是真暴力,时间复杂度 0(n^3),我这么笨也只能想到这个方法了
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        int count=0; //最终最大值
        for (int i = 0; i < A.length; i++) {
            int ttCount=0; //每一遍走的ttcount最大值
            for (int j = 0; j < B.length; j++) {
                if(A[i]==B[j]){  //当找到相同的数字开始比较
                    int j1=j;    //记录当当前j下标
                    int tempCount=0; //进行横向比较最大值 就是当我找到相同的值后我的i 与记录的j1一起走,相同计数器就加一,不相同就i回到起点,j1继续+1 比较,比较出最大值
                    for (int k = i;j1<B.length&&k<A.length; k++,j1++) {  //结束条件就是 超过数组长度就不行
                        if(A[k]==B[j1]){   //如果值相同,那就一起向后走,将临时计数器+1
                            tempCount++;
                        }else {             //如果值不相同,那就将重新定位到上一次i,将临时计数器清零,并判断是否需要取最大值
                            k=i;
                            if(tempCount>ttCount) ttCount=tempCount;
                            tempCount=0;
                        }
                        if(tempCount>ttCount) ttCount=tempCount;  //每一遍取最大值
                    }
                }
                if(ttCount>count) count=ttCount; //每一遍取最大值
                ttCount=0;                      //每一遍清空临时计数器
            }
        }
        return count;
    }
}
