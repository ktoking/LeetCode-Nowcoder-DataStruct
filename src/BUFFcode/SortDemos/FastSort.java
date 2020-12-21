package BUFFcode.SortDemos;

public class FastSort {
    public static void main(String[] args) {
        int[] arr = { 415,5,4,12,45,78,2,32 };
        kuaipai(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int index=getIndex(arr,low,high);
            quickSort(arr,0,index-1);
            quickSort(arr,index+1, high);
        }
    }

    public static int getIndex(int[] arr,int low,int high){
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while (low<high&&arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }

    public static void quickSort1(int[] arr,int low,int high){
        if(low<high){
            int index=getIndex1(arr, low, high);
            quickSort1(arr, low, index-1);
            quickSort1(arr, index+1, high);
        }
    }
    public static int getIndex1(int[] arr,int low,int high){
        int temp = arr[low];
        while(low<high){
            while (low<high&&arr[high]>temp)
                high--;
            arr[low]=arr[high];
            while (low<high&&arr[low]<temp)
                low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }



    public static void kuaipai(int[] arr,int low,int high){
        if(low<high){
            int index=fenqu(arr,low,high);
            kuaipai(arr,low,index-1);
            kuaipai(arr,index+1,high);
        }
    }

    public static int fenqu(int[] arr,int low,int high){
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]>temp) high--;
            arr[low]=arr[high];
            while (low<high&&arr[low]<temp) low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
