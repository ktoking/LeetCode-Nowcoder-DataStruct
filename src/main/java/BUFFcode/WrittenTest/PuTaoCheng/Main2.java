package BUFFcode.WrittenTest.PuTaoCheng;

public class Main2 {
    public static void main(String[] args) {
        int[] nums={1,3,5,7,9,11,13,17,19};
        for (int i = 0; i <= 20; i++) {
            if(isExist(i,nums)){
                System.out.println(i+"存在");
            }else {
                System.out.println(i+"不存在");
            }
        }
    }

    public static boolean isExist(int num,int[] nums){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==num) return true;
            else if(nums[mid]>num){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }
}
