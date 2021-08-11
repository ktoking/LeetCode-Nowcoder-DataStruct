package BUFFcode.WrittenTest.BanYu;

import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     * 后序遍历二叉搜索树
     * @param postorder int整型一维数组
     * @return bool布尔型
     */
    public boolean verifyPostorder (int[] postorder) {
        // write code here
        return ifhou(postorder,0,postorder.length-1);
    }
    public boolean ifhou(int[] arr,int i,int j){
        if(i>=j) return true;
        int p=i;
        while (arr[p]<arr[j]) p++;
        int m=p;
        while (arr[p]>arr[j]) p++;
        return  p==j&& ifhou(arr,i,m-1)&& ifhou(arr,m,j-1);
    }


    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int lengthOfLongestSubstring (String s) {
        if(s.length()==0) return 0;
        Set<Character> set=new HashSet();
        int n=s.length();
        int rigth=-1,ans=0;
        for (int i = 0; i < n; i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (rigth+1<n&&!set.contains(s.charAt(rigth+1))){
                set.add(s.charAt(rigth+1));
                rigth++;
            }
            ans = Math.max(ans, rigth - i + 1);
        }
        return ans;
    }


    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int minFlipsMonoIncr (String s) {
      int[] dp=new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            dp[i+1]=dp[i]+(s.charAt(i)=='1'?1:0);
        }
        int num=Integer.MAX_VALUE;
        for (int i = 0; i <= s.length(); i++) {
            num=Math.min(num,dp[i]+s.length()-i-(dp[s.length()]-dp[i]));
        }
        return num;
    }
}
