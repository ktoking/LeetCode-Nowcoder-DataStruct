package BUFFcode.WrittenTest.LaoHu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int arr[][]={{2,1,4},{4,2,6}};
        System.out.println(minCarCount(arr,5));
    }
    /**
     * 返回最少需要多少辆车
     * @param trips int整型二维数组 二维int数组，用于表示一组乘客的行程信息，其中`trip[i]`表示第i组乘客，`trip[i][0]`表示第i组乘客的乘客数量，`trip[i][1]`表示上车站点，`trip[i][2]`表示下车站点。
     * @param capacity int整型 int类型，表示每辆车最多能承载多少名乘客
     * @return int整型
     */
    public static int minCarCount (int[][] trips, int capacity) {
        int row=trips.length;
        int dp[]=new int[1001];
        int count[]=new int[1001];//i站点下车人数
        int remain=0;//当前车内人数
        dp[0]=1;
        count[trips[0][2]]+=trips[0][0];
        remain=remain+trips[0][0]-count[0];
        for (int i = 1; i < row; i++) {
            count[trips[i][2]]+=trips[i][0];
            remain=remain+trips[i][0]-count[i];
            if(remain<=capacity){
                dp[i]=dp[i-1];
            }else {
                if(remain%capacity!=0){
                    dp[i]=(remain)/capacity+1;
                }else {
                    dp[i]=(remain)/capacity;
                }
            }
        }
        return dp[row-1];
    }
}
