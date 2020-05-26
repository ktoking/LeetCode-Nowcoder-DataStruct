package DataStructure.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找非递归
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,7,7};
        System.out.println(getIndex(arr, 7));
    }

    public static List<Integer> getIndex(int[] arr,int val){
        int left=0;
        int right=arr.length-1;
        List<Integer> list=new ArrayList<>();
        while(left<=right){  //结束条件肯定是left>right
            int mid=(left+right)/2; //那我们肯定每次都需要计算mid值啊
            if(val==arr[mid]){  //这里我判断了如果查到了,那接下来一系列操作与递归写的相同(就是向左向右查找相同值加到list中)
              int temp=mid-1;
              while(true){
                 if(temp<0||arr[temp]!=val)   {
                     break;
                 }
                 list.add(temp);
                 temp-=1;
              }
              list.add(mid);
              temp=mid+1;
              while(true){
                  if(temp>arr.length-1||arr[temp]!=val)   {
                      break;
                  }
                  list.add(temp);
                  temp+=1;
              }
              return list;
            }else if(val<arr[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return new ArrayList<>();
    }
}
