package BUFFcode.NewCodeTest4;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/61cfbb2e62104bc8aa3da5d44d38a6ef
 * 来源：牛客网
 *
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 *
 * 输入描述:
 * 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
 *
 *
 * 输出描述:
 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
 * 示例1
 * 输入
 * 20
 * 输出
 * 3
 *
 *
 *
 * 链接：https://www.nowcoder.com/questionTerminal/61cfbb2e62104bc8aa3da5d44d38a6ef
 * 来源：牛客网
 *
 * 对数字特征进行分析。
 *
 * 首先，6和8都是偶数。因此，能凑出的个数也一定是偶数。程序中若苹果总数是奇数，可以直接返回-1。
 *
 * 再次，偶数个苹果数对8取模，其结果只可能为0,2,4,6。若余数为6或者0，则可以直接用6包装情况处理，不需要回溯购买8包装的情况。若余数为4，只需回溯1次即可，因为8+4=12, 12%6 = 0。若余数为2，只需回溯2次即可，因为8+8+2=18, 18%6 = 0。
 *
 * 综上，可以采用如下思路进行处理。（由于数字6和8的特征，本方法只适用于本题）
 *
 * 情况1：若num不是偶数，则直接返回-1
 * 情况2：若num%8 = 0，则返回num/8
 * 情况3：若num%8 != 0，则只需回溯1次或者2次8包装购买个数，就可以求解。回溯1次，其结果为n/8-1+2 = n/8+1；回溯1次，其结果为n/8-2+3 = n/8+1。因此，可以情况3下，可以返回n/8+1
 */
public class BuyApples {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int appleNum = scanner.nextInt();

            if(appleNum%2!=0||appleNum<6||appleNum==10){
                System.out.println(-1);
            }
            else if(appleNum%8==0){
                System.out.println(appleNum/8);
            }
            else {
                System.out.println(1+appleNum/8);
            }

        }
    }
}
