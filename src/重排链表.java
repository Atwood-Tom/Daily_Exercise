import java.util.ArrayList;
import java.util.List;

public class 重排链表 {
  //链接:https://leetcode-cn.com/problems/reorder-list/
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public void reorderList1(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        for (ListNode p=head;p!=null;list.add(p),p=p.next);
        int i=0;
        int j=list.size()-1;
        while (i < j) {
          list.get(i).next = list.get(j);
          i++;
          if (i == j) {
            break;
          }
          list.get(j).next = list.get(i);
          j--;
        }
          list.get(i).next = null;
    }
    public void reorderList(ListNode head){
      ListNode newhead=null;
      ListNode pre,cur;
      pre=cur=head;
      for (;pre.next!=null&&pre.next.next!=null;cur=cur.next,pre=pre.next.next);
      if (pre.next!=null){
        cur=cur.next;
      }
      pre=null;
      while(cur!=null){
        ListNode next=cur.next;
        if (next==null){
          newhead=cur;
        }
        cur.next=pre;
        pre=cur;
        cur=next;
      }
      for (ListNode q=newhead,p=head;p!=null&&q!=null;){
        ListNode a=p.next;
        ListNode b=q.next;
        p.next=q;
        if (a==q){
          break;
        }
        q.next=a;
        p=a;
        q=b;
      }
    }
}
