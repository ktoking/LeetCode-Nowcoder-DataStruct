package DataStructure.DynamicProgram;

public class PackageQuestion {

    /**
     * 01背包问题
     * f[i][j] = max(f[i][j],f[i-1][j-v[i]]+w[i]);//01背包
     * f[i][j] = max(f[i][j],f[i][j-v[i]]+w[i]);//完全背包问题
     */
    public static void main(String[] args) {
        int w[]=new int[1010];    // 重量
        int v[]=new int[1010];    // 价值
        int f[][]=new int[1010][1010];  // f[i][j], j重量下前i个物品的最大价值
        int n=10; //定义n个物品
        int m=10; //定义背包大小
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j)
            {
                //  当前重量装不进，价值等于前i-1个物品
                if(j < w[i])
                    f[i][j] = f[i-1][j];
                    // 能装，需判断
                else
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-w[i]] + v[i]);
            }

        System.out.println(f[n][m]);
    }
}
