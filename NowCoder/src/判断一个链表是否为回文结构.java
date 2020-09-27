import java.util.Deque;
import java.util.LinkedList;

public class 判断一个链表是否为回文结构 {
    //链接:https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=191&&tqId=35238&rp=1&ru=/activity/oj&qru=/ta/job-code-high-algorithm/question-ranking
   public class ListNode {
    int val;
    ListNode next = null;
  }
    //方法一:
    public boolean isPail_MethodOne (ListNode head) {
        // write code here
        Deque<Integer> deque=new LinkedList<>();
        for (ListNode p=head;p!=null;p=p.next){
            deque.addLast(p.val);
        }
        while(!deque.isEmpty()){
            int a=deque.pollFirst();
            if (deque.isEmpty()){
                return true;
            }
            int b=deque.pollLast();
            if (a!=b){
                return false;
            }
        }
        return true;
    }
    //方法二
    public boolean isPail_MethodTwo (ListNode head){
       int length=0;
       for (ListNode p=head;p!=null;p=p.next,length++);
       ListNode pre=head,cur=null;
       ListNode newHead=null;
       for (int i=length/2;i>0;i--,pre=pre.next);
       while(pre!=null){
           ListNode next=pre.next;
           if (next==null){
               newHead=pre;
           }
           pre.next=cur;
           cur=pre;
           pre=next;
       }
       while(newHead!=null){
           if (head.val!=newHead.val){
               return false;
           }
           head=head.next;
           newHead=newHead.next;
       }
       return true;
    }
}
