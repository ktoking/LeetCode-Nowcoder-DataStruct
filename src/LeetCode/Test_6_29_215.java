package LeetCode;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_6_29_215 {

    public static void main(String[] args) {
        int arr[]={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr,4));
    }

    /**
     * 典型快排解决问题
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
         return fastsort(nums, 0, nums.length-1, k);
    }

    public static int fastsort(int arr[],int low,int high,int k){
        int index=getIndex(arr, low, high); //找出中间值下标
        if(index-low+1==k) return arr[index]; //如果刚好等于要找到第k个大,就直接返回
        else if(k>index-low+1) return fastsort(arr,index+1,high,k-index+low-1); //如果要找到k在我们查询的中间值的右边,那我们递归更新条件 最小的为中间值下标+1,最大值还是high 当然我们的第k个可以直接减去low的数量更新k的值,这样一下可以减少一半数组
        else return fastsort(arr,low,index-1,k); //如果要找的k在中间值下标的左边,那我们更新递归条件 low还是low,high为中间值-1,k不变,因为是从左往右数
    }

    /** ps:从大到小排序
     * 找出中间值的下标,中间值左边都大于中间值,右边都小于中间值 那需要第k大就从左边往右边数了
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int getIndex(int arr[],int low,int high){
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]<=temp) high--;
            arr[low]=arr[high];
            while (low<high&&arr[low]>=temp) low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }


}
