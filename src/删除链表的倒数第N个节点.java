import java.util.Scanner;

//链接:https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
public class 删除链表的倒数第N个节点 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        int length=0;
        for (ListNode t=head;t!=null;t=t.next,length++);
        for (head=newhead;head!=null&&length-n>0;head=head.next,length--);
        head.next=head.next.next;
        return newhead.next;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int x=sc.nextInt();
        ListNode head=new ListNode(Integer.parseInt(s[0]));
        ListNode tail=head;
        for (int i=1;i<s.length;i++){
            tail.next=new ListNode(Integer.parseInt(s[i]));
            tail=tail.next;
        }
        head=removeNthFromEnd(head,x);
        for (ListNode t=head;t!=null;t=t.next){
            if(t.next!=null){
                System.out.print(t.val+" ");
            }else{
                System.out.print(t.val);
            }
        }
    }
}
