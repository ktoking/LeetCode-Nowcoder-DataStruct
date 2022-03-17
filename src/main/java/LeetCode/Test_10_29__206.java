package LeetCode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Test_10_29__206 {
    /**
     * 迭代法,头插法而已
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode temp=head,next=null;
        ListNode newHead=new ListNode(-1);
        while (temp!=null){
            next=temp.next;
            temp.next=newHead.next;
            newHead.next=temp;
            temp=next;
        }
        return newHead.next;
    }

    /**
     * 递归写法,这大哥太牛了
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return cur;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead=new ListNode(-1);
        ListNode temp=null;
        while (head!=null){
            temp=head.next;
            head.next=newHead.next;
            newHead.next=head;
            head=temp;
        }
        return newHead.next;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList3(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
