package BUFFcode.WrittenTest.WangYiYouXi;

import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger rtval=new BigInteger("-1");
    static boolean flag=false;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        String a=scanner.next();
        //对b重排找到b'>a b'的最小值
        char[] b=scanner.next().toCharArray();

        Arrays.sort(b);
        quan(b,0,a);
        System.out.println(rtval);
    }

    public static void quan(char[] nums,int start,String a){
        if(!flag){
            if(start==nums.length){
                StringBuilder sb=new StringBuilder();
                for (char num : nums) {
                    sb.append(num);
                }
                BigInteger bigInteger=new BigInteger(sb.toString());
                if(bigInteger.compareTo(new BigInteger(a))>0){
                    rtval=bigInteger;flag=true;return;
                }
            }else {
                Set<Character> set=new HashSet<>();
                for (int i = start; i <nums.length ; i++) {
                    if(set.contains(nums[i])) continue;
                    else set.add(nums[i]);
                    swap(nums,i,start);
                    quan(nums,start+1, a);
                    swap(nums,i,start);
                }
            }
        }else {
            return;
        }
    }

    public  static void swap(char[] nums,int i,int j){
        char temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
