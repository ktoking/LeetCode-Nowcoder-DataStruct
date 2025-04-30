package LeetCode.D2025;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 *给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 */
public class Test_4_30__86 {

    public ListNode partition(ListNode head, int x) {
        ListNode sh=new ListNode(-1);
        ListNode lh=new ListNode(-1);
        ListNode s=sh,l=lh;
        while (head!=null){
            if(head.val<x){
                s.next=head;
                s=s.next;
            }else{
                l.next=head;
                l=l.next;
            }
            head=head.next;
        }
        s.next=lh.next;
        l.next=null;
        return sh.next;
    }
}
