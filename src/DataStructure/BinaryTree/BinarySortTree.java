package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序数
 */
class Node{
   private int no;
   private Node left;
   private Node right;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //二叉树插入
    public void add(Node node){
        if(node==null) return;
        if(node.no<this.no){ //如果插入的值小于根节点的值(向左插入)
            if(this.left==null){ //如果当前左节点为空,那就插入
                this.left=node;
            }else { //如果当前左节点不为空(递归插入)
                this.left.add(node);
            }
        }else{//如果插入的值大于根节点的值(向右插入)
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }

    //中序打印
    public void midPrt(){
        if(this.left!=null) this.left.midPrt();
        System.out.println(this);
        if(this.right!=null) this.right.midPrt();
    }
    //后序打印
    public void post(){
        if(this.left!=null) this.left.post();
        if(this.right!=null) this.right.post();
        System.out.println(this);
    }


}

/**
 * 生成树
 */
class BinarySortTree1{

    private Node root;

    public void add(Node node){
        if(root==null) root=node;
        else {
            root.add(node);
        }
    }

    public void midPtf(){
        if(root!=null) root.midPrt();
        else System.out.println("节点为空");
    }

    //层序遍历
    public void cengxu(){
        Node node=root;
        Queue<Node> queue = new LinkedList<>();
        if(node==null) return;
        queue.offer(node);
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            if(queue.peek().getLeft()!=null){
                queue.offer(queue.peek().getLeft());
            }
            if(queue.peek().getRight()!=null){
                queue.offer(queue.peek().getRight());
            }
            queue.poll();
        }
    }


}

public class BinarySortTree {
    public static void main(String[] args) {

        BinarySortTree1 binarySortTree1=new BinarySortTree1();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            binarySortTree1.add(new Node(arr[i]));
        }
        System.out.println("构造后的二叉树中序遍历为:");
        binarySortTree1.midPtf();

        System.out.println("层序遍历为: ");
        binarySortTree1.cengxu();

    }
}
