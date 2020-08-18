package LeetCode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Test_8_18__109 {

    /**
     * 双指针解法：递归
     * 首先我们观察，链表最中间的值就是根节点，根节点左边链表就是他的左子树，右边链表就是右子树
     * 那我们不断的找到根节点然后串起来连到根节点就行了，那就思考递归
     * 递归不要想太复杂，我们不要深入递归取思考怎莫作的，我们只考虑返回了什么
     * 如果当前链表为空就返回空，如果链表就一个值，那么他自己就是根节点返回
     * 我们由上面思考，需要断开链表来串，单链表肯定是要找到断掉链表的前一个节点才行，借由快慢指针找到中间节点
     * 并找到中间节点的前面一个节点，断开，那么中间节点就是根节点，递归的串左边链表的值与右边链表的值
     * 返回这个根节点就行
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);

        ListNode fast=head,low=head,pre=null;
        while (fast!=null&&fast.next!=null){
            pre=low;
            low=low.next;
            fast=fast.next.next;
        }
        pre.next=null;
        TreeNode node = new TreeNode(low.val);
        node.right = sortedListToBST(low.next);
        node.left = sortedListToBST(head);
        return node;
    }
}
