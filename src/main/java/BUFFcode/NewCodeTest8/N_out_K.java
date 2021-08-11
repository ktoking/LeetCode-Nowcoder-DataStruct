package BUFFcode.NewCodeTest8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/cc727473d1e248ccb674eb31bd8683dc
 * 来源：牛客网
 *
 * 找出n个数里最小的k个
 *
 * 输入描述:
 * 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
 * 不超过100。
 *
 *
 * 输出描述:
 * 输出n个整数里最小的k个数。升序输出
 * 示例1
 * 输入
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 * 输出
 * -11 -10 3 6 7
 *
 * 暴力输出法
 */
public class N_out_K {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            List<Integer> list=new ArrayList();
//            while (scanner.hasNext()) {
//                int nextInt = scanner.nextInt();
//                list.add(nextInt);
//            }
            String st = scanner.nextLine();
            String[] s = st.split(" ");
            for (int i = 0; i < s.length; i++) {
                list.add(Integer.parseInt(s[i]));
            }
            int n = list.get(list.size()-1);
            list.remove(list.size()-1);

            Collections.sort(list);
            for (int i = 0; i < n; i++) {
                System.out.printf(i==n-1?String.valueOf(list.get(i)):list.get(i)+" ");
            }
        }
    }
}
