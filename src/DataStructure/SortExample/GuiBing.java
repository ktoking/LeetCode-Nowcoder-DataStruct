package DataStructure.SortExample;

import java.util.Arrays;

public class GuiBing {
    public static void main(String[] args) {
        int[] arr={2,3,1,2,3,5,6,2,1};
        sort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(value -> System.out.println(value));
    }
    /**
     * 归并排序
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int[] sort(int[] arr,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
        return arr;
    }

    public static void merge(int[] arr, int low, int mid, int high) {
      int[] temp=new int[high-low+1];
      int i=low,j=mid+1,k=0;
      while (i<=mid&&j<=high){
          if(arr[i]>arr[j]){
              temp[k++]=arr[j++];
          }else {
              temp[k++]=arr[i++];
          }
      }
      while (i<=mid) temp[k++]=arr[i++];
      while (j<=high) temp[k++]=arr[j++];
      for (int l = 0; l < temp.length; l++) {
          arr[low++]=temp[l];
      }
    }
}
