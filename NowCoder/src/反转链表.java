import java.util.List;

public class 反转链表 {
    //链接:https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=188&&tqId=35529&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode newhead=null;
        ListNode pre=head;
        ListNode cur=null;
        while(pre!=null){
            ListNode next=pre.next;
            if (next==null){
                newhead=pre;
            }
            pre.next=cur;
            cur=pre;
            pre=next;
        }
        return newhead;
    }
}
