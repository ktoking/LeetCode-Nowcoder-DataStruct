package BUFFcode.NewCodeTest3;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d
 * 来源：牛客网
 *
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 *
 * 输入描述:
 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 *
 *
 * 输出描述:
 * 在一行内输出str中里连续最长的数字串。
 * 示例1
 * 输入
 * abcd12345ed125ss123456789
 * 输出
 * 123456789
 */
public class IongestContinuousString {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String st = scanner.nextLine();
            int max=0,count=0,end=0;
            for (int i = 0; i < st.length(); i++) {
                if(st.charAt(i)>='0'&&st.charAt(i)<='9'){
                    count++;
                    if(count>max){
                        max=count;
                        end=i;  //这里是记录最后一个数字的下标,方便输出
                    }
                }else {
                    count=0;  //当不是数字就把计数器清零
                }
            }


            System.out.println(st.substring(end-max+1,end+1)); //输出直接用尾标减去最大值+1,substring方法[index,index)前闭后开区间
        }
    }
}
