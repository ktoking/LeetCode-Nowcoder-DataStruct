package BUFFcode.NewCodeTest1;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9d1559511b3849deaa71b576fa7009dc
 * 来源：牛客网
 *
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。你接受花花的请求，帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
 * 例如：
 * A = “aba”，B = “b”。这里有4种把B插入A的办法：
 * * 在A的第一个字母之前: "baba" 不是回文
 * * 在第一个字母‘a’之后: "abba" 是回文
 * * 在字母‘b’之后: "abba" 是回文
 * * 在第二个字母'a'之后 "abab" 不是回文
 * 所以满足条件的答案为2
 *
 *
 * 解题思路:首先判断回文数,然后将s2从s1的每一个位置插入继续判断
 */

public class HuiwenNumber {

    public static boolean is_huiwen(String s){
        char [] arrays=s.toCharArray();
        int start=0;
        int end=arrays.length-1;
        while(start<end){
            if(arrays[start]!=arrays[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       while (scanner.hasNext()){
           String s1=scanner.nextLine();
           String s2=scanner.nextLine();
           int count=0;
           for (int i = 0; i <= s1.length(); i++) {  //将s2插入s1是遍历s1的长度,并且要考虑s1末尾也要插入
               StringBuilder stringBuilder=new StringBuilder(s1);
               stringBuilder.insert(i,s2);
               if(is_huiwen(stringBuilder.toString())){
                   count++;
               }
           }
           System.out.println(count);
       }
    }
}

