package LeetCode.swordToOffer;

import java.util.HashSet;
import java.util.Set;

public class Offer_7_19_03 {
    /**
     * 利用set空间法
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int rtVal=-1;
        for (int num : nums) {
            if(set.contains(num)){
                rtVal=num;
            }else {
                set.add(num);
            }
        }
        return rtVal;
    }

    /**
     * 下标取反法.因为值在0~n之间,正整数,我们构造一个hash表,将值对应到下标,将下标的值取反,等到下一次访问到这个元素的时候,如果是负数,那么直接就返回下标
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums){

        for (int i = 0; i < nums.length ; i++) {
            //nums[i]可能为负(为负是因为这个下标对应的元素出现过了)，所以应该用绝对值表示
            int index = Math.abs(nums[i]);
            if (nums[index]<0)
                return index;
            nums[index] *= (-1) ;
        }
        return 0;

    }

    public static void main(String[] args) {
        int arr[]={2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(arr));
    }
}
