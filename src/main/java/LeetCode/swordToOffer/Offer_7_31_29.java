package LeetCode.swordToOffer;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Offer_7_31_29 {

    /**
     * 基本思路，顺时针打印二维数组，首先我们这样想，先向右边直到出界或者已被访问过了，那我们就向下走判断是否越界或访问过了，然后向左向上
     * 直到记录所有数据，即循环结束条件就是访问过所有数组，为了很方便我们知道向哪个方向走，我们定义一个方向二维数组记录向右下左上这种方向
     * 当我们下一个元素越界或者访问过了就换方向，循环使用方向数组
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] directions={
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        int directIndex=0,nowr=0,nowc=0;
        boolean[][] vis=new boolean[row][col]; //用来存访问数组
        int all=col*row;
        int[] rtVal=new int[all];
        for (int i = 0; i < all; i++) {
            rtVal[i] = matrix[nowr][nowc];
            vis[nowr][nowc] = true;
            int nextr = nowr + directions[directIndex][0], nextc = nowc + directions[directIndex][1];
            if (nextr < 0 || nextc < 0 || nextr >= row || nextc >= col || vis[nextr][nextc]) {
                directIndex = (directIndex + 1) % 4; //循环使用方向数组
            }
            nowr += directions[directIndex][0];
            nowc += directions[directIndex][1];
        }
        return rtVal;
    }

    /**
     * 首先设定好边界，每走完一层，我们缩小边界条件，最后如果边界冲突就退出即可
     * @param matrix
     * @return
     */
    public int[] spiralOrder1(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int t=0,r=matrix[0].length-1,b=matrix.length-1,l=0,index=0;
        int[] rtVal=new int[(r+1)*(b+1)];
        while (true){
            for (int i = l; i <=r ; i++) rtVal[index++]=matrix[t][i];
            if(++t>b) break;
            for (int i = t; i <=b ; i++) rtVal[index++]=matrix[i][r];
            if(--r<l) break;
            for (int i = r; i >=l ; i--) rtVal[index++]=matrix[b][i];
            if(--b<t) break;
            for (int i = b; i >=t ; i--) rtVal[index++]=matrix[i][l];
            if(r<++l) break;
        }
            return rtVal;
    }

    /**
     * 回型 顺时针打印矩阵
     * @param matrix
     */
    public static void shunshizhen1(int[][] matrix) {
        int t=0,r=matrix[0].length-1,b=matrix.length-1,l=0,index=1;
        while (true){
            for (int i = l; i <= r ; i++){matrix[t][i]=index++;} if(++t>b) break;
            for (int i = t; i <= b ; i++){matrix[i][r]=index++;} if(--r<l) break;
            for (int i = r; i >= l ; i--){matrix[b][i]=index++;} if(--b<t) break;
            for (int i = b; i >= t ; i--){matrix[i][l]=index++;} if(++l>r) break;
        }
    }





    public static int[] spiralOrder2(int[][] matrix) {
        if(matrix==null||matrix.length==0) return new int[]{};
        int t=0,r=matrix[0].length-1,b=matrix.length-1,l=0,count=0;
        int[] rst=new int[(r+1)*(b+1)];
        while (true){
            for (int i = l; i <=r ; i++) { rst[count++]=matrix[t][i]; } if(++t>b) break;
            for (int i = t; i <=b ; i++) { rst[count++]=matrix[i][r]; } if(--r<l) break;
            for (int i = r; i >=l ; i--) { rst[count++]=matrix[b][i]; } if(--b<t) break;
            for (int i = b; i >=t ; i--) { rst[count++]=matrix[i][l]; } if(++l>r) break;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] ints = spiralOrder2(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}});
        for (int anInt : ints) {
            System.out.printf("%d ",anInt);
        }
    }

    public int[] spiralOrder3(int[][] matrix) {
        if(matrix==null||matrix.length==0) return new int[]{};
        int l=0,t=0,r=matrix[0].length-1,b=matrix.length-1,count=0;
        int[] res=new int[(r+1)*(b+1)];
        while (true){
            for (int i = l; i <=r ; i++){ res[count++]=matrix[t][i];} if(++t>b)break;
            for (int i = t; i <=b ; i++){ res[count++]=matrix[i][r];} if(--r<l)break;
            for (int i = r; i >=l ; i--){ res[count++]=matrix[b][i];} if(--b<t)break;
            for (int i = b; i >=t ; i--){ res[count++]=matrix[i][l];} if(++l>r)break;
        }
        return res;
    }









}

