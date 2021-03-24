import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}
public class 每K个一组反转链表 {
    //牛客网链接:https://www.nowcoder.com/practice/a632ec91a4524773b8af8694a51109e7?tpId=98&tqId=33028&tPage=1&rp=1&ru=/ta/2019test&qru=/ta/2019test/question-ranking
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        ListNode pre=newhead;
        ListNode end=newhead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++,end = end.next);
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return newhead.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s =sc.nextLine().split(" ");
        ListNode head=new ListNode(0);
        ListNode tail=head;
        int length=0;
        for (;length<s.length;length++){
            tail.next=new ListNode(Integer.parseInt(s[length]));
            tail=tail.next;
        }
        int x=sc.nextInt();
        head=reverseKGroup(head.next,x);
        for (ListNode t = head; t!=null; t=t.next){
            if (t.next==null) {
                System.out.print(t.val);
            }else{
                System.out.print(t.val+" ");
            }
        }
    }
}
