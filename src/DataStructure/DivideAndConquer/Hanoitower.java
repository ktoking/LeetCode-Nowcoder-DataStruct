package DataStructure.DivideAndConquer;

public class Hanoitower {

    public static void main(String[] args) {
        hmove(2,'A','B','C');
    }

    /**
     * 汉诺塔移动分治算法实现
     */

    public static void hmove(int num,char a,char b,char c){
        //如果只有一个盘子,那就直接搬到c柱子上不就完事了~
        if (num==1) System.out.println("第1个盘子从: "+a+"移动到-> "+c);
        else {
            //那要是多个盘子也很简单,首先把n个盘子分为两块,最上面的n-1为一部分,最下面一个盘子
            hmove(num-1,a,c,b); //这一步的做法是,把上面n-1的盘子通过c移动到b上
            System.out.println("第"+num+"个盘子从: "+a+"移动到-> "+c);//把最底下的一个盘子移动到c盘上
            hmove(num-1,b,a,c);
        }

    }
}
