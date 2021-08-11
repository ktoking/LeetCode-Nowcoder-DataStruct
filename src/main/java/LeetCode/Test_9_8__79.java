package LeetCode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_9_8__79 {

    /**
     * 回溯不超时,每个字母对比,并且利用特殊字符.记录,不符合的回溯回去,单词搜索
     * @param board
     * @param word
     * @return
     */
    public boolean exist1(char[][] board, String word) {
       if(board.length==0||board==null) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(huisu(board,word.toCharArray(),i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean huisu(char[][] board,char[] words,int i,int j,int index){
        if(i<0||i>board.length-1||j<0||j>board[0].length-1||board[i][j]!=words[index]){
            return false;
        }
        if(index==words.length-1){
            return true;
        }
        char c=board[i][j];
        board[i][j]='.';
        boolean res=huisu(board,words,i+1,j,index+1)||
                huisu(board,words,i,j+1,index+1)||
                huisu(board,words,i-1,j,index+1)||
                huisu(board,words,i,j-1,index+1);
        board[i][j]=c; //回溯
        return res;
    }

    /**
     * dfs+简单回溯 超时!!! 需要特殊回溯,每次对比相同字符,不能等长度相同再对比
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        return findword(board,word);
    }
    public static boolean findword(char[][] chars,String word){
        boolean[][] vis=new boolean[chars.length][chars[0].length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if(dfs(chars,word,vis,i,j,"")) return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] chars,String word,boolean[][] vis,int i,int j,String cur){
        if(i<0||i>=chars.length||j<0||j>=chars[0].length||vis[i][j]||cur.length()>word.length()){
            return false;
        }
        vis[i][j]=true;
        cur+=chars[i][j];
        if(cur.equals(word))return true;
        if(dfs(chars, word, vis, i + 1, j, cur)||
        dfs(chars, word, vis, i, j + 1, cur)||
        dfs(chars, word, vis, i - 1, j, cur)||
        dfs(chars, word, vis, i, j - 1, cur)){
            return true;
        }
        vis[i][j]=false;
        return false;
    }
}
