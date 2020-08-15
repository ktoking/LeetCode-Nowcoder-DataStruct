package BUFFcode.WrittenTest.BiLiBiLi;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(GetCoinCount(200));
    }
    public static int GetCoinCount (int N) {
        // write code here
        int num=1024-N;
        if(num==0) return 0;
        int count=0,end=3;
        int arr[]={1,4,16,64};
        while (num>0&&end>=0){
            while (num-arr[end]<0&&end>=0){
                end--;
            }
            if(end==0&&num-arr[end]<0) return count;
            num-=arr[end];
            count++;
        }
        return count;
    }
}
