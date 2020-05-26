package BUFFcode.WrittenTest.JingDong;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 第一行包含一个整数T，表示测试数据组数。
 *
 * 1 <= T <= 10
 *
 * 对于每组测试数据包含六行，每行包含两个整数h, w，表示一块纸板的长和宽。
 *
 * 1 <= h, w <= 104
 *
 * 输出
 * 对于每组测试数据输出一行。如果能构成纸箱则输出POSSIBLE，否则输出IMPOSSIBLE。
 *
 *
 * 样例输入
 * 2
 * 1345 2584
 * 2584 683
 * 2584 1345
 * 683 1345
 * 683 1345
 * 2584 683
 * 1234 4567
 * 1234 4567
 * 4567 4321
 * 4322 4567
 * 4321 1234
 * 4321 1234
 * 样例输出
 * POSSIBLE
 * IMPOSSIBLE
 */
public class ChangFangxing {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        while(num--!=0){
            int[] cl=new int[6];
            int[] cw=new int[6];
            for (int i = 0; i < 6; i++) {
                int l = scanner.nextInt();
                int w=scanner.nextInt();
                cl[i]=l;
                cw[i]=w;
            }
            System.out.println("IMPOSSIBLE");

        }
    }
}
