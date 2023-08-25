package LeetCode.D2023;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 * 提示：
 *
 * -107 <= num <= 107
 */
public class Test_8_25_2023__504 {

    public static void main(String[] args) {
        convertToBase7(-7);
    }

    public static String convertToBase7(int num) {
        if(num==0) return "0";
        boolean flag=false;
        if(num<0) {
            num*=-1;
            flag=true;
        }
        StringBuilder sb=new StringBuilder();
        while (num!=0){
            sb.append(num%7);
            num/=7;
        }
        return flag ?"-"+sb.reverse().toString():sb.reverse().toString();
    }
}
