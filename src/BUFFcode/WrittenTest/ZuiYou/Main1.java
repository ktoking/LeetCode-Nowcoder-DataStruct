package BUFFcode.WrittenTest.ZuiYou;

import DataStructure.BinaryTree.BinarySortTree;

import java.util.Scanner;

public class Main1 {

    /**
     * 1-n构成二叉搜索树种类
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        if(n<1){
            return 1;
        }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=numTrees2(i-1)*numTrees2(n-i);
        }
        return sum;
    }

    /**
     * 设dp[i]表示共有i个节点时，能产生的BST树的个数
     * n == 0 时，空树的个数必然为1，因此dp[0] = 1
     * n == 1 时，只有1这个根节点，数量也为1，因此dp[1] = 1
     * 当根节点元素为 1, 2, 3, 4, 5, …, i, …, n时，基于以下原则的BST树具有唯一性：
     * 以i为根节点时，其左子树构成为[0,…,i-1],其右子树构成为[i+1,…,n]构成
     * 因此，dp[i] = sigma（dp[0…k] * dp[k+1…i]） 0 <= k < i - 1
     * bts
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n==0||n==1){
            return 1;
        }
        int[] nums=new int[n+1];
        nums[0]=1;
        nums[1]=1;

        for(int i=2;i<=n;i++){
            int sum=0;
            for(int j=0;j<=i-1;j++){
                sum+=nums[j]*nums[i-j-1];
            }
            nums[i]=sum;
        }

        return nums[n];
    }
}
