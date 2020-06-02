package DataStructure.LinkListDemo;


import java.util.Stack;

class Node{
    public int no;
    public String name;
    public Node next; //存放指向下一个节点的数据

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

class LinkedListDemo{
    private Node head=new Node(-1,"");//初始化头节点

    /**
     * 链表无序加入数据
     * @param node
     */
    public   void add(Node node){
        Node temp=head; //由于不能移动head,所以用temp代替
        while(true){
            if(temp.next==null){ //当找到下一个节点元素为空是,就可以把新的数据加入到这里
                break;
            }
            temp=temp.next; //当找不到时,一直向后找
        }
        temp.next=node;   //这里加入新节点
    }

    /**
     * 打印所有节点信息
     */
    public void prtList(){
        if(head.next==null) System.out.println("链表为空");
        Node temp=head.next; //由于不能移动head,所以用temp代替
        while(true){
            if(temp==null){ //判断链表谁否到最后
                break;
            }
            System.out.println(temp);//输出节点信息
            temp=temp.next;//节点后移
        }
    }

    /**
     *有序插入节点
     */
    public void addOrder(Node node){
        Node temp=head;
        boolean flag=false; //判断是否重复添加
        while (true){  //查找该插入的节点位置
            if(temp.next==null){ //在链表最后
              break;
            }
            if(node.no<temp.next.no){  //这里需要找到temp的下一个位置与插入的node比较,比temp的下一个元素小,那就可以插入到temp后面
                break; //位置已经找到
            }else if(temp.next.no==node.no){
                flag=true;
                break; //不能添加重复的元素
            }
            temp=temp.next; //向后移
        }
        if(flag) System.out.println("不能添加重复编号的节点: "+node);
        else {
            node.next=temp.next;
            temp.next=node;
        }
    }

    /**
     * 修改节点数据
     * @param node
     */
    public void updateNode(Node node){
        if(head.next==null) System.out.println("链表为空,不能修改");
        Node temp=head.next;
        boolean flag=false;//表示是否找到修改的节点
        while (true){
            if(temp==null) break; //表示找到最后还是没有找到
            if(temp.no==node.no){
                flag=true;//表示找到了
                break;
            }
            temp=temp.next;//接着向后查找
        }
        if(flag) {
            temp.name=node.name;
        }else{
            System.out.println("未发现存在的节点 :"+node);
        }
    }

    /**
     * 删除节点
     * @param node
     */
    public void deleteNode(Node node){
        if(head.next==null) System.out.println("链表为空,不能删除");
        Node temp=head; //由于不能改变head的值,使用临时变量
        boolean flag=false;//表示未能找到删除节点
        while(true){
            if(temp.next==null){
                break; //表示未能找到当前删除的节点
            }
            if(temp.next.no==node.no){  //表示找到要删除的节点
                flag=true;
                break;
            }
            temp=temp.next;//找不到就向后找
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.println("未能找到删除的节点: "+node);
        }
    }

    /**
     * 获取链表有效节点个数
     * @return
     */
    public int getAllNodeNumber(){
        int num=0;
        if(head.next==null) return 0;
        Node temp=head.next;
        while (true){
            if(temp==null){
                break;
            }
            num++;
            temp=temp.next;
        }
        return num;
    }

    /**
     * 获取倒数第K个节点(思路:定义两个指针变量一开始指向头节点,让第一个first先走k-1步,然后第二个second跟第一个一起走,当第一个走到头后,输出第二个就是倒数第K个元素)
     */
    public void getLastK(int k){
        if(head.next==null) System.out.println("链表为空");
        Node first=head;
        Node second=head;
        for (int i = 0; i < k-1; i++) {
            if(first.next==null) return;
            first=first.next;
        }
        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        System.out.println(second);
    }

    /**
     * 用栈来反转链表
     */
    public void InverseList(){
        if(head.next==null) {
            System.out.println("链表为空,不能反转");
            return;
        }
        Node temp=head; //使用temp来遍历list
        Node newTemp=head; //使用newTemp来串新链表
        Stack<Node> stack=new Stack<>(); //用栈来保存链表所有数据
        while(temp.next!=null){ //循环加入栈中
            stack.push(temp.next);
            temp=temp.next;
        }
        while(!stack.empty()){ // 当栈不为空时,一直弹出,加到新节点后(改变原先顺序)
            newTemp.next=stack.pop();
            newTemp=newTemp.next;
        }
//        while (stack.size()>0){ //不改变原先顺序,直接打印出来
//            System.out.println(stack.pop());
//        }
        newTemp.next=null; //如果不设置最后一个节点的next域,那将会变成环形链表
    }

    /**
     * 使用头插法反转链表
     */
    public void reverse() {
        if (head.next == null || head.next.next == null)
            return ;
        Node cur=head.next;
        Node next=null;
        Node reserve=new Node(-1,"");
        while(cur!=null){
            next=cur.next;
            cur.next=reserve.next;
            reserve.next=cur;
            cur=next;
        }
        head.next=reserve.next;
    }

    /**
     * 递归反转链表
     */
    public Node reverse1(Node head){
        if(head==null||head.next==null)
            return head;
        Node newHead = reverse1(head.next);
        Node temp=head.next;
        temp.next=head;
        head.next=null;
        return newHead;
    }

    /**
     * 将两个有序的链表合并
     * @param list1
     * @param list2
     * @return
     */
    public Node mergeList(Node list1,Node list2){
        if(list1==null) return list2; //如果一条链表为空,那就返回另一条链表
        if(list2==null) return list1;
        Node newNode=new Node(-1,""); //定义一个新链表头
        Node temp=newNode; //头不能变,所以定义临时变量
        while((list1!=null)&&(list2!=null)){ //当只要有一个变量的值为空就跳出循环
            if(list1.no>=list2.no){ //当list1.no>=list2.no
                temp.next=list2; //我们把小的连到头的后面,下同
                list2=list2.next;
            }
            else {
                temp.next=list1;
                list1=list1.next;
            }
            temp=temp.next; //临时变量向后移
        }
//        if(list1==null){
//            temp.next=list2;
//        }
//        else if (list2==null){
//            temp.next=list1;
//        }
        temp.next=list1==null?list2:list1; //当某一个链表的值为空时,就将另一条链表连入新表
        return newNode.next; //返回新链表的第一个值
    }

    /**
     * 递归合并链表
     * @param list1
     * @param list2
     * @return
     */
    public Node mergeListDigui(Node list1,Node list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.no<list2.no){
            list1.next= mergeListDigui(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeListDigui(list1, list2.next);
            return list2;
        }
    }


}

public class LinkListDemo {

    public static void main(String[] args) {
        Node node=new Node(1,"kaikai");
        Node node1=new Node(2,"kaikai");
        Node node2=new Node(4,"kaikai");
        LinkedListDemo list=new LinkedListDemo();
//        list.addOrder(node);
//        list.addOrder(node1);
//        list.addOrder(node2);
//        list.prtList();

        Node node3=new Node(2,"kaikai1");
        Node node4=new Node(3,"kaikai");
        Node node5=new Node(8,"kaikai");

        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

//        while (node!=null){
//            System.out.println(node);
//            node=node.next;
//        }
        System.out.println("逆序后");
        Node reserv = list.reverse1(node);

        while (reserv!=null){
            System.out.println(reserv);
            reserv=reserv.next;
        }

//        Node node6 = list.mergeListDigui(node, node4);
//        while(node6!=null){
//            System.out.println(node6);
//            node6=node6.next;
//        }


//        final int allNodeNumber = list.getAllNodeNumber();
//        System.out.println("链表的有效个数为: "+allNodeNumber);
//
//        System.out.println("链表反转后为: ");
//        list.reverse();
//        list.prtList();
//
//        System.out.println("得到链表倒数第K的节点为: ");
//        list.getLastK(3);


//
//        System.out.println("修改数据后为:");
//        Node node5=new Node(5,"kaikai55555");
//        list.updateNode(node5);
//        list.prtList();
//
//        System.out.println("删除数据后为:");
//        Node node6=new Node(5,"kaikai55555");
//        list.deleteNode(node6);
//        list.prtList();
    }
}
