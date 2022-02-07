package LeetCode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_8_3__2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        ListNode head=new ListNode(-1),newHead=head;
        int jin=0;
        while (l1!=null||l2!=null||jin!=0){
            ListNode temp=new ListNode(0);
            if(l1!=null){
                jin+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                jin+=l2.val;
                l2=l2.next;
            }
            temp.val=jin%10;
            newHead.next=temp;
            newHead=newHead.next;
            jin/=10;
        }
        return head.next;
    }

    /**
     * 在写一次 类似于大数相加 这个已经逆序了就直接做 记录一下进位即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        int jin=0;
        ListNode head=new ListNode(-1);
        ListNode newHead=head;

        while (l1!=null||l2!=null||jin!=0){
            ListNode temp=new ListNode(0);
            if(l1!=null){
                jin+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                jin+=l2.val;
                l2=l2.next;
            }
            temp.val=jin%10;
            newHead.next=temp;
            newHead=newHead.next;
            jin/=10;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2= new ListNode(4);
        ListNode listNode3 = new ListNode(9);
        listNode1.next=listNode2;listNode2.next=listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(9);
        listNode4.next=listNode5;listNode5.next=listNode6;listNode6.next=listNode7;

        addTwoNumbers111(listNode1,listNode4);

    }

    // 逆序做法 大数相加思路
    public static ListNode addTwoNumbers111(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            if(l1!=null) {
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                carry+=l2.val;
                l2=l2.next;
            }
            ListNode listNode = new ListNode(carry % 10);
            carry/=10;
            temp.next=listNode;
            temp=temp.next;
        }
        return head.next;
    }


    // 不逆序做法
    public static ListNode addTwoNumbersR(ListNode l1, ListNode l2) {
        StringBuilder s1=new StringBuilder("");
        StringBuilder s2=new StringBuilder("");
        while (l1!=null){
            s1.append(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            s2.append(l2.val);
            l2=l2.next;
        }

        int n1=s1.length()-1;
        int n2=s2.length()-1;
        int jin=0;
        StringBuilder res=new StringBuilder("");
        while (n1>=0||n2>=0||jin!=0){
            if(n1>=0) jin+=s1.charAt(n1--)-'0';
            if(n2>=0) jin+=s2.charAt(n2--)-'0';
            res.append(jin%10);
            jin/=10;
        }

        ListNode head = new ListNode(-1);
        ListNode temp=head;
        for (int i = 0; i <res.length(); i++) {
            temp.next=new ListNode(res.charAt(i)-'0');
            temp= temp.next;
        }
        return head.next;
    }
}
