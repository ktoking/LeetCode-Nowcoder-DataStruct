package LeetCode.swordToOffer;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class Offer_8_3_22 {

    /**
     * 双指针，快指针先走k步，然后快慢指针一起走，走到头返回满指针即可
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null) return null;
        ListNode fast=head,slow=head;
        int t=0;
        while (fast!=null){
            if(t>=k)slow=slow.next;
            fast=fast.next;
            t++;
        }
        return slow;
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode f=head,l=head;
        while (k-->0){
            f=f.next;
        }
        while (f!=null){
            f=f.next;
            l=l.next;
        }
        return l;
    }

}
