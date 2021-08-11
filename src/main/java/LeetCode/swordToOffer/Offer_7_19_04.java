package LeetCode.swordToOffer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_7_19_04 {

    /**
     * 将右上角考虑为二叉树的根节点
     * 那么我们发现这就是一个顺序二叉树
     * 比根节点大的在节点下方,比根节点小的在节点左方,那么我们通过二叉树的遍历就可以找到,注意我们要在查找的时候考虑数组越界,还得考虑如果没找到跳出即可
     *
     * 作者：xxl-10
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/er-cha-shu-cha-zhao-fa-by-xxl-10/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        int row=0;
        int col=matrix[0].length-1;
        boolean flag=false;
        while(true){
            if(target<matrix[row][col]&&col>=0){
                col-=1;
            }else if(target>matrix[row][col]&&row<matrix.length){
                row+=1;
            }else {
                flag=true;
                break;
            }
            if(col<0||row>matrix.length-1){
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] arr={{-1},{-1}};
        System.out.println(findNumberIn2DArray(arr,0));

        int[][] arr1={{-1},{-1}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
}
