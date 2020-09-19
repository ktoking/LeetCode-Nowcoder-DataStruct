package BUFFcode.WrittenTest.MiHaYoo;

import java.util.Random;
import java.util.Scanner;

public class Main2 {
    /**     双指针解法
     *  . 匹配单个字符
     *  * 匹配0-多个前面字符
     *  + 匹配1-多个前面字符
     *  当不相同时,如果为.继续 如果为*继续匹配到下一个不为*,上面指针也走,若相同个*匹配继续
     *  如果匹配到*
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String ss = scanner.nextLine();
        int i=0,j=0;
        while (i<s.length()&&j<ss.length()){
            if(Character.isLetter(ss.charAt(j))){char c=ss.charAt(j);}
            if(s.charAt(i)==ss.charAt(j)){
                i++;j++;
            }else {
                if(ss.charAt(j)=='.'){
                    i++;j++;
                }else if(ss.charAt(j)=='*'){
                    while (i<s.length()&&j<ss.length()){
                        if(s.charAt(i)==s.charAt(i-1)){
                            i++;
                        }else {
                            j++;
                            break;
                        }
                    }
                }else if(ss.charAt(j)=='+'){
                    while (i<s.length()&&j<ss.length()){
                        if(s.charAt(i)==s.charAt(i-1)){
                            i++;
                        }else {
                            j++;
                            break;
                        }
                    }
                }
            }
        }
    }
}
