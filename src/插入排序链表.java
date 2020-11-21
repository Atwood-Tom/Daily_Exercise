import java.util.Scanner;

public class 插入排序链表 {
    //链接:https://leetcode-cn.com/problems/insertion-sort-list/
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newhead=new ListNode(Integer.MIN_VALUE);
        newhead.next=head;
        ListNode tail=head;
        ListNode cur=head.next;
        tail.next=null;
        while(cur!=null){
            ListNode next=cur.next;
            ListNode p=newhead;
            for (;p.next!=cur&&p.next!=null&&p.next.val<cur.val;p=p.next);
            if (p.next==null){
                tail.next=cur;
                tail=tail.next;
                tail.next=null;
                cur=next;
            }else {
                cur.next=p.next;
                p.next=cur;
                cur=next;
            }
        }
        return newhead.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode newhead=new ListNode(Integer.MIN_VALUE);
        for (ListNode cur=head;cur!=null;cur=cur.next){
            ListNode insert=new ListNode(cur.val);
            ListNode a=newhead;
            for (;a.next!=null;a=a.next){
                if (a.val<=insert.val&&a.next.val>=insert.val){
                    insert.next=a.next;
                    a.next=insert;
                    break;
                }
            }
            if (a.next==null){
                a.next=insert;
            }
        }
        return newhead.next;
    }
    public static ListNode insertionSortList3(ListNode head){
        if (head==null&&head.next==null){
            return head;
        }
        ListNode newhead=new ListNode(Integer.MIN_VALUE);
        ListNode next=head.next;
        for (;head!=null;head=next){
            ListNode pre=newhead;
            next=head.next;
            for (;pre.next!=null&&pre.next.val<head.val;pre=pre.next);
            head.next=pre.next;
            pre.next=head;
        }
        return newhead.next;
    }
    public static void main(String[] args) {
        ListNode head=create();
        head=insertionSortList3(head);
        for (ListNode pre = head; pre!=null; pre=pre.next){
            System.out.println(pre.val);
        }
    }

    private static ListNode create() {
        Scanner sc=new Scanner(System.in);
        ListNode head=null;
        ListNode last=null;
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            if (x==-1){
                break;
            }
            if (head==null){
                head=new ListNode(x);
                last=head;
            }else {
                ListNode cur=new ListNode(x);
                last.next=cur;
                last=last.next;
            }
        }
        return head;
    }
}
