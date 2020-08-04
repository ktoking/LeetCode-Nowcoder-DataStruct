package LeetCode.swordToOffer;


import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }


public class Offer_7_19_06 {

    /**
     *
     * 首先获取链表长度,然后倒序放进数组中就ok
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[0];
        int count=0;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            count++;
        }
        int[] arr=new int[count];
        for (int i = 0; i < count; i++) {
            arr[count-i-1]=head.val;
            head=head.next;
        }
        return arr;
    }

    /**
     * 用栈来反转
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head){
        if(head==null) return new int[0];
        Stack<Integer> stack=new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] arr=new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=stack.pop();
        }
        return arr;
    }
}


