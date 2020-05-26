package LeetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class Test_5_23__105 {

    public static void main(String[] args) {
        Test_5_23__105 t=new Test_5_23__105();
        int[]preorder = {3,9,20,15,7};
        int[]inorder = {9,3,15,20,7};
        TreeNode treeNode = t.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen=preorder.length;
        int inLen=inorder.length;
        if(preLen!=inLen) throw new NumberFormatException();

        Map<Integer,Integer> map=new HashMap<>(preLen);
        for (int i = 0; i <inLen ; i++) {
            map.put(inorder[i],i);
        }

        return mybuildTree(map,preorder,0,preLen-1,0,inLen-1);
    }

    private TreeNode mybuildTree(Map<Integer,Integer> map,int[] preorder, int preLeft, int preRight,  int inLeft, int inRight) {
        if(preLeft>preRight||inLeft>inRight) return null;

        int rootVal=preorder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int pIndex= map.get(rootVal);//根节点下标

        root.left=mybuildTree(map,preorder,preLeft+1,pIndex-inLeft+preLeft,inLeft,pIndex-1);
        root.right=mybuildTree(map,preorder,pIndex-inLeft+preLeft+1,preRight,pIndex+1,inRight);
        return root;
    }
}
