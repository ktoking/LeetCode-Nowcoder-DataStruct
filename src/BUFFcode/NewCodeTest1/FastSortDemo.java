package BUFFcode.NewCodeTest1;


/**
 * 链接：https://www.nowcoder.com/questionTerminal/e016ad9b7f0b45048c58a9f27ba618bf?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */

public class FastSortDemo {


    public int findKth(int[] a, int n, int K) {
        return returnKnumber(a,0,n-1,K);
    }

    public static int returnKnumber(int[] arr,int low, int high, int k) {
        int key=getKeyIndex(arr,low,high);

        if(key-low+1==k) return arr[key];
        else if(k>key-low+1) return returnKnumber(arr,key+1,high,k-key+low-1);
        else return returnKnumber(arr,low,key-1,k);
    }


    public static int getKeyIndex(int[] arr,int low,int high){

        int key=arr[low];
        while(low<high){
            while(low<high&&arr[high]<=key) high--;
            arr[low]=arr[high];
            while(low<high&&arr[low]>=key) low++;
            arr[high]=arr[low];
        }
        arr[low]=key;
        return low;
    }




    public static void main(String[] args) {

        }
}
