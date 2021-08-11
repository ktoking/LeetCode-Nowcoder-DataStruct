package BUFFcode.WrittenTest.XiaoMi;

import java.util.Random;
import java.util.Scanner;

/**
 * 二维数组找单词
 */
public class Main2 {
    public static void main(String[] args) {
        char[][] chars=new char[][]{{'a','s','c'},{'a','e','c'},{'a','c','e'}};
        if(findword(chars,"see")){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        System.out.println(new Random().nextBoolean());
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
        boolean dfs = dfs(chars, word, vis, i + 1, j, cur);
        boolean dfs1 = dfs(chars, word, vis, i, j + 1, cur);
        boolean dfs2 = dfs(chars, word, vis, i - 1, j, cur);
        boolean dfs3 = dfs(chars, word, vis, i, j - 1, cur);
        vis[i][j]=false;
        return dfs||dfs1||dfs2||dfs3;
    }
}
