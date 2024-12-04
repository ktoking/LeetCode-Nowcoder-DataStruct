package DataStructure.SortExample;

import java.util.Arrays;

public class FastSort {
    public static void main(String[] args) {
        int[] arr={2,3,1,2,3,5,6,2,1};
        fast(0,arr.length-1,arr);
        fastS(arr,0,arr.length-1);
        fast1(0, arr.length-1,arr);
        Arrays.stream(arr).forEach(System.out::println);
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

    /**
     * 快排杀我
     * @param arr
     * @param l
     * @param h
     */
    public static void fastS(int[] arr,int l,int h){
        if(l<h){
            int index=get(arr,l,h);
            fastS(arr,l,index-1);
            fastS(arr,index+1,h);
        }
    }
    public static int get(int[] arr,int l,int h){
        int temp=arr[l];
        while (l<h){
            while (l<h&&arr[h]>=temp) h--;
            arr[l]=arr[h];
            while (l<h&&arr[l]<=temp) l++;
            arr[h]=arr[l];
        }
        arr[l]=temp;
        return l;
    }




    public static void fast1(int low,int high,int[] arr){
        if(low<high){
            int index = sort1(low, high, arr);
            fast1(low,index-1,arr);
            fast1(index+1,high,arr);
        }
    }

    public static int sort1(int low,int high,int[] arr){
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
