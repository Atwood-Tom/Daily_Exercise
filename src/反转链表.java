public class 反转链表 {
    //链接：https://leetcode-cn.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode pre=head;
        ListNode cur=null;
        ListNode newHead=null;
        for (;pre!=null;){
            ListNode next=pre.next;
            if (next==null){
                newHead=pre;
            }
            pre.next=cur;
            cur=pre;
            pre=next;
        }
        return newHead;
    }
}
