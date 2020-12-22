package LeetCode;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Test_12_22__234 {

    /**
     * 首先快慢指针走找到中点,然后反转后半部分,最后逐一判断链表值是否相同即可
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode f = head, l = head;
        while (f.next != null&&f.next.next!=null) {
            f = f.next.next;
            l = l.next;
        }
        ListNode next = null, cur = l.next;
        l.next = null;
        ListNode newHead = new ListNode(-1);
        while (cur != null) {
            next=cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        ListNode l1=newHead.next;
        while (head != null&&l1!=null){
            if(head.val!=l1.val) return false;
            head=head.next;l1=l1.next;
        }
        return true;
    }
}
