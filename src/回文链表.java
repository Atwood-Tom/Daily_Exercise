import java.util.Deque;
import java.util.LinkedList;

public class 回文链表 {
    //链接:https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
    public boolean isPalindrome1(ListNode head) {
        Deque<Integer> deque=new LinkedList<>();
        for (ListNode p=head;p!=null;deque.addLast(p.val),p=p.next);
        while(!deque.isEmpty()){
            int x=deque.pollFirst();
            if (deque.isEmpty()){
                return true;
            }
            int y=deque.pollLast();
            if (x!=y){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(ListNode head) {
        if (head==null){
            return true;
        }
        int length=0;
        for (ListNode p=head;p!=null;length++,p=p.next);
        int arr[]=new int[length];
        length=0;
        for (ListNode p=head;p!=null;arr[length]=p.val,p=p.next,length++);
        for (int i=0,j=arr.length-1;i<j;i++,j--){
            if (arr[i]!=arr[j]){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome3(ListNode head){
        int length=0;
        for (ListNode p=head;p!=null;length++,p=p.next);
        ListNode cur=head;
        for (int i=1;i<=length/2;i++,cur=cur.next);
        ListNode after=null;
        ListNode newhead=null;
        for (;cur!=null;){
            ListNode next=cur.next;
            if (next==null){
                newhead=cur;
            }
            cur.next=after;
            after=cur;
            cur=next;
        }
        for (ListNode p=head,q=newhead;p!=null&&q!=null;p=p.next,q=q.next){
            if (p.val!=q.val){
                return false;
            }
        }
        return true;
    }
}
