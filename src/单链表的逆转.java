public class 单链表的逆转 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode newhead=null;
        ListNode pre=null;
        ListNode mid=head;
        while(mid!=null){
            ListNode last=mid.next;
            if (last==null){
                newhead=mid;
            }
            mid.next=pre;
            pre=mid;
            mid=last;
        }
        return newhead;
    }
}
