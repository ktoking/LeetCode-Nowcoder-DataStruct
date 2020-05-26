package BUFFcode.WrittenTest;

import java.util.Scanner;

/**
 * 单科成绩优秀奖
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 某学校的期末考试共有n个学生参加，考试科目共有m科。学校将会给一部分学生颁发单科成绩优秀奖，获奖学生需要满足的条件是某一科的成绩是所有学生中最高的或是最高的之一。
 *
 * 请问学校应该给多少名学生颁发单科成绩优秀奖。
 *
 * 输入
 * 输入第一行包含两个正整数n和m，分别代表学生人数和考试科目数量。(n,m<=500)
 *
 * 接下来有n行，每行有m个正整数，每个正整数在1-100之间，中间用空格隔开，表示每个学生的m科考试成绩。
 *
 * 输出
 * 输出仅包含一个整数，表示获得单科成绩优秀奖的人数
 *
 *
 * 样例输入
 * 5 5
 * 28 35 38 10 19
 * 4 76 72 38 86
 * 96 80 81 17 10
 * 70 64 86 85 10
 * 1 93 19 34 41
 * 样例输出
 * 4
 *
 * 提示
 * 注意，输出结果为人数，并非人次。同一个学生如有多科最优，获奖人数也只会计为1人，即输出结果始终小于等于n
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */
public class MeituanTest {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[][] arr=new int[m][n];
            int count=0;
            for (int i = 0; i <m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j]=scanner.nextInt();
                }
            }

           int[] temp=new int[n];
            for (int i = 0; i < temp.length; i++) {
                temp[i]=0;
            }

            for (int i = 0; i < n; i++) {
                int max_i=0;
                int max=arr[i][0];
                for (int j = 0; j < m; j++) {
                    if (arr[j][i]>max){
                        max_i=i;
                    }
                }
                temp[max_i]++;
            }

            for (int i : temp) {
                if(i!=0){
                    count++;
                }
            }
            System.out.println(count);


        }

    }

}
