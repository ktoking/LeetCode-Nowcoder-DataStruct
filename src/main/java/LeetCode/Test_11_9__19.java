package LeetCode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Test_11_9__19 {
    /**
     * 双指针，但使用一个前缀节点来保存删除节点的前一个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump=new ListNode(-1);
        dump.next=head;
        ListNode pre=dump,fast=head,low=head;
        while (n-->0){
            fast=fast.next;
        }
        while (fast!=null){
            pre=pre.next;
            fast=fast.next;
            low=low.next;
        }
        pre.next=low.next;
        return dump.next;
    }
}
