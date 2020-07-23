public class 单链表的逆转 {
    //链接:https://www.nowcoder.com/questionTerminal/33e343e6d5df40bc9b3a26b01c82a718
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode newhead=null;
        ListNode left=null;
        ListNode mid=head;
        while(mid!=null){
            ListNode right=mid.next;
            if (right==null){
                newhead=mid;
            }
            mid.next=left;
            left=mid;
            mid=right;
        }
        return newhead;
    }
    public ListNode ReverseList1(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newhead=new ListNode(head.val);
        ListNode left=head.next;
        for (;left!=null;){
            ListNode right=left.next;
            left.next=newhead;
            newhead=left;
            left=right;
        }
        return newhead;
    }
}
