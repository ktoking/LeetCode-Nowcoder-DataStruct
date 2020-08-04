package LeetCode.swordToOffer;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class Offer_8_4_24 {

    /**
     * 反转链表，借助新节点，记录下一节点，头插法即可反转链表
     * 内存消耗最小
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode newHead=new ListNode(-1);
        ListNode nextNode;
        while (head!=null){
            nextNode=head.next;
            head.next=newHead.next;
            newHead.next=head;
            head=nextNode;
        }
        return newHead.next;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return cur;
    }

    /**
     * 三指针算法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head==null) return null;
        ListNode cur=head,pre=null,nextn=null;
        while (cur!=null){
            nextn=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextn;
        }
        return pre;
    }
}
