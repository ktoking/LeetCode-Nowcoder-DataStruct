package BUFFcode.NewCodeTest7;

import java.util.Scanner;

/**链接：https://www.nowcoder.com/questionTerminal/1183548cd48446b38da501e58d5944eb
 来源：牛客网

 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 小易想知道最多可以放多少块蛋糕在网格盒子里。

 输入描述:
 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)


 输出描述:
 输出一个最多可以放的蛋糕数
 示例1
 输入
 3 2
 输出
 4
 *
 *
 * /不需要找规律，直接递推
 * //定义一个数组a[1000][1000],初始值都为0，从a[0][0]开始,将a[0][2]和a[2][0]置为-1,遍历数组，不是-1的地方可以放蛋糕
 */
public class CakeTest {




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){

            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int [][]arr=new int[1000][1000];
            int count=0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(arr[i][j]==0){
                        count++;
                        if(i+2<H) arr[i+2][j]=-1;
                        if(j+2<W) arr[i][j+2]=-1;
                    }
                }
            }

            System.out.println(count);
        }
    }




}
