package BUFFcode.WrittenTest.KedaXunFei;


        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] money=new int[5];
        for (int i = 0; i < 5; i++) {
            money[i]=scanner.nextInt();
        }
        int count=scanner.nextInt();
        int rtVal=0;
        while(count>0){
            if(count>=100&&money[4]>0){
                count-=100;
                money[4]--;
                rtVal++;
            }else if(count>=50&&count<100&&money[3]>0){
                count-=50;
                money[3]--;
                rtVal++;
            }else if(count>=10&&count<50&&money[2]>0){
                count-=10;
                money[2]--;
                rtVal++;
            }else if(count>=5&&count<10&&money[1]>0){
                count-=5;
                money[1]--;
                rtVal++;
            }else if(count>=1&&count<5&&money[0]>0){
                count-=1;
                money[0]--;
                rtVal++;
            }else {
                break;
            }
        }
        if(count==0){
            System.out.println(rtVal);
        }else {
            System.out.println(-1);
        }
    }
}
