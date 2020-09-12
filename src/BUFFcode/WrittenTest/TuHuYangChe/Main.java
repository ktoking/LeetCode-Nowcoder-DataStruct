package BUFFcode.WrittenTest.TuHuYangChe;

public class Main {
    public static void main(String[] args) {
        System.out.println(combination(2,3));
    }
    public static int combination (int r, int n) {
        // write code here
        if(r==n) return 1;
        if(r==0) return 1;
        int rtval=1;
        if(r<(n/2)){
            r=n-r;
        }
        for (int i = n; i >r ; i--) {
            rtval*=i;
        }
        rtval/=jiecheng(n-r);
        return rtval;
    }

    public static int jiecheng(int num){
        int sum=1;
        for (int i = num; i >1 ; i--) {
            sum*=i;
        }
        return sum;
    }

}
