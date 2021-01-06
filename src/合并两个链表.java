public class 合并两个链表 {
    //链接:https://leetcode-cn.com/problems/merge-in-between-linked-lists/
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode newhead=new ListNode(0);
        newhead.next=list1;
        ListNode p=newhead;
        ListNode q=newhead;
        for (int i=0;i<b+1;i++){
            if (i<a){
                p=p.next;
            }
            q=q.next;
        }
        q=q.next;
        if (list2==null){
            p.next=q;
            return newhead.next;
        }
        ListNode end=list2;
        for (;end.next!=null;end=end.next);
        p.next=list2;
        end.next=q;
        return newhead.next;
    }
}
