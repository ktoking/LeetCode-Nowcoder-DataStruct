package LeetCode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Test_11_11__21 {

    /**
     * 合并有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        ListNode head=new ListNode(-1),temp=head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val) {
                temp.next=l1;
                l1=l1.next;
            }else {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        temp.next=l1==null?l2:l1;
        return head.next;
    }
}
