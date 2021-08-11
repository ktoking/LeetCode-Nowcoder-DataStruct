package LeetCode.swordToOffer;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Offer_8_4_25 {

    /**
     * 递归解法，可以这样去想
     * L1:  1->2->3
     * L2:  4->5->6
     * 那么每次我们递归进去把第一条链表递归到最后，那么就应该递归合并L2 ，应该串在L1后面，所以 l1.next=mergeTwoLists(l1.next,l2);
     * 记得要返回，不然上一次归取不到值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        if(l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    /**
     * 迭代解法,新建一个结点，看谁小就加进去
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode newHead=new ListNode(-1),temp=newHead;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
               temp.next=l1;
               l1=l1.next;
            }else {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        temp.next=l1==null?l2:l1;
        return newHead.next;
    }
}
