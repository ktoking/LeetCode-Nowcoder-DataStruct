package BUFFcode.WrittenTest.YueWenTest;

public class Erjinzhi {
    public static void main(String[] args) {
        int i = Erjinzhi.trueBit(5);
        System.out.println(i);
    }

    public static int trueBit(int num){
        int is1=0;
        int is0=0;

        while(true){
            if(num==0) break;
            if(num%2==0){
                is0++;
            }else is1++;
            num=num/2;
         }
        return is1;
    }
}
