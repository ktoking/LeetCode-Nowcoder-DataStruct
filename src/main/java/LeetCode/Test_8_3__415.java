package LeetCode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_8_3__415 {
    public static void main(String[] args) {
        System.out.println(addStrings("1","1"));
    }

    /**
     * 大数相加，首先逆序补0然后相加考虑进位，最后判断最后一位是否溢出
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder sb1=new StringBuilder(num1).reverse();
        StringBuilder sb2=new StringBuilder(num2).reverse();
        int i=0;
        StringBuilder rtVal=new StringBuilder();
        int jin=0,count=0;
        int put0=sb1.length()-sb2.length();
        if(put0>=0){
            for (int j = 0; j < put0; j++) {
                sb2.append('0');
            }
        }else {
            for (int j = 0; j < -put0; j++) {
                sb1.append('0');
            }
        }
        while (i<sb1.length()&&i<sb2.length()){
            count=sb1.charAt(i)+sb2.charAt(i)-'0'-'0'+jin;
            if(count>9){
                rtVal.append(count%10);
                jin=1;
            }else {
                rtVal.append(count);
                jin=0;
            }
            i++;
        }
        if(count>9) rtVal.append(1);
        return rtVal.reverse().toString();
    }

    /**
     * 大神写的大数相加
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
