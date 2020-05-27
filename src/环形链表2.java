import java.util.Scanner;

public class 环形链表2 {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast,last;
        fast=head;
        last=head;
        for (;fast!=null&&fast.next!=null;){
            fast=fast.next.next;
            last=last.next;
            if (fast==last){
                break;
            }
        }
        if (fast==null||fast.next==null){
            return null;
        }
        for (fast=head;fast!=last;fast=fast.next,last=last.next);
        return fast;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        ListNode head=new ListNode(Integer.parseInt(s[0]));
        ListNode tail=head;
        for (int i = 1; i < s.length; i++) {
            tail.next=new ListNode(Integer.parseInt(s[i]));
            tail=tail.next;
        }
        detectCycle(head);
    }
}
