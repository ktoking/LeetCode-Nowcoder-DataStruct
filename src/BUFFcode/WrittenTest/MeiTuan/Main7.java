package src.BUFFcode.WrittenTest.XiaPi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 时间限制： 1000MS
 * 内存限制： 524288KB
 * 题目描述：
 * 小美想要为小团摆一行积木，每个积木上都有一个0-9的数字。现在已经摆好了 n 块积木，小美可以把其中一块积木替换成任意一块积木（也可以不替换），使得积木看起来更符合小美的审美。请你帮小美看看，替换后最好看的积木是什么样的。
 *
 * 摆好后的积木上面的数字，从左到右会形成一个数字串（由数字组成的字符串）。小美会根据这个数字串来评判积木的好看程度，小美有两条审美标准：
 *
 * ①回文数字串相比于非回文数字串更符合小美的审美。例如：12321、2332是回文数字串，而12212、2121不是回文数字串。
 *
 * ②数字串形成的数字更小更好看。例如：1312比1313更好看，0102比1102更好看。
 *
 * 小美会按照她的审美标准来判断两个数字串哪个更好看，即先按照审美标准①判断，若无法判断再按审美标准②判断。
 *
 *
 *
 * 输入描述
 * 第一行一个数 T，表示一共有 T 组测试数据。(1 ≤ T ≤ 100)。
 *
 * 接下来 T 组数据，每组数据两行，
 *
 * 第一行一个数 n，表示有 n 块积木。(1 ≤ n ≤ 20000)。
 *
 * 第二行 n 个数字，第 i 块积木上的数字是 si。(si是0-9的数字)。
 *
 * 输出描述
 * 每组数据输出一行，表示最终摆好的积木形成的数字串。
 *
 *
 * 样例输入
 * 2
 * 5
 * 00011
 * 5
 * 11210
 * 样例输出
 * 00001
 * 01210
 *
 * 提示
 * 第一组数据：
 * 替换一块积木，无法使数字串变成回文数字串，因此只能数字串形成的数字最小。
 * 第二组数据：
 * 可以把第一块积木1换成0，也可以把第五块积木0换成1，从而使得积木是回文积木。又想要积木字典序最小，所以把第一块积木1替换成0。
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = Integer.parseInt(in.nextLine());
        List<String> result=new ArrayList<>();
        while (line-->0){
            String nextInt = in.nextLine();
            String s = in.nextLine();
            String min=s;
            String mmin=s;
            boolean isGet=false;
            for (int i=0;i<s.length()/2;i++) {
                if(!isHui(s)){
                    if(s.charAt(i)<s.charAt(s.length()-i-1)){
                        char[] chars = s.toCharArray();
                        chars[s.length()-i-1]=s.charAt(i);
                        String s1 = new String(chars);
                        if(isHui(s1)){
                            if(Integer.parseInt(s1)<Integer.parseInt(min)){
                                min=s1;
                                isGet=true;
                            }
                            break;
                        }else {
                            if(Integer.parseInt(s1)<Integer.parseInt(mmin)){
                                mmin=s1;
                            }
                        }
                    }else if(s.charAt(i)>s.charAt(s.length()-i-1)){
                        char[] chars = s.toCharArray();
                        chars[i]= chars[s.length()-i-1];
                        String s1 = new String(chars);
                        if(isHui(s1)){
                            if(Integer.parseInt(s1)<Integer.parseInt(min)){
                                min=s1;
                                isGet=true;
                            }
                            break;
                        }else {
                            if(Integer.parseInt(s1)<Integer.parseInt(mmin)){
                                mmin=s1;
                            }
                        }
                    }
                }else {
                    if(Integer.parseInt(s)<Integer.parseInt(min)){
                        min=s;
                    }
                }
            }
            result.add(isGet==true?min:mmin);
        }
        for (String s : result) {
            System.out.println(s);
        }
    }


    public static boolean isHui(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
        }
        return true;
    }
}
