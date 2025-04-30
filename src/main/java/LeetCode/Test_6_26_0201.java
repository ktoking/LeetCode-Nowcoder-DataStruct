package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

 示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
 示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
 提示：

 链表长度在[0, 20000]范围内。
 链表元素在[0, 20000]范围内。
 进阶：

 如果不得使用临时缓冲区，该怎么解决？
 */


public class Test_6_26_0201 {

    /**
     * 非常容易想到的办法,set,当下一个list的值存在与set中,那就删除掉当前节点,不存在就加入到set中,要考虑到删除当前节点需要知道上一个节点是谁,所以用一个新的节点找下一个节点在不在set中,如果存在,那么要删除的上一个节点就是当前节点
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newhead=new ListNode(-1);
        newhead.next=head;
        ListNode temp=newhead;
        Set<Integer> set=new HashSet<>();
        while(temp.next!=null){
            if(set.contains(temp.next.val)){
                temp.next=temp.next.next; //因为这里已经删除了下一个节点,并且指向了下一个节点,那就直接不用向下一个节点迭代
            }else {
                set.add(temp.next.val);
                temp=temp.next;
            }
        }
        return newhead.next;
    }



}

