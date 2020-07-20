package LeetCode.swordToOffer;

public class Offer_7_20_10i {
    public static void main(String[] args) {
        System.out.println(fib(1));
    }
    public static int fib(int n) {
        if(n==0||n==1) return n;
        int f1=0 ; int f2=1;
        for (int i = 1; i <n ; i++) {
            f2=f1+f2;
            f1=f2-f1;
            f2%=1000000007;
        }
        return f2;
    }
}
