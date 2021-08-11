package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Test_10_20__143 {
    /**
     * 重排链表,使用list先存储链表元素,再依次串起来
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode temp=head;
        List<ListNode> list=new ArrayList<>();
        while (temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        int l=0,r=list.size()-1 ;
        while (l<r){
            list.get(l).next=list.get(r);
            l++;
            if(l==r) break;
            list.get(r).next=list.get(l);
            r--;
        }
        list.get(r).next=null;
    }
}
