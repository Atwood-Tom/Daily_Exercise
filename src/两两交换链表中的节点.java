public class 两两交换链表中的节点 {
    //链接:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newhead=head.next;
        ListNode pre=head;
        ListNode cur=head.next;
        while(true){
            ListNode next=cur.next;
            cur.next=pre;
            if (next==null||next.next==null){
                pre.next=next;
                break;
            }
            pre.next=next.next;
            cur=pre.next;
            pre=next;
        }
        return newhead;
    }
}
