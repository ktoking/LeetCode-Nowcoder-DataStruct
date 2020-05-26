package DataStructure.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchDemoDigui {
    public static void main(String[] args) {
        int arr[]={1,2,3,3,3,4,5,5,6,6,7};
        Arrays.sort(arr);//二分查找要保证数组有序,其实没必要有这一步~~
        System.out.println(get(arr,0,arr.length-1,300));
    }

    public static List get(int arr[],int left,int right,int value){

        int mid=(left+right)/2;
        int midval=arr[mid];

        if(left>right) return new ArrayList();  //结束条件 那左下标都大于右下标了肯定返回了~

        if(value>midval){  //如果我们要找得值是大于中间值的,那它肯定是在中间值右边的,那我们就只用考虑中间值右半部分的
             return get(arr,mid+1,right,value);
        }else if(value<midval){ //如果我们要找得值是小于中间值的,那它肯定是在中间值左边的,那我们就只用考虑中间值左半部分的
             return get(arr,left,mid-1,value);
        }else {
            List<Integer> list=new ArrayList(); //这里我们优化一下算法,这里返回所有与查找值相同的数组下标,用list收集起来

            int temp=mid-1; //首先在这个条件里的值肯定是等于要查找数的值,那首先数组是有序的,那我们只需要从左或者从右判断是否有与相同值即可
            while(true){
                if(temp<0||arr[temp]!=value){  //结束条件,下同
                    break;
                }
                list.add(temp);  //符合条件就加到list里
                temp-=1;        // 继续向左查找
            }

            list.add(mid);  //别忘了把中间值加进去

            temp=mid+1;  //继续向右查找
            while(true){
                if(temp>arr.length-1||arr[temp]!=value){
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;
        }

    }
}
