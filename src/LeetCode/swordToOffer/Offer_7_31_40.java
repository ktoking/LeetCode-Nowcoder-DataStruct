package LeetCode.swordToOffer;

public class Offer_7_31_40 {
    public static void main(String[] args) {
        Offer_7_31_40 o=new Offer_7_31_40();
        int arr[]={3,2,0,0};
        int[] leastNumbers = o.getLeastNumbers(arr, 1);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0) return new int[0];
        get(arr,0, arr.length-1,k);
        int[] rtVal=new int[k];
        for (int i = 0; i < k; i++) {
            rtVal[i]=arr[i];
        }
        return rtVal;
    }

    public void get(int[] arr,int low,int high,int k){
        if(low<high){
            int index=sort(low,high,arr);
            if(index==k) return;
            else if(index>k)get(arr,low,index-1,k);
            else get(arr,index+1,high,k);
        }
    }

    public int sort(int low,int high,int[] arr){
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]>=temp)high--;
            arr[low]=arr[high];
            while (low<high&&arr[low]<=temp)low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
