package BUFFcode.WrittenTest.DaJiang;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 自从零食间开始免费供应上好的咖啡豆，小杰每天早上到公司后都会来到零食间，按下咖啡机的按钮，等待着杯里弥漫开来的香气把自己淹没，纷乱的思绪也渐渐在水雾中模糊。"小杰，你还有N个bug没修，别摸鱼了，快来解bug！"，一个不合时宜的声音往往会在此时响起，小杰的脑海中瞬间闪过了无数个文件，无数行代码随着咖啡的香气不断滚动。
 *
 * "我是不可能写bug的，这辈子都不可能写bug的...", 小杰一边念叨着，一边开始在脑海里盘算起来。
 *
 * 假设小杰头上还有N个bug没修，他每喝一杯咖啡（喝咖啡的时间忽略不计），就能让自己一小时内的debug效率提升到原来的A倍，一小时内重复喝没用，最多只能喝X杯，喝太多了晚上会睡不着，并且为了保证可持续发展，每天最多只能专注工作8个小时，而在没喝咖啡的状态下解决每个bug所需要的时间为 t1,t2...tN 分钟。
 *
 * 现在是早上8点，小杰马上要开始一天的工作了，他计划按从1-N的顺序修复他头上这些Bug，你能帮他计算出他今天能在8小时内解完所有bug吗？如果能，最少需要多长时间？
 *
 *
 *
 * 输入描述
 * 先按顺序输入三个正整数 N A, X，其中N表示bug的总数，A表示喝一杯咖啡在一小时内debug效率提升的倍数，X表示最多可以喝的咖啡数目。（1 <= N <= 100, 1 <= A <= 8, 1 <= X <= 8）
 *
 * 再按顺序输入N个正整数，第i个正整数ti表示解决第i个bug需要的分钟数，第N个正整数tN表示解决第N个bug需要的分钟数，（1<=i<=N, 1 <= ti <= 1000）
 *
 * 输出描述
 *
 * 输出一个数字T，如果不能解完所有bug，则输出0，如果可以，则输出最少需要的分钟数（T为正整数，如不满一分钟则按一分钟计算，一旦超过8小时则认为不能解完，所以T最大为480）
 * 样例输入
 * 8
 * 2
 * 8
 * 60
 * 60
 * 60
 * 60
 * 60
 * 60
 * 60
 * 60
 * 样例输出
 * 240
 *
 * 提示
 * 输入样例二:
 * 4
 * 3
 * 3
 * 333
 * 77
 * 100
 * 13
 * 输出样例二:
 * 175
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt(); //BUG总数
        int A = sc.nextInt();  //提升倍数
        int X = sc.nextInt();  //喝的咖啡数
        int arr[]=new int[N];
        int count=0;
        int sum=0;
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        int time=X*60;
        int i=0;
        while (time-arr[i]/A>0&&i<N){
            time-=arr[i]/A;
            i++;
        }
        if(time-arr[i]/A<0){
            arr[i]-=A*time;
            i++;
        }
        for ( ; i <N ; i++) {
            time-=arr[i];
        }
        if(time<0){
            count+=X*60+(-1*time);
        }else {
            count+=60*X-time;
        }
        if(count>480)
        System.out.println(0);
        else System.out.println(count);
    }
}
