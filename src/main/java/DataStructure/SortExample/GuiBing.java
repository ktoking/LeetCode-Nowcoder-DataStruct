package DataStructure.SortExample;

import java.util.Arrays;

public class GuiBing {
    public static void main(String[] args) {
        int[] arr={2,3,1,2,3,5,6,2,1};
//        gui(arr,0,arr.length-1);
        gui1(arr,0,arr.length-1);
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


    /**
     * 再写一遍归并排序
     * @param low
     * @param high
     * @param arr
     */
    public static void sort(int low,int high,int[] arr){
        int mid=(low+high)/2;
        if(low<high){
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(low,high,arr,mid);
        }
    }
    public static void merge(int low,int high,int arr[],int mid){
        int[] temp=new int[high-low+1];
        int i=low,j=mid+1,k=0;
        while (i<=mid&&j<=high){
            if(arr[i]<arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while (i<=mid) temp[k++]=arr[i++];
        while (j<=high) temp[k++]=arr[j++];
        for (int l = 0; l < temp.length; l++) {
            arr[low++]=temp[l];
        }
    }


    /**
     * 归并杀我
     * @param arr
     * @param l
     * @param h
     */
    public static void GuiBingS(int[] arr,int l,int h){
        int mid=(h+l)/2;
        if(l<h){
          GuiBingS(arr,l,mid);
          GuiBingS(arr,mid+1,h);
          sort(arr,l,h,mid);
        }
    }
    public static void sort(int[] arr,int l,int h,int mid){
        int[]temp=new int[h-l+1];
        int i=l,j=mid+1,k=0;
        while (i<=mid&&j<=h){
            if(arr[i]>arr[j]){
                temp[k++]=arr[j++];
            }else {
                temp[k++]=arr[i++];
            }
        }
        while (i<=mid){temp[k++]=arr[i++];}
        while (j<=h){temp[k++]=arr[j++];}
        for (int i1 : temp) {
            arr[l++]=i1;
        }
    }


    public static void gui(int[] arr,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            gui(arr,low,mid);
            gui(arr,mid+1,high);
            bing(arr,low,mid,high);
        }
    }

    public  static void bing(int[] arr,int low,int mid,int high){
        int k=mid+1,i=low,j=0;
        int temp[]=new int[high-low+1];
        while (i<=mid&&k<=high){
            if(arr[i]>arr[k]){
                temp[j++]=arr[k++];
            }else {
                temp[j++]=arr[i++];
            }
        }
        while (i<=mid) temp[j++]=arr[i++];
        while (k<=high) temp[j++]=arr[k++];
        for (int l = 0; l < temp.length; l++) {
            arr[low++]=temp[l];
        }
    }
    public static void gui1(int[] arr,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            gui1(arr,low,mid);
            gui(arr,mid+1,high);
            sort1(arr,low,mid,high);
        }
    }
    public static void sort1(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int nl=low,nh=mid+1,index=0;
        while (nl<=mid&&nh<=high){
            temp[index++]=arr[nl]>arr[nh]?arr[nh++]:arr[nl++];
        }
        while (nl<=mid) temp[index++]=arr[nl++];
        while (nh<=high) temp[index++]=arr[nh++];
        for (int i = 0; i < temp.length; i++) {
            arr[low++]=temp[i];
        }
    }
}
