package BUFFcode.WrittenTest.JiBiTe;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next().toLowerCase();
        String aa = scanner.next().toLowerCase();
        String bb = scanner.next().toLowerCase();
        StringBuilder sb=new StringBuilder(str);
        int ia = str.indexOf(aa);
        int ib = sb.reverse().indexOf(bb);
        int aa1 = str.indexOf(bb);
        int bb2 = sb.reverse().indexOf(aa);
        if(ia==-1||ib==-1||aa1==-1||bb2==-1){
            System.out.println(-1);
        }else {
            System.out.println(Math.max(Math.abs(ia-(str.length()-ib-1)),Math.abs(aa1-(str.length()-bb2-1))));
        }
    }
}
