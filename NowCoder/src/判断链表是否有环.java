public class 判断链表是否有环 {
    //链接:https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=188&&tqId=35516&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null&&slow!=null){
            if (fast==slow){
                return true;
            }
            if (fast.next==null||fast.next.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
