public class 合并两个有序链表 {
    //链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a=l1;
        ListNode b=l2;
        ListNode newHead=new ListNode(0);
        ListNode tail=newHead;
        for (;a!=null&&b!=null;){
            if (a.val>b.val){
                tail.next=b;
                b=b.next;
                tail=tail.next;
            }else {
                tail.next=a;
                a=a.next;
                tail=tail.next;
            }
        }
        while(a!=null){
            tail.next=a;
            a=a.next;
            tail=tail.next;
        }
        while(b!=null){
            tail.next=b;
            b=b.next;
            tail=tail.next;
        }
        return newHead;
    }
}
