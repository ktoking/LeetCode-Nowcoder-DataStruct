package LeetCode;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_6_11__739 {
    /**
     * 暴力解法
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] arr=new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int count=0;
            for (int j = i; j < T.length; j++) {
                if(T[i]>=T[j]) count++;
                else{
                    arr[i]=count;
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 利用单调栈来进行排序
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T) {
        int[] arr=new int[T.length];
        Stack<Integer> stack=new Stack<>(); //创建单调栈,栈中存着数组元素的下标
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){ // 当栈中不为空,且从数组当前元素取出的温度值大于栈顶存着的下标的温度值,就将当前下标减去栈中存着的下标,且出栈,跟下一个栈顶元素比较,直到比当前栈顶元素值小或栈为空
                int preIndex=stack.pop(); //取出当前栈顶元素(数组下标)
                arr[preIndex]=i-preIndex; //将相减的下标值存入数组中
            }
            stack.push(i); //将下标压入栈
        }
        return arr;
    }




}
