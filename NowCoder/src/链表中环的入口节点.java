public class 链表中环的入口节点 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode pre,cur;
        pre=head;
        cur=head;
        while(pre.next!=null&&pre.next.next!=null){
            pre=pre.next.next;
            cur=cur.next;
            if(pre==cur){
                pre=head;
                for(;pre!=cur;pre=pre.next,cur=cur.next);
                return pre;
            }
        }
        return null;
    }
}
