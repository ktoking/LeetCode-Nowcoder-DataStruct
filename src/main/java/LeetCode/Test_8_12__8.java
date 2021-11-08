package LeetCode;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class Test_8_12__8 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("0-1"));
    }

    /**
     * 转换数字
     * 首先定义两个标记 是否出现正负号和正负号种类
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        boolean fuhao=false; //false表示没出现过符号 true表示出现过符号
        boolean fu=false; //false表示+ true表示-
        String trim = str.trim(); //去掉前后空格
        StringBuilder sb=new StringBuilder(); //符合条件就拼上去
        for (int i = 0; i < trim.length(); i++) {
            if(!Character.isDigit(trim.charAt(i))&&fuhao){ //如果不是数字且出现过符号直接break
                break;
            }
            else {
                if(trim.charAt(i)=='-'){ //如果符号为 -
                    if(i!=0) break;      //符号如果不是出现在第一行就break
                    fuhao=true;         //设置标记位
                    fu=true;
                }else if(trim.charAt(i)=='+') {//如果符号为 -
                    if(i!=0) break;      //符号如果不是出现在第一行就break
                    fuhao=true;
                }else if(Character.isDigit(trim.charAt(i))) { //如果是数字就拼起来
                    sb.append(trim.charAt(i));
                }else break;                    //如果不是数字就退出，有可能没出现符号但是不是数字的进来
            }
        }
        if(sb.length()==0){     //如果为空就返回0
            return 0;
        }
        try{                //会有溢出数字，如果溢出转换就会报错，就到报错逻辑
            int num=Integer.parseInt(sb.toString());
            return fu==true?-1*num:num; //这次再转换正负
        }catch (Exception e){
            return fu==true?Integer.MIN_VALUE:Integer.MAX_VALUE; //注意输入: "-9128347233 输出: -2147483648
        }
    }


    public int myAtoi1(String s) {
        boolean fuhao=false;
        boolean fu=false;
        s=s.trim();
        if(s==null||s.length()==0) return 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))&&fuhao){
                break;
            }else {
                if(s.charAt(i)=='-'){
                    if(i!=0){
                      break;
                    }
                    fuhao=true;
                    fu=true;
                }else if(s.charAt(i)=='+'){
                    if(i!=0) break;;
                    fuhao=true;
                }else if(Character.isDigit(s.charAt(i))){
                    stringBuilder.append(s.charAt(i));
                }else break;
            }
        }

        if(stringBuilder.length()==0){     //如果为空就返回0
            return 0;
        }

        try{                //会有溢出数字，如果溢出转换就会报错，就到报错逻辑
            int num=Integer.parseInt(stringBuilder.toString());
            return fu==true?-1*num:num; //这次再转换正负
        }catch (Exception e){
            return fu==true?Integer.MIN_VALUE:Integer.MAX_VALUE; //注意输入: "-9128347233 输出: -2147483648
        }
    }

















}
