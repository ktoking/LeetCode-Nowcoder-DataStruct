package LeetCode.swordToOffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_7_24_12 {
    /**
     * 暴力dfs深度优先，遍历整个数组，深度优先去判断是否存在字符串
     *
     * 如果ij越界，或者不等于当前words数组里的字符，或者之前访问过了，那么就直接返回，如果当前记录的字符数量k==字符数组长度，那么就算找到了
     *
     * 注意点：1.每次dfs只针对当前路径，不影响下一次双重for的数组访问，所以记录当前已经访问过的标记，应该在递归后还原回去，不影响下一次遍历
     *         2.注意递归的时候（本次递归顺序为上下左右）的ij，k每次都会+1（因为每次当走到这一步了，那么肯定要递归对比下一次当字符，所以k+1）
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board,char[] words,int i,int j,int k){
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||words[k]!=board[i][j]||board[i][j]=='/')return false;
        if(k==words.length-1)return true;

        char temp=board[i][j];
        board[i][j]='/';
        boolean res=dfs(board,words,i-1,j,k+1)||
                    dfs(board,words,i+1,j,k+1)||
                    dfs(board,words,i,j-1,k+1)||
                    dfs(board,words,i,j+1,k+1);
        board[i][j]=temp;
        return res;
    }
}
