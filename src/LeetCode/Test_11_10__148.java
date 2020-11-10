package LeetCode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */
public class Test_11_10__148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    /**
     * (归并排序)
     * 先找到链表的中点,用快慢指针,然后断开链表,但是要记录low的下一个节点
     * 然后递归head 与low的下一个节点
     * 最后用新头指针穿起来这个节点
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode low=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
        }
        ListNode temp=low.next;
        low.next=null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(temp);
        ListNode newhead=new ListNode(-1);
        ListNode tt=newhead;
        while (left!=null&&right!=null){
            if(left.val>right.val){
                tt.next=right;
                right=right.next;
            }else {
                tt.next=left;
                left=left.next;
            }
            tt=tt.next;
        }
        tt.next=left==null?right:left;
        return newhead.next;
    }
}
