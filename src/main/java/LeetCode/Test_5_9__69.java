package LeetCode;

/*
由于 xx 平方根的整数部分 \textit{ans}ans 是满足 k^2 \leq xk
2
 ≤x 的最大 kk 值，因此我们可以对 kk 进行二分查找，从而得到答案。

二分查找的下界为 00，上界可以粗略地设定为 xx。在二分查找的每一步中，我们只需要比较中间元素 \textit{mid}mid 的平方与 xx 的大小关系，并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 \textit{ans}ans 后，也就不需要再去尝试 \textit{ans} + 1ans+1 了。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Test_5_9__69 {
    public static void main(String[] args) {
        int i = Test_5_9__69.mySqrt(24);
        System.out.println(i);
    }
    public static int mySqrt(int x) {
      int left=0;
      int right=x;
      if(x==0||x==1){
          return 0;
      }
      while (left<=right){
          long mid=(left+right)/2;
          if(mid*mid==x){
              return (int)mid;
          } else if(mid*mid>x){
              right=(int)mid-1;
          }else if(mid*mid<x){
              left=(int)mid+1;
          }
      }
      return right;
    }
}
