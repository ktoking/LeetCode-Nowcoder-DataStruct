package BUFFcode.WrittenTest;

public class ZhongYouTest {
    public static void main(String[] args) {
        String s="aa";
        String b=s+"";
        System.out.println(s==b);

        int arr[]={1,4,2,4,5,4,7,2};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i] );
        }
    }
}
