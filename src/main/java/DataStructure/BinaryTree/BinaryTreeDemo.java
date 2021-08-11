package DataStructure.BinaryTree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        NodeDemo nodeDemo=new NodeDemo(1,"kaikai");
        NodeDemo nodeDemo2=new NodeDemo(2,"jiajia");
        NodeDemo nodeDemo3=new NodeDemo(3,"kai");
        NodeDemo nodeDemo4=new NodeDemo(4,"jia");
        NodeDemo nodeDemo5=new NodeDemo(5,"kkk");

        nodeDemo.setLeft(nodeDemo2);
        nodeDemo.setRight(nodeDemo3);
        nodeDemo3.setRight(nodeDemo4);
        nodeDemo3.setLeft(nodeDemo5);

        nodeDemo.preOrder();
        System.out.println();
        nodeDemo.midOrder();
        System.out.println();
        nodeDemo.postOrder();

        System.out.println("前序查找为: ");
        NodeDemo preNodeDemo = nodeDemo.preSearch(5);
        System.out.println(preNodeDemo);

        System.out.println("中序查找为: ");
        NodeDemo midNodeDemo = nodeDemo.preSearch(3);
        System.out.println(midNodeDemo);

        System.out.println("后序查找为: ");
        NodeDemo postNodeDemo = nodeDemo.preSearch(4);
        System.out.println(postNodeDemo);

        System.out.println();
        System.out.println("二叉树删除前为: ");
        nodeDemo.preOrder();
        System.out.println("二叉树删除后为: ");
        nodeDemo.deleteNode(nodeDemo,3);
        nodeDemo.preOrder();
    }

}
 class  NodeDemo{
    private int num;
    private String name;
    private NodeDemo left;
    private NodeDemo right;

    public NodeDemo(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeDemo getLeft() {
        return left;
    }

    public void setLeft(NodeDemo left) {
        this.left = left;
    }

    public NodeDemo getRight() {
        return right;
    }

    public void setRight(NodeDemo right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NodeDemo{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    //先序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null) this.left.preOrder();
        if(this.right!=null) this.right.preOrder();
    }

    //中序遍历
    public void midOrder(){
        if(this.left!=null) this.left.midOrder();
        System.out.println(this);
        if(this.right!=null) this.right.midOrder();
    }

    //后序遍历
    public void postOrder(){
        if(this.left!=null) this.left.postOrder();
        if(this.right!=null) this.right.postOrder();
        System.out.println(this);
    }

    //前序查找
    public NodeDemo preSearch(int num){
        if(this.num==num){
          return this;
        }
        NodeDemo nodeDemo=null;
        if(this.left!=null){
            nodeDemo = this.left.preSearch(num);
        }
        if(nodeDemo!=null) return nodeDemo;

        if(this.right!=null){
            nodeDemo = this.right.preSearch(num);
        }
        return nodeDemo;
    }

    //中序查找
    public NodeDemo midSearch(int num){
        NodeDemo nodeDemo=null;
        if(this.left!=null){
            nodeDemo = this.left.midSearch(num);
        }
        if(nodeDemo!=null) return nodeDemo;

        if(this.num==num){
            return this;
        }

        if(this.right!=null){
            nodeDemo = this.right.midSearch(num);
        }
        return nodeDemo;
    }

    //后序查找
    public NodeDemo postSearch(int num){
        NodeDemo nodeDemo=null;
        if(this.left!=null){
            nodeDemo = this.left.postSearch(num);
        }
        if(nodeDemo!=null) return nodeDemo;

        if(this.right!=null){
            nodeDemo = this.right.postSearch(num);
        }
        if(this.num==num){
            return this;
        }
        return nodeDemo;
    }

    //删除节点
    public void deleteNode(NodeDemo nodeDemo,int num){
        if(nodeDemo==null) System.out.println("二叉树为空");
        else if(nodeDemo.left==null&&nodeDemo.right==null) nodeDemo=null;
        else {
            nodeDemo.delete(num);
        }
    }
    public void delete(int num){
        if(this.left!=null&&this.left.num==num) this.left=null;
        if(this.right!=null&&this.right.num==num) this.right=null;

        if(this.left!=null) this.left.delete(num);
        if(this.right!=null) this.right.delete(num);
    }
}
