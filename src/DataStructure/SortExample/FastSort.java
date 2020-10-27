package DataStructure.SortExample;

import java.util.Arrays;

public class FastSort {
    public static void main(String[] args) {
        int[] arr={2,3,1,2,3,5,6,2,1};
        fast(0,arr.length-1,arr);
        Arrays.stream(arr).forEach(value -> System.out.println(value));
    }
    public static void fast(int low,int high,int[] arr){
        if(low<high){
            int index=sort(low,high,arr);
            fast(low,index-1,arr);
            fast(index+1,high,arr);
        }
    }
    public static int sort(int low,int high,int[] arr){
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]>=temp) high--;
            arr[low]=arr[high];
            while (low<high&&arr[low]<=temp) low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
